/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.processor;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.repository.SettlementMovementRepository;
import br.com.cielo.settlement.service.SettlementFinancialAdjustmentService;

/**
 * Processor para o Job SettlementFinancialMovementGeneratorJob.
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: FinancialMovementProcessor.java 46620 2015-08-05 14:43:24Z eyvdz8 $
 */
@Stateless
public class FinancialMovementProcessor {

  /**
   * Inje��o de {@link SettlementFinancialAdjustmentService }
   */
  @EJB
  private transient SettlementFinancialAdjustmentService financialAdjustmentService;

  @EJB
  private transient SettlementMovementRepository settlementMovementRepository;

  public void process(final SettlementFinancialMovement entity) {
    try {
      entity.setSettlementMovement(
          this.financialAdjustmentService.generateMovement(entity.getSettlementAdjustment()));

      this.settlementMovementRepository.insertSettlementFinancialMovement(entity);
      this.settlementMovementRepository.insertMovementRelAdjustment(entity);
      this.settlementMovementRepository.insertAdjustmentRelMovement(entity);
      this.settlementMovementRepository.insertMovementFinancialComplement(entity);
    } catch (BusinessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
