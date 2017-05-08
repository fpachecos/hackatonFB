package br.com.cielo.settlement.adjustmentpaymenttype.service;

import br.com.cielo.settlement.adjustmentpaymenttype.filter.AdjustPaymentTypeFilter;
import br.com.cielo.settlement.entity.Product;


/**
 * Classes de servi�os para determinar o produto para ajustes que n�o cont�m o tipo de pagamento.
 *
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 */
public interface AdjustPaymentTypeService {

  /**
   * Determina o tipo de pagamento para o ajustes de tipo gen�ricos - D�bito e Cr�dito.
   *
   * @param filter adjustPaymentTypeFilter
   * @return Product product
   */
  public Product getAdjustmentProduct(AdjustPaymentTypeFilter filter);
}
