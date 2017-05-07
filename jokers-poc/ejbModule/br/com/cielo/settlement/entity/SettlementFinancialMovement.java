/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.io.Serializable;

/**
 * Entidade que representa um movimento, relativo a ajustes financeiros, na
 * agenda do cliente. .
 *
 * @author <a href="mailto:eyve4g@prestadorcbmp.com.br>Jean Felipe Silva</a>
 * @version $Id$
 *
 */
public class SettlementFinancialMovement implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
     * Atributo que representa SettlementAdjustment.
     */
    private SettlementAdjustment settlementAdjustment;

    /**
     * Atributo que representa settlementMovement;
     */
    private SettlementMovement settlementMovement;

    /**
     * Atributo que representa settlementMovementCompany.
     */
    private SettlementMovementCompany settlementMovementCompany;

    /**
     * Atributo que representa o Fidc.
     */
    private String inFidc;

    /**
     * Numero único que identifica o Parceiro Cielo no Cadastro da empresa.
     */

    private Long nuCompany;

    /**
     * Numero de identificação da empresa parceira
     */
    private Integer nuModCompany;

    public SettlementFinancialMovement(SettlementFinancialAdjustment generatedAdjustment) {
		// TODO Auto-generated constructor stub
	}

	/**
     * Método get do atributo settlementAdjustment
     *
     * @return O valor do atributo settlementAdjustment
     */
    public SettlementAdjustment getSettlementAdjustment() {
        return this.settlementAdjustment;
    }

    /**
     * Método set do atributo settlementAdjustment
     *
     * @param settlementAdjustment
     *            Valor para setar no atributo settlementAdjustment
     */
    public void setSettlementAdjustment(final SettlementAdjustment settlementAdjustment) {
        this.settlementAdjustment = settlementAdjustment;
    }

    /**
     * Método get do atributo settlementMovement
     *
     * @return O valor do atributo settlementMovement
     */
    public SettlementMovement getSettlementMovement() {
        return this.settlementMovement;
    }

    /**
     * Método set do atributo settlementMovement
     *
     * @param settlementMovement
     *            Valor para setar no atributo settlementMovement
     */
    public void setSettlementMovement(final SettlementMovement settlementMovement) {
        this.settlementMovement = settlementMovement;
    }

    /**
     * Método get do atributo inFidc
     *
     * @return O valor do atributo inFidc
     */
    public String getInFidc() {
        return this.inFidc;
    }

    /**
     * Método set do atributo inFidc
     *
     * @param inFidc
     *            Valor para setar no atributo inFidc
     */
    public void setInFidc(final String inFidc) {
        this.inFidc = inFidc;
    }

    /**
     * Método get do atributo settlementMovementCompany
     *
     * @return O valor do atributo settlementMovementCompany
     */
    public SettlementMovementCompany getSettlementMovementCompany() {
        return this.settlementMovementCompany;
    }

    /**
     * Método set do atributo settlementMovementCompany
     *
     * @param settlementMovementCompany
     *            Valor para setar no atributo settlementMovementCompany
     */
    public void setSettlementMovementCompany(final SettlementMovementCompany settlementMovementCompany) {
        this.settlementMovementCompany = settlementMovementCompany;
    }

    /**
     * Método get do atributo nuModCompany
     *
     * @return O valor do atributo nuModCompany
     */
    public Integer getNuModCompany() {
        return this.nuModCompany;
    }

    /**
     * Método set do atributo nuModCompany
     *
     * @param nuModCompany
     *            Valor para setar no atributo nuModCompany
     */
    public void setNuModCompany(final Integer nuModCompany) {
        this.nuModCompany = nuModCompany;
    }

    /**
     * Método get do atributo nuCompany
     *
     * @return O valor do atributo nuCompany
     */
    public Long getNuCompany() {
        return this.nuCompany;
    }

    /**
     * Método set do atributo nuCompany
     *
     * @param nuCompany
     *            Valor para setar no atributo nuCompany
     */
    public void setNuCompany(final Long nuCompany) {
        this.nuCompany = nuCompany;
    }

}
