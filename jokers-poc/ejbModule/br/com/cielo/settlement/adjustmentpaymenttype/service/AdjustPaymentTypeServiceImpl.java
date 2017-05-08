package br.com.cielo.settlement.adjustmentpaymenttype.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cielo.settlement.adjustmentpaymenttype.dto.DomicileBankAdjust;
import br.com.cielo.settlement.adjustmentpaymenttype.dto.DomicileBankAdjustProduct;
import br.com.cielo.settlement.adjustmentpaymenttype.dto.DomicilieProduct;
import br.com.cielo.settlement.adjustmentpaymenttype.dto.FutureEntry;
import br.com.cielo.settlement.adjustmentpaymenttype.filter.AdjustPaymentTypeFilter;
import br.com.cielo.settlement.entity.ContractedProduct;
import br.com.cielo.settlement.entity.MovementStatusEnum;
import br.com.cielo.settlement.entity.PaymentCategoryEnum;
import br.com.cielo.settlement.entity.Product;
import br.com.cielo.settlement.entity.SettlementTypeEnum;
import br.com.cielo.settlement.repository.AdjustPaymentTypeRepository;
import br.com.cielo.settlement.repository.ContractedProductRepository;
import br.com.cielo.settlement.service.SettlementService;

/**
 * Implementação do serviço para manipulação de ajustes financeiros.
 *
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 */
@Stateless
public class AdjustPaymentTypeServiceImpl implements AdjustPaymentTypeService {
  private static final int _1000 = 1000;

  private static final int _60 = 60;

  private static final int _24 = 24;

  @EJB
  private SettlementService settlementService;

  @EJB
  private ContractedProductRepository contractedProductRepository;

  @EJB
  private AdjustPaymentTypeRepository repository;

