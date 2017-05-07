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
 * Classe MovementComplementParamProvider. Prepara dados para Inserção na Tabela
 * de Settlement Movement Complement, FIDC.
 *
 * @author <a href="mailto:waldeir@cielo.com.br">Waldeir Souza</a>
 * @version $Id: MovementComplementParamProvider.java 33461 2015-03-18 12:38:20Z
 *          waldeir $
 */
public class MovementCompanyComplementParamProvider{

    public void applyParameters(final SettlementFinancialMovement item, Query query) {
    	int index=1;
        query.setParameter(index++, item.getSettlementMovement().getSettlementDate());
        query.setParameter(index++, item.getSettlementMovement().getCustomerModNumber());
        query.setParameter(index++, item.getSettlementMovement().getNumberFinancialMovement());
        query.setParameter(index++, item.getSettlementMovement().getDailyIcValueAmt());
        query.setParameter(index++, item.getSettlementMovement().getMovementQtNumber());
        query.setParameter(index++, item.getSettlementMovement().getValueFlexibleTerm());
        query.setParameter(index++, item.getSettlementMovement().getValueAmountDiscount());
    }
}