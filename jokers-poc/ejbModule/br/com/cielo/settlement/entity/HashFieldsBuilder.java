/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.util.Date;

import br.com.cielo.settlement.batch.entity.HashFields;

/**
 * @author moisesb
 * @version $Id: HashFieldsBuilder.java 46605 2015-08-05 13:50:22Z eyvd6c $
 */
public class HashFieldsBuilder {

  /**
   * Data de liquidação.
   */
  private transient Date settlementDate;

  /**
   * Data de captura.
   */
  private transient Date batchDate;

  /**
   * Identificador de arquivo carregado.
   */
  private transient String loadFileId;

  /**
   * Código do estabelecimento comercial.
   */
  private transient Long customerNumber;

  /**
   * Código do produto.
   */
  private transient Integer productCode;

  /**
   * Identificador da subpartição da tabela.
   */
  private transient Integer customerModNumber;

  /**
   * Segmento do parcelado.
   */
  private transient Integer installmentSegment;

  /**
   * Tipo do movimento.
   */
  private transient Integer movementType;

  /**
   * Moeda de liquidação.
   */
  private transient Integer fundingCurrency;

  /**
   * Número da Parcela.
   */
  private Integer installmentSequenceNumber;

  /**
   * Método set do atributo settlementDate
   * 
   * @param theSettlementDate Valor para setar no atributo settlementDate
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder settlementDate(final Date theSettlementDate) {
    this.settlementDate = theSettlementDate;
    return this;
  }

  /**
   * Método set do atributo batchDate
   * 
   * @param theBatchDate Valor para setar no atributo batchDate
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder batchDate(final Date theBatchDate) {
    this.batchDate = theBatchDate;
    return this;
  }

  /**
   * Método set do atributo loadFileId
   * 
   * @param theLoadFileId Valor para setar no atributo loadFileId
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder loadFileId(final String theLoadFileId) {
    this.loadFileId = theLoadFileId;
    return this;
  }

  /**
   * Método set do atributo customerNumber
   * 
   * @param theCustomerNumber Valor para setar no atributo customerNumber
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder customerNumber(final Long theCustomerNumber) {
    this.customerNumber = theCustomerNumber;
    return this;
  }

  /**
   * Método set do atributo productCode
   * 
   * @param theProductCode Valor para setar no atributo productCode
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder productCode(final Integer theProductCode) {
    this.productCode = theProductCode;
    return this;
  }

  /**
   * Método set do atributo customerModNumber
   * 
   * @param theCustomerModNumber Valor para setar no atributo customerModNumber
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder customerModNumber(final Integer theCustomerModNumber) {
    this.customerModNumber = theCustomerModNumber;
    return this;
  }

  /**
   * Método set do atributo installmentSegment
   * 
   * @param theInstallmentSegment Valor para setar no atributo installmentSegment
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder installmentSegment(final Integer theInstallmentSegment) {
    this.installmentSegment = theInstallmentSegment;
    return this;
  }

  /**
   * Método set do atributo movementType
   * 
   * @param theMovementType Valor para setar no atributo movementType
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder movementType(final Integer theMovementType) {
    this.movementType = theMovementType;
    return this;
  }

  /**
   * Método set do atributo fundingCurrency
   * 
   * @param theFundingCurrency Valor para setar no atributo fundingCurrency
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder fundingCurrency(final Integer theFundingCurrency) {
    this.fundingCurrency = theFundingCurrency;
    return this;
  }

  /**
   * Método set do atributo installmentSequenceNumber
   * 
   * @param theInstallmentSequenceNumber Valor para setar no atributo installmentSequenceNumber
   * @return HashFieldsBuilder
   */
  public HashFieldsBuilder installmentSequenceNumber(final Integer theInstallmentSequenceNumber) {
    this.installmentSequenceNumber = theInstallmentSequenceNumber;
    return this;
  }

  /**
   * cria um hashField
   * 
   * @return HashFields
   */
  public HashFields build() {
    return new HashFields(this.settlementDate, this.batchDate, this.loadFileId, this.customerNumber,
        this.productCode, this.customerModNumber, this.installmentSegment, this.movementType,
        this.fundingCurrency, this.installmentSequenceNumber);
  }

}