  /**
   * Determina o tipo de pagamento para o ajustes de tipo genéricos - Débito e Crédito.
   *
   * @param filter adjustPaymentTypeFilter
   * @return Product product
   */
  @Override
  public Product getAdjustmentProduct(final AdjustPaymentTypeFilter filter) {
    DomicileBankAdjustProduct resultConsult = getResultDTO(filter);

    Map<Long, ProductSettlementInformationHolder> mapProductDtSettlement =
        new LinkedHashMap<Long, ProductSettlementInformationHolder>();

    // cria o mapeamento, produto e datas de liquidacao
    /**
     * 11 : {01/02/2010,01/03/2010} 12 : {01/03/2010,01/04/2010,01/05/2010}
     */

    ProductSettlementInformationHolder productInformationHolder = null;
    BigDecimal lValueToAdjustment = null;
    BigDecimal productValue = null;

    boolean isCreditAdjustment = filter.getAdjustValue().compareTo(BigDecimal.ZERO) >= 0;

    // indica se os produtos retornados para decisao são oriundos de debit
    // balance
    boolean containsDebitBalanceProducts = false;

    Product lProductReturn = null;
    if (resultConsult != null && resultConsult.getDomicilies() != null) {
      for (DomicileBankAdjust domicileBankAdjust : resultConsult.getDomicilies()) {
        productInformationHolder = null;
        lValueToAdjustment = null;
        productValue = null;

        for (DomicilieProduct product : domicileBankAdjust
            .getProductsForAdjustment(filter.getAdjustValue())) {
          productValue = product.getTotalNetVaue();

          productInformationHolder =
              mapProductDtSettlement.get(product.getProduct().getCode().longValue());
          if (productInformationHolder == null) {
            productInformationHolder = new ProductSettlementInformationHolder();
            productInformationHolder.product = product.getProduct();
            productInformationHolder.productPriority =
                this.getProductPriority(product.getProduct().getCode());

            mapProductDtSettlement.put(product.getProduct().getCode().longValue(),
                productInformationHolder);
          }

          // adiciona o valor total do produto no holder
          productInformationHolder.addNetValue(productValue);

          lValueToAdjustment = filter.getAdjustValue();

          boolean isProductInDebitBalance = product.isDebitBalance();
          productInformationHolder.isInDebitBalance = isProductInDebitBalance;

          for (FutureEntry lFutureEntry : product.getFutureEntries()) {

            // se for ajuste a debito
            if (!isCreditAdjustment) {

              if (!isProductInDebitBalance) {// se nao estiver em
                                             // debit balance

                lValueToAdjustment = lValueToAdjustment.add(lFutureEntry.getNetValue());
                productInformationHolder.settlementsDate.add(lFutureEntry.getDtSettlement());

                if (lValueToAdjustment.compareTo(BigDecimal.ZERO) >= 0) {
                  break;
                }
              } else {
                // se estiver em debit balance, pegamos apenas
                // os valores retidos
                if (MovementStatusEnum.DEBIT_BALANCE.getCode()
                    .equals(lFutureEntry.getCdMovementStatus())) {
                  productInformationHolder.settlementsDate.add(lFutureEntry.getDtSettlement());
                }

              }

            } else {// se for ajuste a credito

              if (isProductInDebitBalance) {// se o produto
                                            // estiver em
                                            // debitbalance

                containsDebitBalanceProducts = true;

                if (MovementStatusEnum.DEBIT_BALANCE.getCode()
                    .equals(lFutureEntry.getCdMovementStatus())) {
                  lValueToAdjustment = lValueToAdjustment.add(lFutureEntry.getNetValue());
                  productInformationHolder.settlementsDate.add(lFutureEntry.getDtSettlement());

                } else {
                  productInformationHolder.settlementsDate.add(lFutureEntry.getDtSettlement());
                  break;
                }

              }
            }
          }

        }

      }

      // se for ajuste de credito e os produtos sao de debit balance
      // deve ser pegar o produto de maior saldo negativo

      if (isCreditAdjustment && containsDebitBalanceProducts) {

        lProductReturn = calculateMinorTimeSettlementDebitBalance(mapProductDtSettlement);

        // se for um ajuste a credito e nao contem produto com saldo
        // negativo, segue a regra de bandeira
      } else if (isCreditAdjustment && !this.containsNegativeProduts(mapProductDtSettlement)) {

        if (mapProductDtSettlement != null && !mapProductDtSettlement.isEmpty()) {
          // cria um treeset ordernada por prioridade de produto e
          // adiciona todos os produtos
          TreeSet<ProductSettlementInformationHolder> lTreeSetInformationHolder =
              this.createTreeSetInformationHolderOrderByPriority();
          for (ProductSettlementInformationHolder lHolder : mapProductDtSettlement.values()) {
            lTreeSetInformationHolder.add(lHolder);
          }

          // retorna o primeiro produto da lista, pois o mesmo esta
          // ordenado
          return lTreeSetInformationHolder.iterator().next().product;
        }

      } else {

        // utiliza o metodo getMapProductsWithBalance para retornar
        // apenas produtos que sejam suficientes para quitar o ajuste se
        // for ajuste a debito,
        // caso seja um ajuste a credito ou um ajuste a debito que nao
        // contenha produto que seja suficiente para quitar o debito,
        // retorna o proprio mapProductDtSettlement
        lProductReturn = calculateMinorTimeSettlementAndValue(
            this.getMapProductsWithBalance(mapProductDtSettlement, filter.getAdjustValue()));

        // caso o produto nao tenha sido encontrado devido a falta de
        // registro na future entry,
        // deve-se buscar o produto de maior prioridade dos produtos
        // contratados do cliente,
        // ou olha o saldo passado(para debito ao ec) para ver o produto
        // onde h� maior venda
        if (lProductReturn == null) {

          // se for um lancamento a d�bido
          if (BigDecimal.ZERO.compareTo(filter.getAdjustValue()) > 0) {
            lProductReturn =
                this.repository.findDebitProductWithMoreSaleInThirtyDays(filter.getNuCustomer());
          }
        }
      }
      ContractedProduct priorityProduc = null;
      if (lProductReturn == null) {
        priorityProduc =
            this.settlementService.getContractedProduct(this.contractedProductRepository
                .getContractedProductsForMerchant(filter.getNuCustomer()), Boolean.TRUE);

        if (priorityProduc != null) {
          lProductReturn = new Product(priorityProduc.getCodeProduct());
          lProductReturn.setSettlementType(
              priorityProduc.getPaymentCategory().equals(PaymentCategoryEnum.CREDIT)
                  ? SettlementTypeEnum.CREDIT : SettlementTypeEnum.DEBIT);
        } else {
          priorityProduc =
              this.settlementService.getContractedProduct(this.contractedProductRepository
                  .getContractedProductsForMerchant(filter.getNuCustomer()), Boolean.FALSE);
          lProductReturn = new Product(priorityProduc.getCodeProduct());
          lProductReturn.setSettlementType(
              priorityProduc.getPaymentCategory().equals(PaymentCategoryEnum.CREDIT)
                  ? SettlementTypeEnum.CREDIT : SettlementTypeEnum.DEBIT);
        }

      }

    }
    return lProductReturn;
  }

