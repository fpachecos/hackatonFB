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
    	int index=1;
        query.setParameter(index++, item.getSettlementMovement().getBatchDate());
        query.setParameter(index++, item.getSettlementMovement().getProductCode());
        query.setParameter(index++, item.getSettlementMovement().getCustomerNumber());
        query.setParameter(index++, item.getSettlementMovement().getSettlementDate());
        query.setParameter(index++, item.getSettlementMovement().getNetMovementValue());
        query.setParameter(index++, item.getSettlementMovement().getGrossMovementValue());
        query.setParameter(index++, item.getSettlementMovement().getDailyDiscountValueAmt());
        query.setParameter(index++, item.getSettlementMovement().getLoadFileIdNumber());
        query.setParameter(index++, item.getSettlementMovement().getFundingCurrencyCode());
        query.setParameter(index++, item.getSettlementMovement()
        		.getTraceNumberFinancialMovement());
        query.setParameter(index++, item.getSettlementMovement().getTraceSettlementDate());
        query.setParameter(index++, item.getSettlementMovement().getTraceCustomerModNumber());
        query.setParameter(index++, item.getSettlementMovement().getCustomerModNumber());
        query.setParameter(index++, item.getSettlementMovement().getMovementStatusCode());
        query.setParameter(index++, item.getSettlementMovement().getMovementTypeCode());
        query.setParameter(index++, item.getSettlementMovement().getNumberFinancialMovement());
    }
}