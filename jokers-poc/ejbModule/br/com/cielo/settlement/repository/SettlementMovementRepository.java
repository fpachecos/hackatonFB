package br.com.cielo.settlement.repository;

import br.com.cielo.settlement.entity.SettlementFinancialMovement;
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
     * Constante INSERT_SETTLEMENT_MOVEMENT.
     */
    String INSERT_SETTLEMENT_MOVEMENT = "INSERT INTO " + " TBSETR_SETTLEMENT_MOVEMENT " + " (DT_BATCH, "
                    + " CD_PRODUCT, " + " NU_CUSTOMER, " + " DT_SETTLEMENT, " + " VL_MOVEMENT_NET, "
                    + " VL_MOVEMENT_GROSS, " + " VL_DAILY_DISCOUNT_AMOUNT, " + " NU_LOAD_FILE_ID, "
                    + " CD_FUNDING_CURRENCY, " + " NU_FINANCIAL_MOVEMENT_TRACE, " + " DT_SETTLEMENT_TRACE, "
                    + " NU_MOD_CUSTOMER_TRACE, " + " NU_MOD_CUSTOMER, " + " CD_MOVEMENT_STATUS, "
                    + " CD_MOVEMENT_TYPE, " + " NU_FINANCIAL_MOVEMENT " + " ) VALUES ( " + " :DT_BATCH, "
                    + " :CD_PRODUCT, " + " :NU_CUSTOMER, " + " :DT_SETTLEMENT, " + " :VL_MOVEMENT_NET, "
                    + " :VL_MOVEMENT_GROSS, " + " :VL_DAILY_DISCOUNT_AMOUNT, " + " :NU_LOAD_FILE_ID, "
                    + " :CD_FUNDING_CURRENCY, " + " :NU_FINANCIAL_MOVEMENT_TRACE, " + " :DT_SETTLEMENT_TRACE, "
                    + " :NU_MOD_CUSTOMER_TRACE, " + " :NU_MOD_CUSTOMER, " + " :CD_MOVEMENT_STATUS, "
                    + " :CD_MOVEMENT_TYPE, " + " :NU_FINANCIAL_MOVEMENT " + " )";

    /**
     * INSERT_SETTLEMENT_ACCESS_MOVEMENT
     */
    String INSERT_SETTLEMENT_REL_MOVEMENT_ADJUSTMENT = "insert into " + "TBSETR_REL_MOVEMENT_ADJUSTMENT "
    + "(NU_MOD_CUSTOMER_MOV, " + "NU_FINANCIAL_MOVEMENT, " + "NU_FINANCIAL_ADJUSTMENT, " + "DT_SETTLEMENT, "
                    + "DT_BATCH," + "NU_MOD_CUSTOMER_ADJ) " + "values " + "(:NU_MOD_CUSTOMER, "
                    + ":NU_FINANCIAL_MOVEMENT, " + ":NU_FINANCIAL_ADJUSTMENT, " + ":DT_SETTLEMENT, " + ":DT_BATCH,"
                    + ":NU_MOD_CUSTOMER) ";
    
    /**
     * INSERT_SETTLEMENT_ACCESS_MOVEMENT
     */
    String INSERT_SETTLEMENT_REL_ADJUSTMENT_MOVEMENT = "insert into " + "TBSETR_REL_ADJUSTMENT_MOVEMENT "
                    + "(NU_MOD_CUSTOMER_MOV, " + "NU_FINANCIAL_MOVEMENT, " + "NU_FINANCIAL_ADJUSTMENT, "
                    + "DT_SETTLEMENT, " + "DT_BATCH," + "NU_MOD_CUSTOMER_ADJ) " + "values " + "(:NU_MOD_CUSTOMER, "
                    + ":NU_FINANCIAL_MOVEMENT, " + ":NU_FINANCIAL_ADJUSTMENT, " + ":DT_SETTLEMENT, " + ":DT_BATCH,"
                    + ":NU_MOD_CUSTOMER) ";
    /**
     * Constante INSERT_SETTLEMENT_MOVEMENT.
     */
    String INSERT_SETTLEMENT_MOVEMENT_COMPLEMENT = "INSERT INTO " + " TBSETR_COMPLEMENT_MOVEMENT "
                    + " (DT_SETTLEMENT, " + " NU_MOD_CUSTOMER, " + " NU_FINANCIAL_MOVEMENT, " + " VL_IC, "
                    + " QT_TRANSACTION," + " VL_FLEXIBLE_TERM," + " VL_DISCOUNT_AMOUNT" + " ) VALUES ( "
                    + " :DT_SETTLEMENT, " + " :NU_MOD_CUSTOMER, " + " :NU_FINANCIAL_MOVEMENT, " + " :VL_IC, "
                    + " :QT_TRANSACTION," + " :VL_FLEXIBLE_TERM," + " :VL_DISCOUNT_AMOUNT" + " )";
    
    /**
     * MÃ©todo setCardAssociationAndPrincipalToMovement
     *
     * @param movement
     *            SettlementMovement
     */
    void setCardAssociationAndPrincipalToMovement(final SettlementMovement movement);
    
    /**
     * Método insertSettlementMovement.
     * @param settlementFinancialMovement 
     *
     */
    void insertSettlementFinancialMovement(SettlementFinancialMovement settlementFinancialMovement);
    
    /**
     * Método insertMovementRelAdjustment.
     *
     * @param settlementFinancialMovement 
     */
    void insertMovementRelAdjustment(SettlementFinancialMovement settlementFinancialMovement);
    
    /**
     * Método insertAdjustmentRelMovement.
     *
     * @param settlementFinancialMovement 
     */
    void insertAdjustmentRelMovement(SettlementFinancialMovement settlementFinancialMovement);
    
    /**
     * Método insertMovementFinancialComplement.
     * @param settlementFinancialMovement 
     */
    void insertMovementFinancialComplement(SettlementFinancialMovement settlementFinancialMovement);
}