  /**
   * Obtém o DTO referente ao resultado da consulta para a determinação do produto do ajuste.
   *
   * @param filter filter
   */
  private DomicileBankAdjustProduct getResultDTO(final AdjustPaymentTypeFilter filter) {
    return this.repository.getResultDTO(filter);
  }

  /**
   * Obtem a prioridade do produto
   *
   * @param cdProduct
   * @return
   */
  private Integer getProductPriority(final Integer cdProduct) {
    List<Integer> listProductPriority = this.getProdutsPriority();
    int lIndexPriority = -1;
    if (listProductPriority != null && !listProductPriority.isEmpty()) {

      lIndexPriority = listProductPriority.indexOf(cdProduct);
      if (lIndexPriority == -1) {
        lIndexPriority = listProductPriority.size();
      }

    }

    return lIndexPriority;
  }

  /**
   * Obtem a lista de codigo produtos ordenados por prioridades
   *
   * @return
   */
  private List<Integer> getProdutsPriority() {
    List<Integer> productsPriority = new ArrayList<Integer>();
    productsPriority.add(40);
    return productsPriority;
  }

  /**
   * Cria um treeset ordernado por prioridade de produto (regra de bandeira)
   * 
   * @return TreeSet<ProductSettlementInformationHolder>
   */
  private TreeSet<ProductSettlementInformationHolder> createTreeSetInformationHolderOrderByPriority() {
    return new TreeSet<ProductSettlementInformationHolder>(
        new Comparator<ProductSettlementInformationHolder>() {
          @Override
          public int compare(final ProductSettlementInformationHolder priorHolder,
              final ProductSettlementInformationHolder secondHolder) {
            return priorHolder.productPriority.compareTo(secondHolder.productPriority);
          }
        });
  }

  /**
   * Holder que guarda informacoes de produto, liquidacoes, quantidades de dias de liquidacao e
   * prioridade do produto
   *
   * @author moisesb
   */
  static class ProductSettlementInformationHolder {
    public Integer productPriority;
    public Product product;
    public Integer qtDaisSettlement;
    private BigDecimal totalValueNet;
    public boolean isInDebitBalance = false;

    public BigDecimal getTotalValueNet() {
      if (this.totalValueNet == null) {
        return BigDecimal.ZERO;
      } else {
        return this.totalValueNet;
      }
    }

    public void addNetValue(final BigDecimal pValue) {
      if (this.totalValueNet == null) {
        this.totalValueNet = pValue;
      } else if (pValue != null) {
        this.totalValueNet = this.totalValueNet.add(pValue);
      }
    }

    public final Set<Date> settlementsDate = new TreeSet<Date>(new Comparator<Date>() {
      @Override
      public int compare(final Date date1, final Date date2) {
        return date1.compareTo(date2);
      }
    });

  }

