/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.validation.rule;

import javax.ejb.Stateless;

import org.apache.commons.lang3.math.NumberUtils;

import br.com.cielo.settlement.entity.MovementStatusEnum;
import br.com.cielo.settlement.entity.RefundRulesEnum;
import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.entity.SettlementMovementRelAdjustment;

/**
 * Classe para tratar processamento de ajustes financeiros
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialAdjustmentRulesImpl.java 59434 2016-03-11 18:05:53Z eyvdbm $
 */
@Stateless
public class FinancialAdjustmentRulesImpl implements FinancialAdjustmentRules {

  /**
   * {@link RefundRulesEnum} Constantes de regras de reembolso
   */
  private RefundRulesEnum rule;


  public FinancialAdjustmentRulesImpl() {
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


  public SettlementMovement createFinancialMovement(final SettlementAdjustment adjustment,
      final Integer codCurrency) {

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

    final SettlementMovementRelAdjustment movementRelAdjustment =
        new SettlementMovementRelAdjustment();
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
