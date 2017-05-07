package br.com.cielo.settlement.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.cielo.settlement.entity.CardAssociation;
import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.repository.provider.SettlementFinancialMovementParamProvider;

/**
 * Classe SettlementMovementRepositoryImpl.
 *
 * @author <a href="mailto:eyvd67@prestadorcbmp.com.br>Daniel Perestrelo
 *         Vicente</a>
 * @version $Id: SettlementMovementRepositoryImpl.java 55522 2016-01-19
 *          11:47:17Z waldeir $
 */
@Stateless
public class SettlementMovementRepositoryImpl implements SettlementMovementRepository {

	@PersistenceContext(unitName = "bob")
	private transient EntityManager entityManager;

	@Override
	public void setCardAssociationAndPrincipalToMovement(final SettlementMovement movement) {
		movement.setCardAssociation(new CardAssociation());
		movement.setFundingCurrencyCode("1");
		movement.setSettlementTypeIndicator("");
	}

	@Override
	public void insertSettlementFinancialMovement(SettlementFinancialMovement settlementFinancialMovement) {
		Query query = entityManager.createNativeQuery(SettlementMovementRepository.INSERT_SETTLEMENT_MOVEMENT);
		new SettlementFinancialMovementParamProvider().applyParameters(settlementFinancialMovement, query);
		query.executeUpdate();
	}

	@Override
	public void insertMovementRelAdjustment(SettlementFinancialMovement settlementFinancialMovement) {
		Query query = entityManager.createNativeQuery(SettlementMovementRepository.INSERT_SETTLEMENT_REL_MOVEMENT_ADJUSTMENT);
		query.setParameter("NU_MOD_CUSTOMER",
				settlementFinancialMovement.getSettlementMovement().getCustomerModNumber());
		query.setParameter("NU_FINANCIAL_MOVEMENT",
				settlementFinancialMovement.getSettlementMovement().getNumberFinancialMovement());
		query.setParameter("NU_FINANCIAL_ADJUSTMENT", settlementFinancialMovement.getSettlementMovement()
				.getMovementRelAdjustment().getNumberFinancialAdjustement());
		query.setParameter("DT_SETTLEMENT", settlementFinancialMovement.getSettlementMovement().getSettlementDate());
		query.setParameter("DT_BATCH", settlementFinancialMovement.getSettlementMovement().getBatchDate());
		query.executeUpdate();
    }
	
	@Override
    public void insertAdjustmentRelMovement(SettlementFinancialMovement settlementFinancialMovement) {
		Query query = entityManager
				.createNativeQuery(SettlementMovementRepository.INSERT_SETTLEMENT_REL_ADJUSTMENT_MOVEMENT);
		query.setParameter("NU_MOD_CUSTOMER",
				settlementFinancialMovement.getSettlementMovement().getCustomerModNumber());
		query.setParameter("NU_FINANCIAL_MOVEMENT",
				settlementFinancialMovement.getSettlementMovement().getNumberFinancialMovement());
		query.setParameter("NU_FINANCIAL_ADJUSTMENT", settlementFinancialMovement.getSettlementMovement()
				.getMovementRelAdjustment().getNumberFinancialAdjustement());
		query.setParameter("DT_SETTLEMENT", settlementFinancialMovement.getSettlementMovement().getSettlementDate());
		query.setParameter("DT_BATCH", settlementFinancialMovement.getSettlementMovement().getBatchDate());
		query.executeUpdate();
    }
	
	@Override
    public void insertMovementFinancialComplement(SettlementFinancialMovement settlementFinancialMovement) {
		Query query = entityManager.createNativeQuery(SettlementMovementRepository.INSERT_SETTLEMENT_MOVEMENT_COMPLEMENT);
		new SettlementFinancialMovementParamProvider().applyParameters(settlementFinancialMovement, query);
		query.executeUpdate();
    }
}