  /**
   * Obtem o produto ordenado por data | valor | prioridade
   * 
   * @param mapProductDtSettlement
   * @return
   */
  private Product calculateMinorTimeSettlementDebitBalance(
      final Map<Long, ProductSettlementInformationHolder> mapProductDtSettlement) {

    final Set<ProductSettlementInformationHolder> lProdutsSelecteds =
        new TreeSet<ProductSettlementInformationHolder>(
            new Comparator<ProductSettlementInformationHolder>() {
              @Override
              public int compare(final ProductSettlementInformationHolder priorHolder,
                  final ProductSettlementInformationHolder secondHolder) {

                int lResultCompare = priorHolder.settlementsDate.iterator().next()
                    .compareTo(secondHolder.settlementsDate.iterator().next());

                // se empatar em primeira data mais antiga,
                // compara o valor
                if (lResultCompare == 0) {
                  lResultCompare =
                      priorHolder.getTotalValueNet().compareTo(secondHolder.getTotalValueNet());

                  // se empatar em valor, compara a prioridade
                  if (lResultCompare == 0) {
                    lResultCompare =
                        priorHolder.productPriority.compareTo(secondHolder.productPriority);
                  }
                }

                return lResultCompare;
              }
            });

    Product lProduct = null;

    if (mapProductDtSettlement != null && !mapProductDtSettlement.isEmpty()) {
      // orderna os produtos
      lProdutsSelecteds.addAll(mapProductDtSettlement.values());
      lProduct = lProdutsSelecteds.iterator().next().product;
    }

    return lProduct;
  }

  /**
   * metodo util para retornar apenas produtos que sejam suficientes para quitar o um ajuste a
   * debito, caso seja um ajuste a credito ou um ajuste a debito que nao contenha produto que seja
   * suficiente para quitar o debito, retorna o proprio mapProductDtSettlement
   * 
   * @param mapProductDtSettlement
   * @param adjustValue
   * @return
   */
  private Map<Long, ProductSettlementInformationHolder> getMapProductsWithBalance(
      Map<Long, ProductSettlementInformationHolder> mapProductDtSettlement,
      BigDecimal adjustValue) {

    if (adjustValue.compareTo(BigDecimal.ZERO) < 0) {// se for um ajuste a debito.

      Map<Long, ProductSettlementInformationHolder> mapProductDtSettlementWithBalance =
          new LinkedHashMap<>();
      ProductSettlementInformationHolder lProductSettlementInformationHolder = null;

      BigDecimal lResult = null;
      for (Long pCdproduct : mapProductDtSettlement.keySet()) {

        lProductSettlementInformationHolder = mapProductDtSettlement.get(pCdproduct);

        if (!lProductSettlementInformationHolder.isInDebitBalance) {
          lResult = lProductSettlementInformationHolder.getTotalValueNet().add(adjustValue);
          if (lResult.compareTo(BigDecimal.ZERO) >= 0) {
            mapProductDtSettlementWithBalance.put(pCdproduct, lProductSettlementInformationHolder);
          }
        }
      }

      if (!mapProductDtSettlementWithBalance.isEmpty()) {
        return mapProductDtSettlementWithBalance;
      }


    }


    return mapProductDtSettlement;
  }

