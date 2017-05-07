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

    public void createSqlParameterSource(final SettlementFinancialMovement item, Query query) {
        query.setParameter("DT_SETTLEMENT", item.getSettlementMovement().getSettlementDate());
        query.setParameter("VL_IC", item.getSettlementMovement().getDailyIcValueAmt());
        query.setParameter("NU_MOD_CUSTOMER", item.getSettlementMovement().getCustomerModNumber());
        query.setParameter("NU_FINANCIAL_MOVEMENT", item.getSettlementMovement().getNumberFinancialMovement());
        query.setParameter("QT_TRANSACTION", item.getSettlementMovement().getMovementQtNumber());
        query.setParameter("VL_FLEXIBLE_TERM", item.getSettlementMovement().getValueFlexibleTerm());
        query.setParameter("VL_DISCOUNT_AMOUNT", item.getSettlementMovement().getValueAmountDiscount());
    }
}