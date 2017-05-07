/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
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
    
    /**
     * Gera movimento através do ajuste
     *
     * @param adjustment
     *            SettlementAdjustment
     * @return SettlementMovement
     * @throws BusinessException
     *             caso ocorra algum erro na geração do hash do movimento.
     */
    SettlementMovement generateMovement(final SettlementAdjustment adjustment) throws BusinessException;
}
