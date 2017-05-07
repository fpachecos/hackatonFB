package br.com.cielo.settlement.validation.validator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.validation.rule.FinancialAdjustmentRules;

/**
 * Classe de validações de Refund.
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: SettlementValidations.java 80399 2016-11-25 18:16:12Z eyve4g $
 */
@Stateless
public class SettlementValidations extends BaseValidations {

    @EJB
    private transient FinancialAdjustmentRules financialAdjustmentRules;

    /**
     * Criar validador para ajuste, e retorna movimento
     *
     * @param adjustment
     *            SettlementAdjustment
     * @return SettlementMovement
     */
    public SettlementMovement createMovementByAdjustment(final SettlementAdjustment adjustment,
                    final Integer codCurrency) {
        return this.financialAdjustmentRules.createFinancialMovement(adjustment, codCurrency);
    }
}