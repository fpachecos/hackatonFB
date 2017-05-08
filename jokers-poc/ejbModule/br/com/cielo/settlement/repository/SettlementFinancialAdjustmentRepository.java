/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.repository;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;

/**
 * Classe para acesso a ajustes financeiros
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustmentRepository.java 37560 2015-05-12 11:46:28Z eyvdbm $
 */
public interface SettlementFinancialAdjustmentRepository {

  /**
   * Insere os ajustes financeiros na tabela de histórico.
   */
  String INSERT_FINANCIAL_ADJUSTMENTS_HISTORY =
      new StringBuilder("INSERT ").append("INTO TBSETR_FINANCE_ADJUST_HIST( ").append("VL_GROSS, ")
          .append("NU_REQUEST, ").append("NU_MOD_CUSTOMER, ").append("NU_HISTORY, ")
          .append("NU_CUSTOMER, ").append("DT_SETTLEMENT_ADJUSTMENT, ")
          .append("DH_STATUS_CHANGED, ").append("DH_REQUEST, ").append("CD_USER_ID, ")
          .append("CD_TECHNOLOGY_TYPE, ").append("CD_STATUS_REQUEST, ").append("CD_REQUEST_TYPE, ")
          .append("CD_MOVEMENT_TYPE, ").append("CD_ENTRY_TYPE, ").append("CD_ADJUSTMENT_REASON) ")
          .append("VALUES ( ").append("?, ").append("?, ").append("?, ").append("?, ").append("?, ")
          .append("?, ").append("?, ").append("?, ").append("?, ").append("?, ").append("?, ")
          .append("?, ").append("?, ").append("?, ").append("?) ").toString();


  /**
   * Insere o histórico de um ajuste financeiro.
   *
   * @return parameterSource parameterSource
   */
  void insertFinanceAdjustmentHistory(SettlementFinancialAdjustment item);

}
