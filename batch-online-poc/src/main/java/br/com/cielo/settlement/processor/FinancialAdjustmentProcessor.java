/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.processor;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.service.SettlementFinancialAdjustmentService;

/**
 * Processor para gerar ajustes financeiros.
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialAdjustmentProcessor.java 46656 2015-08-05 17:15:28Z eyvdz8 $
 */
@Stateless
public class FinancialAdjustmentProcessor {

    /**
     * Injeção de {@link SettlementFinancialAdjustmentService }
     */
    @EJB
    private transient SettlementFinancialAdjustmentService financialAdjustmentService;

    /*
     * (non-Javadoc)
     * @see br.com.cielo.common.batch.job.BusinessProcessor#process(java.lang.Object)
     */
    public SettlementFinancialAdjustment process(final SettlementFinancialAdjustment entity) {
        try {
			return this.financialAdjustmentService.generateAdjustment(entity);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

}
