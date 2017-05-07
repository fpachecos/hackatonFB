/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.validation.rule;

import javax.ejb.Stateless;

import br.com.cielo.settlement.entity.RefundRulesEnum;

/**
 * Classe para tratar processamento de ajustes financeiros
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialAdjustmentRulesImpl.java 59434 2016-03-11 18:05:53Z eyvdbm $
 */
@Stateless
public class FinancialAdjustmentRulesImpl extends FinancialAdjustmentRules {

    /**
     * {@link RefundRulesEnum} Constantes de regras de reembolso
     */
    private RefundRulesEnum rule;


    public FinancialAdjustmentRulesImpl(){
        super();
    }

    /**
     * Construtor.
     *
     * @param rule RefundRulesEnum
     */
    public FinancialAdjustmentRulesImpl(final RefundRulesEnum rule) {
        super();
        this.rule = rule;
    }

    /**
     * Retorna o valor de rule
     *
     * @return rule
     */
    public RefundRulesEnum getRule() {
        return this.rule;
    }

    /**
     * Processa um Refund realizando o calculo da data de ajuste
     *
     * @param rule RefundRulesEnum
     */

    public void setRule(final RefundRulesEnum rule) {
        this.rule = rule;
    }

}
