package br.com.cielo.settlement.adjustmentpaymenttype.service;

import br.com.cielo.settlement.adjustmentpaymenttype.filter.AdjustPaymentTypeFilter;
import br.com.cielo.settlement.entity.Product;


/**
 * Classes de serviços para determinar o produto para ajustes que não contém o
 * tipo de pagamento.
 *
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 */
public interface AdjustPaymentTypeService {

    /**
     * Determina o tipo de pagamento para o ajustes de tipo genéricos - Débito e Crédito.
     *
     * @param filter adjustPaymentTypeFilter
     * @return Product product
     */
    public Product getAdjustmentProduct(AdjustPaymentTypeFilter filter);
}
