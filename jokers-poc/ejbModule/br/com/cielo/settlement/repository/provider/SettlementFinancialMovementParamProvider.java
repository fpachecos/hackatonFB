/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.repository.provider;

import javax.persistence.Query;

import br.com.cielo.settlement.entity.SettlementFinancialMovement;

/**
 * Classe SettlementFinancialMovementParamProvider. Prepara dados para Inserção
 * na Tabela de Settlement Movement, sendo FIDC ou não.
 *
 * @author <a href="mailto:eyve4g@prestadorcbmp.com.br">Jean Felipe Silva</a>
 * @version $Id: SettlementFinancialMovementParamProvider.java 2016-10-03
 *
 */
public class SettlementFinancialMovementParamProvider {

    public void applyParameters(final SettlementFinancialMovement item, Query query) {
        query.setParameter("DT_BATCH", item.getSettlementMovement().getBatchDate());
        query.setParameter("CD_PRODUCT", item.getSettlementMovement().getProductCode());
        query.setParameter("NU_CUSTOMER", item.getSettlementMovement().getCustomerNumber());
        query.setParameter("DT_SETTLEMENT", item.getSettlementMovement().getSettlementDate());
        query.setParameter("VL_MOVEMENT_NET", item.getSettlementMovement().getNetMovementValue());
        query.setParameter("CD_MOVEMENT_TYPE", item.getSettlementMovement().getMovementTypeCode());
        query.setParameter("VL_MOVEMENT_GROSS", item.getSettlementMovement().getGrossMovementValue());
        query.setParameter("VL_DAILY_DISCOUNT_AMOUNT", item.getSettlementMovement().getDailyDiscountValueAmt());
        query.setParameter("NU_LOAD_FILE_ID", item.getSettlementMovement().getLoadFileIdNumber());
        query.setParameter("CD_FUNDING_CURRENCY", item.getSettlementMovement().getFundingCurrencyCode());
        query.setParameter("DT_SETTLEMENT_BASE", item.getSettlementMovement().getSettlementBaseDate());
        query.setParameter("NU_MOD_CUSTOMER", item.getSettlementMovement().getCustomerModNumber());
        query.setParameter("DT_SETTLEMENT_TRACE", item.getSettlementMovement().getTraceSettlementDate());
        query.setParameter("CD_MOVEMENT_STATUS", item.getSettlementMovement().getMovementStatusCode());
        query.setParameter("NU_FINANCIAL_MOVEMENT_TRACE", item.getSettlementMovement()
                        .getTraceNumberFinancialMovement());
        query.setParameter("NU_FINANCIAL_MOVEMENT", item.getSettlementMovement().getNumberFinancialMovement());
        query.setParameter("NU_MOD_CUSTOMER_TRACE", item.getSettlementMovement().getTraceCustomerModNumber());
    }
}