package br.com.cielo.settlement.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Movimentação ajustada Settlement.
 * 
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br>Jonas Almeida Cezar </a>
 * @version $Id: SettlementMovementRelAdjustment.java 46605 2015-08-05 13:50:22Z eyvd6c $
 */
public class SettlementMovementRelAdjustment implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * campo Date datchDate DT_BATCH
     */
    private Date batchDate;

    /**
     * Campo String numberFinancialAdjustement NU_FINANCIAL_ADJUSTMENT
     */
    private String numberFinancialAdjustement;

    /**
     * Campo Integer customerModNumber. NU_MOD_CUSTOMER NUMBER
     */
    private Integer customerModNumber;

    /**
     * Campo String numberFinancialMovement NU_FINANCIAL_MOVEMENT
     */
    private String numberFinancialMovement;

    /**
     * Campo Date settlementDate. DT_SETTLEMENT DATE
     */
    private Date settlementDate;

    /**
     * Método get do atributo numberFinancialAdjustement
     * 
     * @return O valor do atributo numberFinancialAdjustement
     */
    public final String getNumberFinancialAdjustement() {
        return this.numberFinancialAdjustement;
    }

    /**
     * Método set do atributo numberFinancialAdjustement
     * 
     * @param numberFinancialAdjustement Valor para setar no atributo numberFinancialAdjustement
     */
    public final void setNumberFinancialAdjustement(final String numberFinancialAdjustement) {
        this.numberFinancialAdjustement = numberFinancialAdjustement;
    }

    /**
     * Método get do atributo customerModNumber
     * 
     * @return O valor do atributo customerModNumber
     */
    public final Integer getCustomerModNumber() {
        return this.customerModNumber;
    }

    /**
     * Método set do atributo customerModNumber
     * 
     * @param customerModNumber Valor para setar no atributo customerModNumber
     */
    public final void setCustomerModNumber(final Integer customerModNumber) {
        this.customerModNumber = customerModNumber;
    }

    /**
     * Método get do atributo numberFinancialMovement
     * 
     * @return O valor do atributo numberFinancialMovement
     */
    public final String getNumberFinancialMovement() {
        return this.numberFinancialMovement;
    }

    /**
     * Método set do atributo numberFinancialMovement
     * 
     * @param numberFinancialMovement Valor para setar no atributo numberFinancialMovement
     */
    public final void setNumberFinancialMovement(final String numberFinancialMovement) {
        this.numberFinancialMovement = numberFinancialMovement;
    }

    /**
     * Método get do atributo settlementDate
     * 
     * @return O valor do atributo settlementDate
     */
    public final Date getSettlementDate() {
        return this.settlementDate;
    }

    /**
     * Método set do atributo settlementDate
     * 
     * @param settlementDate Valor para setar no atributo settlementDate
     */
    public final void setSettlementDate(final Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * Método get do atributo batchDate
     * 
     * @return O valor do atributo batchDate
     */
    public final Date getBatchDate() {
        return this.batchDate;
    }

    /**
     * Método set do atributo batchDate
     * 
     * @param batchDate Valor para setar no atributo batchDate
     */
    public final void setBatchDate(final Date batchDate) {
        this.batchDate = batchDate;
    }

}
