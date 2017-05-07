/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.validation.rule;

import javax.ejb.Stateless;

import org.apache.commons.lang3.math.NumberUtils;

import br.com.cielo.settlement.entity.MovementStatusEnum;
import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.entity.SettlementMovementRelAdjustment;

/**
 * CriaÃ§Ã£o de ajuste e movimento de acordo com regras de ajuste
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialAdjustmentRules.java 58257 2016-02-29 16:21:23Z
 *          waldeir $
 */
@Stateless
public class FinancialAdjustmentRules extends BaseRules {

    /**
     * CriaÃ§Ã£o de movimento
     *
     * @param adjustment
     *            SettlementAdjustment
     * @return SettlementMovement
     */
    public SettlementMovement createFinancialMovement(final SettlementAdjustment adjustment, final Integer codCurrency) {

        final SettlementMovement movement = new SettlementMovement();

        movement.setSettlementDate(adjustment.getSettlementAdjstmentDate());
        movement.setGrossMovementValue(adjustment.getAdjustmentAmountValue());
        movement.setDailyDiscountValueAmt(adjustment.getDiscountAmountValue());
        movement.setNetMovementValue(adjustment.getNetAmountValue());
        movement.setSettlementBaseDate(adjustment.getSettlementAdjstmentDate());

        movement.setBatchDate(adjustment.getBatchDate());
        movement.setCustomerNumber(adjustment.getCustomerNumber());
        movement.setCustomerModNumber(adjustment.getCustomerModNumber());
        movement.setLoadFileIdNumber(adjustment.getLoadFileIdNumber());
        movement.setProductCode(adjustment.getProductCode());
        movement.setMovementTypeCode(adjustment.getMovementTypeCode().getCode());

        movement.setNumberFinancialMovement(adjustment.getFinancialMovement());

        movement.setTraceSettlementDate(null);
        movement.setTraceCustomerModNumber(null);
        movement.setTraceNumberFinancialMovement(null);

        final SettlementMovementRelAdjustment movementRelAdjustment = new SettlementMovementRelAdjustment();
        movementRelAdjustment.setNumberFinancialAdjustement(adjustment.getFinancialAdjustmentNumber());
        movementRelAdjustment.setNumberFinancialMovement(adjustment.getFinancialMovement());
        movement.setMovementRelAdjustment(movementRelAdjustment);

        movement.setMovementStatusCode(MovementStatusEnum.PENDING.getCode());
        movement.setFundingCurrencyCode(codCurrency.toString());

        // Dados para inserção na tabela de complemento da movement
        movement.setDailyIcValueAmt(adjustment.getAdjustmentIcValue());
        movement.setMovementQtNumber(NumberUtils.INTEGER_ONE);

        return movement;
    }
}