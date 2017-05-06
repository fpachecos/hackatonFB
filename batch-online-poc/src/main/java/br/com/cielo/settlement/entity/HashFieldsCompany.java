/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.util.Date;

/**
 * Campos utilizados na geração de um hash de agrupamento dos lançamentos
 * financeiros.
 *
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de
 *         Oliveira</a>
 * @version $Id: HashFields.java 46943 2015-08-07 14:12:15Z eyvdbm $
 */
public class HashFieldsCompany {

    /**
     * Data de liquidação.
     */
    private Date settlementDate;

    /**
     * Data de captura.
     */
    private Date batchDate;

    /**
     * Identificador de arquivo carregado.
     */
    private String loadFileId;

    /**
     * Código do estabelecimento comercial.
     */
    private Long companyNumber;

    /**
     * Código do produto.
     */
    private Integer productCode;

    /**
     * Identificador da subpartição da tabela.
     */
    private Integer companyModNumber;

    /**
     * Segmento do parcelado.
     */
    private Integer installmentSegment;

    /**
     * Tipo do movimento.
     */
    private Integer movementType;

    /**
     * Moeda de liquidação.
     */
    private Integer fundingCurrency;

    /**
     * Número da Parcela.
     */
    private Integer installmentSequenceNumber;

    /**
     * Construtor padrão.
     *
     * @param settlementDate
     *            data de liquidação.
     * @param batchDate
     *            data de captura.
     * @param loadFileId
     *            identificador de carga do arquivo.
     * @param customerNumber
     *            código do estabelecimento comercial.
     * @param productCode
     *            código do produto.
     * @param customerModNumber
     *            identificador de subpartição.
     * @param installmentSegment
     *            segmento do parcelado.
     * @param movementType
     *            tipo do movimento.
     * @param fundingCurrency
     *            moeda de liquidação.
     *
     */
    public HashFieldsCompany(final Date settlementDate, final Date batchDate, final String loadFileId,
                    final Long companyNumber, final Integer productCode, final Integer companyModNumber,
                    final Integer installmentSegment, final Integer movementType, final Integer fundingCurrency,
                    final Integer installmentSequenceNumber) {
        setSettlementDate(settlementDate);
        setBatchDate(batchDate);
        setLoadFileId(loadFileId);
        setCompanyNumber(companyNumber);
        setProductCode(productCode);
        setCompanyModNumber(companyModNumber);
        setInstallmentSegment(installmentSegment);
        setMovementType(movementType);
        setFundingCurrency(fundingCurrency);
        setInstallmentSequenceNumber(installmentSequenceNumber);
    }

    /**
     * Método get do atributo settlementDate
     *
     * @return O valor do atributo settlementDate
     */
    public Date getSettlementDate() {
        return this.settlementDate;
    }

    /**
     * Método set do atributo settlementDate
     *
     * @param settlementDate
     *            Valor para setar no atributo settlementDate
     */
    protected void setSettlementDate(final Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * Método get do atributo batchDate
     *
     * @return O valor do atributo batchDate
     */
    public Date getBatchDate() {
        return this.batchDate;
    }

    /**
     * Método set do atributo batchDate
     *
     * @param batchDate
     *            Valor para setar no atributo batchDate
     */
    protected void setBatchDate(final Date batchDate) {
        this.batchDate = batchDate;
    }

    /**
     * Método get do atributo loadFileId
     *
     * @return O valor do atributo loadFileId
     */
    public String getLoadFileId() {
        return this.loadFileId;
    }

    /**
     * Método set do atributo loadFileId
     *
     * @param loadFileId
     *            Valor para setar no atributo loadFileId
     */
    protected void setLoadFileId(final String loadFileId) {
        this.loadFileId = loadFileId;
    }

    /**
     * Método get do atributo companyNumber
     *
     * @return O valor do atributo companyNumber
     */
    public Long getCompanyNumber() {
        return this.companyNumber;
    }

    /**
     * Método set do atributo companyNumber
     *
     * @param companyNumber
     *            Valor para setar no atributo companyNumber
     */
    public void setCompanyNumber(final Long companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**
     * Método get do atributo productCode
     *
     * @return O valor do atributo productCode
     */
    public Integer getProductCode() {
        return this.productCode;
    }

    /**
     * Método set do atributo productCode
     *
     * @param productCode
     *            Valor para setar no atributo productCode
     */
    protected void setProductCode(final Integer productCode) {
        this.productCode = productCode;
    }

    /**
     * Método get do atributo companyModNumber
     *
     * @return O valor do atributo companyModNumber
     */
    public Integer getCompanyModNumber() {
        return this.companyModNumber;
    }

    /**
     * Método set do atributo companyModNumber
     *
     * @param companyModNumber
     *            Valor para setar no atributo companyModNumber
     */
    public void setCompanyModNumber(final Integer companyModNumber) {
        this.companyModNumber = companyModNumber;
    }

    /**
     * Método get do atributo installmentSegment
     *
     * @return O valor do atributo installmentSegment
     */
    public Integer getInstallmentSegment() {
        return this.installmentSegment;
    }

    /**
     * Método set do atributo installmentSegment
     *
     * @param installmentSegment
     *            Valor para setar no atributo installmentSegment
     */
    protected void setInstallmentSegment(final Integer installmentSegment) {
        this.installmentSegment = installmentSegment;
    }

    /**
     * Método get do atributo movementType
     *
     * @return O valor do atributo movementType
     */
    public Integer getMovementType() {
        return this.movementType;
    }

    /**
     * Método set do atributo movementType
     *
     * @param movementType
     *            Valor para setar no atributo movementType
     */
    protected void setMovementType(final Integer movementType) {
        this.movementType = movementType;
    }

    /**
     * Método get do atributo fundingCurrency
     *
     * @return O valor do atributo fundingCurrency
     */
    public Integer getFundingCurrency() {
        return this.fundingCurrency;
    }

    /**
     * Método set do atributo fundingCurrency
     *
     * @param fundingCurrency
     *            Valor para setar no atributo fundingCurrency
     */
    protected void setFundingCurrency(final Integer fundingCurrency) {
        this.fundingCurrency = fundingCurrency;
    }

    /**
     * Método get do atributo installmentSequenceNumber
     *
     * @return O valor do atributo installmentSequenceNumber
     */
    public final Integer getInstallmentSequenceNumber() {
        return this.installmentSequenceNumber;
    }

    /**
     * Método set do atributo installmentSequenceNumber
     *
     * @param installmentSequenceNumber
     *            Valor para setar no atributo installmentSequenceNumber
     */
    public final void setInstallmentSequenceNumber(final Integer installmentSequenceNumber) {
        this.installmentSequenceNumber = installmentSequenceNumber;
    }

}
