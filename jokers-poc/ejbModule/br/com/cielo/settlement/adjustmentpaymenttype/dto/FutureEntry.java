package br.com.cielo.settlement.adjustmentpaymenttype.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.settlement.entity.Product;

/**
 * Classe utilizada para ajuste de pagamento.
 *
 * @author <a href="mailto:eyve2j@prestadorcbmp.com.br>Samuel Oliveira Santos</a>
 * @version $Id$
 *
 */
public class FutureEntry {

  /**
   * Campo product do tipo Product
   */
  private Product product;
  /**
   * Campo dtSettlement do tipo Date
   */
  private Date dtSettlement;
  /**
   * Campo netValue do tipo BigDecimal
   */
  private BigDecimal netValue;

  /**
   * MovementStatus
   */
  private Integer cdMovementStatus;

  /**
   * Construtor
   */
  public FutureEntry() {}

  /**
   * Construtor
   *
   * @param product
   * @param dtSettlement
   * @param netValue
   */
  public FutureEntry(final Product product, final Date dtSettlement, final BigDecimal netValue,
      final Integer cdMovementStatus) {
    super();
    this.product = product;
    this.dtSettlement = dtSettlement;
    this.netValue = netValue;
    this.cdMovementStatus = cdMovementStatus;
  }

  /**
   * M�todo get do atributo product
   *
   * @return O valor do atributo product
   */
  public Product getProduct() {
    return this.product;
  }

  /**
   * M�todo set do atributo product
   *
   * @param product Valor para setar no atributo product
   */
  public void setProduct(final Product product) {
    this.product = product;
  }

  /**
   * M�todo get do atributo dtSettlement
   *
   * @return O valor do atributo dtSettlement
   */
  public Date getDtSettlement() {
    return this.dtSettlement;
  }

  /**
   * M�todo set do atributo dtSettlement
   *
   * @param dtSettlement Valor para setar no atributo dtSettlement
   */
  public void setDtSettlement(final Date dtSettlement) {
    this.dtSettlement = dtSettlement;
  }

  /**
   * M�todo get do atributo netValue
   *
   * @return O valor do atributo netValue
   */
  public BigDecimal getNetValue() {
    return this.netValue;
  }

  /**
   * M�todo set do atributo netValue
   *
   * @param netValue Valor para setar no atributo netValue
   */
  public void setNetValue(final BigDecimal netValue) {
    this.netValue = netValue;
  }

  public Integer getCdMovementStatus() {
    return this.cdMovementStatus;
  }

  public void setCdMovementStatus(final Integer cdMovementStatus) {
    this.cdMovementStatus = cdMovementStatus;
  }

  @Override
  public int hashCode() {
    if (this.getProduct() != null && this.getProduct().getCode() != null) {
      return this.getProduct().getCode().hashCode();
    } else {
      return this.hashCode();
    }

  }

  @Override
  public boolean equals(final Object another) {
    if (another instanceof FutureEntry && this.getProduct() != null
        && this.getProduct().getCode() != null && this.getDtSettlement() != null) {

      FutureEntry lFutureEntryAnother = (FutureEntry) another;
      return this.getProduct().getCode().equals(lFutureEntryAnother.getProduct().getCode())
          && this.getDtSettlement().compareTo(lFutureEntryAnother.getDtSettlement()) == 0;

    }

    return super.equals(another);
  }

}
