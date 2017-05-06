/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;

/**
 * Serviço para ajustes financeiros, leitura de ajuste financeiro, criação de
 * ajuste e movimento
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustmentService.java 46605 2015-08-05
 *          13:50:22Z eyvd6c $
 */
public interface SettlementFinancialAdjustmentService {

    /**
     * Gera ajuste através do ajuste financeiro.
     *
     * @param financialAdjustment
     *            SettlementFinancialAdjustment
     * @return SettlementAdjustment
     * @throws BusinessException
     *             ao gerar o número do lançamento financeiro.
     */
    SettlementFinancialAdjustment generateAdjustment(final SettlementFinancialAdjustment financialAdjustment) throws BusinessException;

}
