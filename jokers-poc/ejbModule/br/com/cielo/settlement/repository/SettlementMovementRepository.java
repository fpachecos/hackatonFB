package br.com.cielo.settlement.repository;

import br.com.cielo.settlement.entity.SettlementMovement;

/**
 * Classe SettlementMovementRepository.
 *
 * @author <a href="mailto:eyvd67@prestadorcbmp.com.br">Daniel Perestrelo
 *         Vicente</a>
 * @version $Id: SettlementMovementRepository.java 56572 2016-02-03 11:45:46Z
 *          waldeir $
 */
public interface SettlementMovementRepository {
	 
	/**
     * Query buscar o CARD_ASSOCIATION e CD_PRINCIPAL de produto e cliente.
     */
    String SELECT_CARD_ASSOCIATION_PRINCIPAL_BY_CUSTOMER = "select "
                    + "  contracted.tipo_liquidacao IN_SETTLEMENT_TYPE, "
                    + "  contracted.bandeira CD_CARD_ASSOCIATION, " + "  merchant.CD_PRINCIPAL " + "from "
                    + "  VMCTM_PAYMENT_HIERARCHY contracted " + "inner join TBCTMR_MERCHANT merchant "
                    + "  on merchant.NU_CUSTOMER = contracted.numero_cliente "
                    + "where contracted.numero_cliente = :NU_CUSTOMER "
                    + "  and contracted.codigo_produto = :CD_PRODUCT " + "group by  "
                    + "  contracted.bandeira, merchant.CD_PRINCIPAL, contracted.tipo_liquidacao";
    
    /**
     * Método setCardAssociationAndPrincipalToMovement
     *
     * @param movement
     *            SettlementMovement
     */
    void setCardAssociationAndPrincipalToMovement(final SettlementMovement movement);
}