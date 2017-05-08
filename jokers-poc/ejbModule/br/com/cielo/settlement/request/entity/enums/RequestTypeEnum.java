/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.request.entity.enums;

/**
 * Enum para RequestType
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: RequestTypeEnum.java 79904 2016-11-21 16:24:00Z eyvelm $
 */
public enum RequestTypeEnum {

  /**
   * Cancelamento.
   */
  REFUND("C"),
  /**
   * Ajuste Financeiro.
   */
  FINANCIAL_ADJUSTMENT("F"),
  /**
   * Cobran�a
   */
  BILLING("B"),

  /**
   * Antecipa��o de Receb�veis - ARV
   */
  ANTICIPATION("A"),

  /**
   * Chargeback
   */
  CHARGEBACK("H"),

  /**
   * Estorno
   */
  ESTORNO("E"),

  /**
   * Farol
   */
  FAROL("L"),

  /**
   * Recarga
   */
  RECHARGE("R"),

  /**
   * Promo
   */
  PROMO("P")

  ;

  private String code;

  /**
   * contrutor de RequestTypeEnum
   *
   * @param code String
   */
  private RequestTypeEnum(final String code) {
    this.code = code;
  }

  /**
   * Retorna o Enum correspondente ao c�digo passado
   *
   * @param code codigo
   * @return RequestTypeEnum
   */
  public static RequestTypeEnum parse(final String code) {
    for (RequestTypeEnum requestType : RequestTypeEnum.values()) {
      if (requestType.getCode().equals(code)) {
        return requestType;
      }
    }
    throw new IllegalArgumentException("Unknown RequestTypeEnum [" + code + "]");
  }

  /**
   * M�todo get do atributo code
   *
   * @return O valor do atributo code
   */
  public String getCode() {
    return this.code;
  }

}
