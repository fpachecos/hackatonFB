/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

/**
 * Enum que representa a tabela
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: MovementTypeEnum.java 17/06/2014 - 12:33:54
 */
public enum MovementTypeEnum {

  /**
   * TIPO Ajuste a Cr�dito
   */
  CREDIT_ADJUST(1, "Ajuste a Cr�dito", "C"),
  /**
   * TIPO Ajuste a D�bito
   */
  DEBIT_ADJUST(2, "Ajuste a D�bito", "D"),
  /**
   * TIPO Chargeback (Debito)
   */
  CHARGEBACK(3, "Chargeback (Debito)", "D"),
  /**
   * TIPO Revers�o de Chargeback (Credito)
   */
  CHARGEBACK_REVERSION(4, "Revers�o de Chargeback (Credito)", "C"),
  /**
   * TIPO Antecipa��o de Receb�veis
   */
  ADVANCE_RECEIVABLES(5, "Antecipa��o de Receb�veis", null),
  /**
   * TIPO Compensa��o
   */
  CLEARING(6, "Compensa��o", null),

  ADVANCE_RECEIVABLES_COUNTER_PART(7, "Contrapartida de Antecipa��o de Receb�veis", null),

  CHARGEBACK_CANCEL(8, "Chargeback de Cancelamento", null),
  /**
   * TIPO Transa��o de Venda
   */
  SALE_TRANSACTION(22, "Transa��o de Venda", null),
  /**
   * TIPO Transa��o de Cancelamento
   */
  REFUND_TRANSACTION(27, "Transa��o de Cancelamento", null),
  /**
   * TIPO Revers�o de Cancelamento
   */
  REVERSAL_REFUND(28, "Revers�o de Cancelamento", "D"),

  /**
   * TIPO Ajuste a d�bito - Entrada em Debit Balance
   */
  DEBIT_ADJUST_GO_TO_DEBIT_BALANCE(29, "Ajuste a d�bito - Debit Balance", null),
  /**
   * TIPO Ajuste a cr�dito - Entrada em Debit Balance
   */
  CREDIT_ADJUST_GO_TO_DEBIT_BALANCE(30, "Ajuste a cr�dito - Debit Balance", null),
  /**
   * TIPO Ajuste a cr�dito - Retorno de Debit Balance
   */
  CREDIT_ADJUST_RETURN_FROM_DEBIT_BALANCE(31, "Ajuste a cr�dito - Retorno de Debit Balance", null),
  /**
   * TIPO Ajuste a d�bito - Retorno de Debit Balance
   */
  DEBIT_ADJUST_RETURN_FROM_DEBIT_BALANCE(32, "Ajuste a d�bito - Retorno de Debit Balance", null),
  /**
   * TIPO Ajuste a d�bito - Suspenso
   */
  DEBIT_ADJUST_SUSPENDED(33, "Ajuste a d�bito - Suspenso", null),
  /**
   * TIPO Ajuste a cr�dito - Suspenso
   */
  CREDIT_ADJUST_SUSPENDED(34, "Ajuste a cr�dito - Suspenso", null),
  /**
   * TIPO Ajuste a cr�dito - Retorno de Suspens�o
   */
  CREDIT_ADJUST_RETURN_FROM_SUSPENDED(35, "Ajuste a cr�dito - Retorno de Suspens�o", null),
  /**
   * TIPO Ajuste a d�bito - Retorno de Suspens�o
   */
  DEBIT_ADJUST_RETURN_FROM_SUSPENDED(36, "Ajuste a d�bito - Retorno de Suspens�o", null),
  /**
   * TIPO Cobran�a
   */
  CHARGING(37, "Cobran�a", "D"),

  /**
   * Entrada em reten��o
   */
  ENTERING_RETENTION(38, "In�cio de Reten��o", null),

  /**
   * Sa�da de reten��o.
   */
  LEAVING_RETENTION(40, "T�rmino de Reten��o", null),

