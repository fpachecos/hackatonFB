/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.validation.rule;

import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementMovement;

/**
 * CriaÃ§Ã£o de ajuste e movimento de acordo com regras de ajuste
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialAdjustmentRules.java 58257 2016-02-29 16:21:23Z
 *          waldeir $
 */
public interface FinancialAdjustmentRules {

    SettlementMovement createFinancialMovement(final SettlementAdjustment adjustment, final Integer codCurrency);
}