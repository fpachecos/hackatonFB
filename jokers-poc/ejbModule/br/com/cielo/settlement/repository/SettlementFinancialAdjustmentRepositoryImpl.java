/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */

package br.com.cielo.settlement.repository;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 * Repository para ajustes financeiros
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustmentRepositoryImpl.java 46630 2015-08-05 15:22:17Z eyvdz8
 *          $
 */
@Stateless
public class SettlementFinancialAdjustmentRepositoryImpl
    implements SettlementFinancialAdjustmentRepository {

  @PersistenceContext(unitName = "bob")
  private transient EntityManager entityManager;

  /**
   * @see br.com.cielo.settlement.batch.repository.SettlementFinancialAdjustmentRepositor
   * #insertFinanceAdjustmentHistory()
   */
  public void insertFinanceAdjustmentHistory(
      br.com.cielo.settlement.entity.SettlementFinancialAdjustment item) {
    this.entityManager
        .createNativeQuery(
            SettlementFinancialAdjustmentRepository.INSERT_FINANCIAL_ADJUSTMENTS_HISTORY)
        .setParameter(1, item.getVlGross()).setParameter(2, item.getNuRequest())
        .setParameter(3, item.getNuModCustomer()).setParameter(4, System.currentTimeMillis())
        .setParameter(5, item.getNuCustomer()).setParameter(6, item.getDtSettlementAdjustment())
        .setParameter(7, new Date(), TemporalType.TIMESTAMP)
        .setParameter(8, item.getDhRequest(), TemporalType.TIMESTAMP)
        .setParameter(9, item.getCdUserId()).setParameter(10, item.getCdTechnologyType().getCode())
        .setParameter(11, item.getCdStatusRequest().getCode())
        .setParameter(12, item.getRequestType().getCode())
        .setParameter(13, item.getCdMovementType().getCode()).setParameter(14, item.getEntryType())
        .setParameter(15, item.getCdAdjustentReason()).executeUpdate();

    // new
    // SimpleUpdateCommand<SettlementFinancialAdjustment>(INSERT_FINANCIAL_ADJUSTMENTS_HISTORY,
    // new SettlementFinancialAdjustmentHistProvider());
  }
}
