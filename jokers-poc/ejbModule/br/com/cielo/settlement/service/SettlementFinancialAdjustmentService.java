/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.entity.SettlementMovementCompany;

/**
 * Servi�o para ajustes financeiros, leitura de ajuste financeiro, cria��o de ajuste e movimento
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustmentService.java 46605 2015-08-05 13:50:22Z eyvd6c $
 */
public interface SettlementFinancialAdjustmentService {

  /**
   * Gera ajuste atrav�s do ajuste financeiro.
   *
   * @param financialAdjustment SettlementFinancialAdjustment
   * @return SettlementAdjustment
   * @throws BusinessException ao gerar o n�mero do lan�amento financeiro.
   */
  SettlementFinancialAdjustment generateAdjustment(
      final SettlementFinancialAdjustment financialAdjustment) throws BusinessException;

  /**
   * Gera movimento atrav�s do ajuste
   *
   * @param adjustment SettlementAdjustment
   * @return SettlementMovement
   * @throws BusinessException caso ocorra algum erro na gera��o do hash do movimento.
   */
  SettlementMovement generateMovement(final SettlementAdjustment adjustment)
      throws BusinessException;
}