  /**
   * Sa�da de reten��o por motivo de arv
   */
  LEAVING_RETENTION_BY_ARV_REASON(41, "T�rmino de reten��o por motivo de ARV", null),

  /**
   * Rejeitado Compensado
   */
  REJECT_COMPESATION(42, "Rejeitado Compensado ", null),

  /**
   * Desconto
   */
  BILLING_DISCONT(43, "Desconto", "C"),

  /**
   * Desconto Mobile
   */
  BILLING_MOBILE_DISCOUNT(44, "Desconto - Mobile", null),

  /**
   * Cobran�a (EC Cielo)
   */
  BILLING_CUSTOMER_CIELO(45, "Cobran�a (EC Cielo)", null),

  /**
   * Estorno Cobran�a (POS)
   */
  BILLING_REVERSAL_POS(46, "EstornoCobran�a (POS)", null),

  /**
   * Estorno Cobran�a (Mobile)
   */
  BILLING_REVERSAL_MOBILE(47, "EstornoCobran�a (Mobile)", null),

  /**
   * Cobran�a Retroativa de Chargeback - Mobile
   */
  BILLING_RETROACTIVE_CHARGEBACK(48, "Cobran�a Retroativa de Chargeback - Mobile", null),

  /**
   * Contrapartida de Compensacao de Credito
   */
  LEAVING_CREDIT(50, "Retirada de Credito Compensa��o", null),

  /**
   * Contrapartida de Compensacao de Debito
   */
  ENTERING_CREDIT(51, "Entrada de Credito Compensa��o", null),

  /**
   * Cobran�a Retroativa de Chargeback - Mobile
   */
  CHARGING_REVERSAL_CHARGEBACK_MOBILE(48, "Cobran�a Retroativa de Chargeback - Mobile", null),

  /**
   * Cobran�a (EC Cielo)
   */
  CHARGING_EC_CIELO(45, "Cobran�a (EC Cielo)", null),

  /**
   * Cobran�a Farol
   */
  CHARGE_LIGHTHOUSE(52, "Cobran�a Farol", null),

  /**
   * Recarga
   */
  RECHARGE(53, "Recarga", null),

  /**
   * Movimento FIDC
   */
  MOVEMENT_FIDC(54, "Movimento FIDC", null),

  /**
   * Revers�o de contesta��o de cancelamento
   */
  VOUCHER_CHARGEBACK_REVERSAL(55, "Revers�o de contesta��o de cancelamento", null),
  /**
   * Promo
   */
  PROMO(56, "Promo", null),
  /**
   * Contrapartida corretiva.
   */
  CORRECTIVE_COUNTERPART(57, "Contrapartida corretiva", null);

  /**
   * C�digo MovementTypeEnum
   */
  private Integer code;

  /**
   * Descri��o MovementTypeEnum
   */
  private String description;

  /**
   * Sigla MovementTypeEnum
   */
  private String acronym;

  /**
   * contrutor
   *
   * @param code codigo
   * @param description descricao
   * @param acronym String
   */
  private MovementTypeEnum(final Integer code, final String description, final String acronym) {
    this.code = code;
    this.description = description;
    this.acronym = acronym;
  }

  /**
   * Retorna o Enum correspondente ao c�digo passado
   *
   * @param code codigo
   * @return MovementTypeEnum
   */
  public static MovementTypeEnum parse(final Integer code) {

    for (final MovementTypeEnum movementType : MovementTypeEnum.values()) {
      if (movementType.getCode().equals(code)) {
        return movementType;
      }
    }
    throw new IllegalArgumentException("Unknown MovementTypeEnum [" + code + "]");
  }

  /**
   * M�todo get do atributo code
   *
   * @return O valor do atributo code
   */
  public Integer getCode() {
    return this.code;
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
   * M�todo get do atributo acronym
   *
   * @return O valor do atributo acronym
   */
  public final String getAcronym() {
    return this.acronym;
  }

}
