package br.com.cielo.settlement.entity;

import br.com.cielo.common.entity.CodedEnum;

/**
 * Enum que representa a tabela TBPRDR_PAYMENT_CATEGORY - Tipo de pagamento do produto
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: SettlementProductsEnum.java 17/06/2014 - 12:24:15
 */
public enum PaymentCategoryEnum implements CodedEnum<Integer> {

  /**
   * Tipo Cr�dito
   */
  CREDIT(1, "Cr�dito", "C"),

  /**
   * Tipo D�bito
   */
  DEBIT(2, "D�bito", "D"),

  /**
   * Tipo Cr�dito Especializado
   */
  CREDIT_SKILLED(3, "Cr�dito Especializado", "C");

  /**
   * Campo Integer code.
   */
  private Integer code;

  /**
   * Campo String description.
   */
  private String description;

  /**
   * Sigla C - cr�dito , D - d�bito
   */
  private String acronym;

  /**
   * Defini os valores de code e description Construtor sobrecarregado.
   *
   * @param code codigo do produto
   * @param description descricao do produto
   * @param acronym sigla
   */
  private PaymentCategoryEnum(final Integer code, final String description, final String acronym) {
    this.code = code;
    this.description = description;
    this.acronym = acronym;
  }

  /**
   * Retorna o Enum correspondente ao c�digo passado
   *
   * @param code codigo
   * @return SettlementProductsEnum
   */
  public static PaymentCategoryEnum parse(final Integer code) {

    for (PaymentCategoryEnum settlementProduct : PaymentCategoryEnum.values()) {
      if (settlementProduct.getCode().equals(code)) {
        return settlementProduct;
      }
    }
    throw new IllegalArgumentException("Unknown PaymentCategoryEnum [" + code + "]");
  }

  /**
   * Retorna o Enum correspondente a descri��o passada
   *
   * @param description descri��o
   * @return SettlementProductsEnum
   */
  public static PaymentCategoryEnum parse(final String description) {

    for (PaymentCategoryEnum settlementProduct : PaymentCategoryEnum.values()) {
      if (settlementProduct.getAcronym().equals(description)) {
        return settlementProduct;
      }
    }
    throw new IllegalArgumentException("Unknown PaymentCategoryEnum [" + description + "]");
  }

  /**
   * M�todo get do atributo code
   *
   * @return O valor do atributo code
   */
  @Override
  public Integer getCode() {
    return this.code;
  }

  /**
   * Obtem a sigla
   *
   * @return sigla
   * @deprecated - Utilizar SettlementTypeEnum
   */
  @Deprecated
  public String getAcronym() {
    return this.acronym;
  }

  /**
   * M�todo get do atributo description
   *
   * @return O valor do atributo description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * M�todo set do atributo description
   *
   * @param description Valor para setar no atributo description
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}
