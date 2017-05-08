package br.com.cielo.settlement.adjustmentpaymenttype.filter;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.settlement.entity.MovementTypeEnum;

/**
 * Classe de representacao dos paramentros para obter o produto para ajustes que n�o cont�m o tipo
 * de pagamento.
 *
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 *
 */
public class AdjustPaymentTypeFilter {

  /**
   * Identificador do EC
   */
  private Long nuCustomer;

  /**
   * Valor do ajuste
   */
  private BigDecimal adjustValue;

  /**
   * Data de liquida��o da requisi��o do ajuste
   */
  private Date dtSettlement;

  private MovementTypeEnum movementType;


  /**
   * M�todo get do atributo nuCustomer
   *
   * @return O valor do atributo nuCustomer
   */
  public Long getNuCustomer() {
    return this.nuCustomer;
  }

  /**
   * M�todo set do atributo nuCustomer
   *
   * @param nuCustomer Valor para setar no atributo nuCustomer
   */
  public void setNuCustomer(final Long nuCustomer) {
    this.nuCustomer = nuCustomer;
  }

  /**
   * Date Settlement Original
   * 
   * @return
   */
  public Date getDtSettlement() {
    return dtSettlement;
  }

  public void setDtSettlement(Date dtSettlement) {
    this.dtSettlement = dtSettlement;
  }

  /**
   * M�todo get do atributo adjustValue
   * 
   * @return O valor do atributo adjustValue
   */
  public BigDecimal getAdjustValue() {
    return adjustValue;
  }

  /**
   * M�todo set do atributo adjustValue
   * 
   * @param adjustValue Valor para setar no atributo adjustValue
   */
  public void setAdjustValue(BigDecimal adjustValue) {
    this.adjustValue = adjustValue;
  }


  public MovementTypeEnum getMovementType() {
    return movementType;
  }

  public void setMovementType(MovementTypeEnum movementType) {
    this.movementType = movementType;
  }



  /**
   * Classe Builder do filtro para direcionamento do produto do ajuste
   * 
   * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
   * @version $Id$
   *
   */
  public static class AdjustPaymentTypeFilterBuilder {
    private AdjustPaymentTypeFilter filter;

    public AdjustPaymentTypeFilterBuilder() {
      this.filter = new AdjustPaymentTypeFilter();
    }

    public AdjustPaymentTypeFilterBuilder nuCustomer(Long nuCustomer) {
      this.filter.setNuCustomer(nuCustomer);
      return this;
    }

    public AdjustPaymentTypeFilterBuilder adjustValue(BigDecimal adjustValue) {
      this.filter.setAdjustValue(adjustValue);
      return this;
    }

    public AdjustPaymentTypeFilterBuilder dtSettlement(Date dtSettlement) {
      this.filter.setDtSettlement(dtSettlement);
      return this;
    }

    public AdjustPaymentTypeFilterBuilder movementType(MovementTypeEnum movementType) {
      this.filter.movementType = movementType;
      return this;
    }

    public AdjustPaymentTypeFilter build() {
      return this.filter;
    }
  }
}
