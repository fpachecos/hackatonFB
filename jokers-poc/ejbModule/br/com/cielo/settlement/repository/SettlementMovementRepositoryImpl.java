package br.com.cielo.settlement.repository;

import javax.ejb.Stateless;

import br.com.cielo.settlement.entity.CardAssociation;
import br.com.cielo.settlement.entity.SettlementMovement;

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

    @Override
    public void setCardAssociationAndPrincipalToMovement(final SettlementMovement movement) {
    	movement.setCardAssociation(new CardAssociation());
    	movement.setFundingCurrencyCode("1");
    	movement.setSettlementTypeIndicator("");
    }
}