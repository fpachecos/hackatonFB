/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.util.Date;

/**
 * Campos utilizados na gera��o de um hash de agrupamento dos lan�amentos financeiros.
 *
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de Oliveira</a>
 * @version $Id: HashFields.java 46943 2015-08-07 14:12:15Z eyvdbm $
 */
public class HashFieldsCompany {

  /**
   * Data de liquida��o.
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
   * C�digo do estabelecimento comercial.
   */
  private Long companyNumber;

  /**
   * C�digo do produto.
   */
  private Integer productCode;

  /**
   * Identificador da subparti��o da tabela.
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
   * Moeda de liquida��o.
   */
  private Integer fundingCurrency;

  /**
   * N�mero da Parcela.
   */
  private Integer installmentSequenceNumber;

  /**
   * Construtor padr�o.
   *
   * @param settlementDate data de liquida��o.
   * @param batchDate data de captura.
   * @param loadFileId identificador de carga do arquivo.
   * @param customerNumber c�digo do estabelecimento comercial.
   * @param productCode c�digo do produto.
   * @param customerModNumber identificador de subparti��o.
   * @param installmentSegment segmento do parcelado.
   * @param movementType tipo do movimento.
   * @param fundingCurrency moeda de liquida��o.
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
   * M�todo get do atributo settlementDate
   *
   * @return O valor do atributo settlementDate
   */
  public Date getSettlementDate() {
    return this.settlementDate;
  }

  /**
   * M�todo set do atributo settlementDate
   *
   * @param settlementDate Valor para setar no atributo settlementDate
   */
  protected void setSettlementDate(final Date settlementDate) {
    this.settlementDate = settlementDate;
  }

  /**
   * M�todo get do atributo batchDate
   *
   * @return O valor do atributo batchDate
   */
  public Date getBatchDate() {
    return this.batchDate;
  }

  /**
   * M�todo set do atributo batchDate
   *
   * @param batchDate Valor para setar no atributo batchDate
   */
  protected void setBatchDate(final Date batchDate) {
    this.batchDate = batchDate;
  }

  /**
   * M�todo get do atributo loadFileId
   *
   * @return O valor do atributo loadFileId
   */
  public String getLoadFileId() {
    return this.loadFileId;
  }

  /**
   * M�todo set do atributo loadFileId
   *
   * @param loadFileId Valor para setar no atributo loadFileId
   */
  protected void setLoadFileId(final String loadFileId) {
    this.loadFileId = loadFileId;
  }

  /**
   * M�todo get do atributo companyNumber
   *
   * @return O valor do atributo companyNumber
   */
  public Long getCompanyNumber() {
    return this.companyNumber;
  }

  /**
   * M�todo set do atributo companyNumber
   *
   * @param companyNumber Valor para setar no atributo companyNumber
   */
  public void setCompanyNumber(final Long companyNumber) {
    this.companyNumber = companyNumber;
  }

  /**
   * M�todo get do atributo productCode
   *
   * @return O valor do atributo productCode
   */
  public Integer getProductCode() {
    return this.productCode;
  }

  /**
   * M�todo set do atributo productCode
   *
   * @param productCode Valor para setar no atributo productCode
   */
  protected void setProductCode(final Integer productCode) {
    this.productCode = productCode;
  }

  /**
   * M�todo get do atributo companyModNumber
   *
   * @return O valor do atributo companyModNumber
   */
  public Integer getCompanyModNumber() {
    return this.companyModNumber;
  }

  /**
   * M�todo set do atributo companyModNumber
   *
   * @param companyModNumber Valor para setar no atributo companyModNumber
   */
  public void setCompanyModNumber(final Integer companyModNumber) {
    this.companyModNumber = companyModNumber;
  }

  /**
   * M�todo get do atributo installmentSegment
   *
   * @return O valor do atributo installmentSegment
   */
  public Integer getInstallmentSegment() {
    return this.installmentSegment;
  }

  /**
   * M�todo set do atributo installmentSegment
   *
   * @param installmentSegment Valor para setar no atributo installmentSegment
   */
  protected void setInstallmentSegment(final Integer installmentSegment) {
    this.installmentSegment = installmentSegment;
  }

  /**
   * M�todo get do atributo movementType
   *
   * @return O valor do atributo movementType
   */
  public Integer getMovementType() {
    return this.movementType;
  }

  /**
   * M�todo set do atributo movementType
   *
   * @param movementType Valor para setar no atributo movementType
   */
  protected void setMovementType(final Integer movementType) {
    this.movementType = movementType;
  }

  /**
   * M�todo get do atributo fundingCurrency
   *
   * @return O valor do atributo fundingCurrency
   */
  public Integer getFundingCurrency() {
    return this.fundingCurrency;
  }

  /**
   * M�todo set do atributo fundingCurrency
   *
   * @param fundingCurrency Valor para setar no atributo fundingCurrency
   */
  protected void setFundingCurrency(final Integer fundingCurrency) {
    this.fundingCurrency = fundingCurrency;
  }

  /**
   * M�todo get do atributo installmentSequenceNumber
   *
   * @return O valor do atributo installmentSequenceNumber
   */
  public final Integer getInstallmentSequenceNumber() {
    return this.installmentSequenceNumber;
  }

  /**
   * M�todo set do atributo installmentSequenceNumber
   *
   * @param installmentSequenceNumber Valor para setar no atributo installmentSequenceNumber
   */
  public final void setInstallmentSequenceNumber(final Integer installmentSequenceNumber) {
    this.installmentSequenceNumber = installmentSequenceNumber;
  }

}
