package br.com.cielo.settlement.batch.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;

/**
 * Repositório de SettlementAdjustment
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: SettlementAdjustmentRepositoryImpl.java 26/06/2014 - 21:03:43
 */
@Stateless
public class SettlementAdjustmentRepositoryImpl implements SettlementAdjustmentRepository {

	@PersistenceContext(unitName = "bob")
	private transient EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cielo.settlement.batch.repository.SettlementAdjustmentRepository
	 * #createAdjustment()
	 */
	@Override
	public void createAdjustment(SettlementFinancialAdjustment item) {
		this.entityManager.createNativeQuery(SettlementAdjustmentRepository.INSERT)
				.setParameter(1, 1)
				.setParameter(2, item.getAdjustment().getBatchDate(), TemporalType.DATE)
				.setParameter(3, item.getAdjustment().getCustomerModNumber())
				.setParameter(4, item.getAdjustment().getEntryType().getCodeType())
				.setParameter(5, item.getAdjustment().getBatchNumber())
				.setParameter(6, item.getAdjustment().getMovementTypeCode().getCode())
				.setParameter(7, item.getAdjustment().getRefundNsu())
				.setParameter(8, item.getAdjustment().getOrigialTransactionId())
				.setParameter(9, item.getAdjustment().getCustomerNumber())
				.setParameter(10, item.getAdjustment().getAdjustmentAmountValue())
				.setParameter(11, item.getAdjustment().getNetAmountValue())
				.setParameter(12, item.getAdjustment().getDiscountAmountValue())
				.setParameter(13, item.getAdjustment().getAdjustmentDate(), TemporalType.TIMESTAMP)
				.setParameter(14, item.getAdjustment().getSettlementAdjstmentDate(),
						TemporalType.DATE)
				.setParameter(15, item.getAdjustment().getInSettlement())
				.setParameter(16, item.getAdjustment().getRequestNumber())
				.setParameter(17, item.getAdjustment().getRequestDate(), TemporalType.TIMESTAMP)
				.setParameter(18, item.getAdjustment().getRequestType().getCode())
				.setParameter(19, item.getAdjustment().getLoadFileIdNumber())
				.setParameter(20, item.getAdjustment().getTerminalNumber())
				.setParameter(21, item.getAdjustment().getProductCode())
				.setParameter(22, item.getAdjustment().getAcquirerCode())
				.setParameter(23, item.getAdjustment().getAdjustmentReason())
				.setParameter(24, item.getAdjustment().getTechnologyType().getCode())
				.setParameter(25, item.getAdjustment().getAdjustmentIcValue())
				.setParameter(26, item.getAdjustment().getInstallmentSequenceOrig())
				.setParameter(27, item.getAdjustment().getFinancialMovement())
				.setParameter(28, item.getAdjustment().getValueOrigDiscount())
				.setParameter(29, item.getAdjustment().getValueFlexibleTerm())
				.setParameter(30, 0)
				.setParameter(31, 0).executeUpdate();
	}
}
