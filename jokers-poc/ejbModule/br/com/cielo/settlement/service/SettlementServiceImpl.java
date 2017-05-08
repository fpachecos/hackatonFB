package br.com.cielo.settlement.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.com.cielo.common.util.DateUtils;
import br.com.cielo.settlement.entity.ContractedProduct;
import br.com.cielo.settlement.entity.SettlementTypeEnum;
import br.com.cielo.settlement.infrastructure.config.SettlementCreditDate;

/**
 * Implementa��o da inteface de servi�o para Settlement.
 *
 * @author waldeir
 * @version $Id: SettlementServiceImpl.java 82480 2017-01-26 11:24:11Z t0112jff $
 */
@Stateless
public class SettlementServiceImpl implements SettlementService {

  @SettlementCreditDate
  private Date settlementDateCredit;

  @SettlementCreditDate
  private Date settlementDateDebit;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.cielo.settlement.batch.service.SettlementService#getContractedProduct
   * (java.util.List, boolean)
   */
  @Override
  public ContractedProduct getContractedProduct(final List<ContractedProduct> contratedProducts,
      final boolean needsActiveProduct) {

    ContractedProduct priorityChosenProduct = new ContractedProduct();

    return priorityChosenProduct;
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.cielo.settlement.batch.service.SettlementService#adjustSettlementDate
   * (java.util.Date, java.lang.String)
   */
  @Override
  public Date adjustSettlementDate(final Date settlementDate, final String settlementType) {
    Date correctedDate = null;
    if (SettlementTypeEnum.CREDIT.getCode().equals(settlementType)) {
      correctedDate = this.settlementDateCredit;
    } else {
      correctedDate = this.settlementDateDebit;

    }
    return DateUtils.max(settlementDate, correctedDate);
  }

  @Override
  public Integer getCodCurrencyByCustomerNumber(String customerNumber) {
    return 986;// TODO Mock
  }
}