  /**
   * Verifica se possuem pelo menos um produto com saldo negativo
   * 
   * @param mapProductDtSettlement
   * @return
   */
  private boolean containsNegativeProduts(
      final Map<Long, ProductSettlementInformationHolder> mapProductDtSettlement) {

    if (mapProductDtSettlement != null) {
      Iterator<ProductSettlementInformationHolder> lItProductSettlementInformationHolder =
          mapProductDtSettlement.values().iterator();
      while (lItProductSettlementInformationHolder.hasNext()) {
        if (lItProductSettlementInformationHolder.next().getTotalValueNet()
            .compareTo(BigDecimal.ZERO) < 0) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * obtem o produto que liquida em menor tempo ou o maior valor se as datas de liquidação forem
   * iguais. Se todos forem iguais, seleciona pela regra de bandeira
   * 
   * @param mapProductDtSettlement
   * @return
   */
  private Product calculateMinorTimeSettlementAndValue(
      final Map<Long, ProductSettlementInformationHolder> mapProductDtSettlement) {

    // lista ordenada por valor e prioridade de produto
    Set<ProductSettlementInformationHolder> lProductsSelecteds =
        createTreeSetInformationHolderOrderByValueAndPriority();

    /**
     * calcula o menor tempo de liquidacao
     */
    int lTimeToSettlement = -1;
    if (!mapProductDtSettlement.isEmpty()) {

      int lTimeToSettlementByProduct = -1;
      ProductSettlementInformationHolder holder = null;

      Date[] dtSettlements = null;
      for (Long cdProduct : mapProductDtSettlement.keySet()) {
        lTimeToSettlementByProduct = 0;
        Date currentDate = new Date();
        holder = mapProductDtSettlement.get(cdProduct);

        // ignora produto em debitbalance
        if (holder.isInDebitBalance) {
          continue;
        }

        // ignora produto em debitbalance
        if (holder.isInDebitBalance) {
          continue;
        }

        // calcula o tempo para liquidacao
        dtSettlements = holder.settlementsDate.toArray(new Date[holder.settlementsDate.size()]);
        for (int i = 0; i < holder.settlementsDate.size(); i++) {
          lTimeToSettlementByProduct +=
              this.getAmountDaysForSettlement(currentDate, dtSettlements[i]);
          currentDate = dtSettlements[i];
        }

        // se for o primeiro item ou o menor
        if (lTimeToSettlement == -1 || lTimeToSettlementByProduct < lTimeToSettlement) {
          lProductsSelecteds.clear();
          lProductsSelecteds.add(holder);
          lTimeToSettlement = lTimeToSettlementByProduct;
        } else if (lTimeToSettlementByProduct == lTimeToSettlement) {// se os tempos forem iguais
                                                                     // adiciona-se na
                                                                     // lista
          lProductsSelecteds.add(holder);
        }
      }

    }

    // caso contenha produto na lista, retorna o primeiro pois ja estar ordenado por menor
    // liquidacao, valor e prioridade
    if (!lProductsSelecteds.isEmpty()) {
      ProductSettlementInformationHolder lFirstHolder = lProductsSelecteds.iterator().next();
      return lFirstHolder.product;
    }

    return null;

  }

  /**
   * Cria um treeset ordenado por Valor ou por prioridade de produto
   * 
   * @return TreeSet<ProductSettlementInformationHolder>
   */
  private TreeSet<ProductSettlementInformationHolder> createTreeSetInformationHolderOrderByValueAndPriority() {
    return new TreeSet<ProductSettlementInformationHolder>(
        new Comparator<ProductSettlementInformationHolder>() {
          @Override
          public int compare(final ProductSettlementInformationHolder priorHolder,
              final ProductSettlementInformationHolder secondHolder) {

            int lResult = priorHolder.totalValueNet.compareTo(secondHolder.totalValueNet) * -1;
            if (lResult == 0) {
              lResult = priorHolder.productPriority.compareTo(secondHolder.productPriority);
            }

            return lResult;
          }
        });
  }

  /**
   * Obtém a quantidade de dias para liquidação da agenda futura do produto.
   *
   * @param dtSettlement data de liquidação
   * @return quantidade de dias para liquidação
   */
  private Integer getAmountDaysForSettlement(final Date dtSettlementStart,
      final Date dtSettlement) {

    Long dataSettlement = dtSettlement.getTime();
    // Subtração dos valores long das datas dividido pela quantidade long de
    // um dia.
    Long amountDaysForSettlement =
        (dataSettlement - dtSettlementStart.getTime()) / (_24 * _60 * _60 * _1000);
    return amountDaysForSettlement.intValue();

  }
}

