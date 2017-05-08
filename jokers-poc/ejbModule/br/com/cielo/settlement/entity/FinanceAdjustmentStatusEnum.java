package br.com.cielo.settlement.entity;

/**
 * Enum que representa a tabela TBSETR_FINANCE_ADJ_STATUS
 * 
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: FinanceAdjustmentStatusEnum.java 46605 2015-08-05 13:50:22Z eyvd6c $
 */
public enum FinanceAdjustmentStatusEnum {
  /**
   * Tipo Solicitada
   */
  REQUESTED(1, "Solicitada"),
  /**
   * Tipo Aprovada
   */
  APPROVED(2, "Aprovada"),
  /**
   * Tipo Rejeitada
   */
  REJECTED(3, "Rejeitada"),
  /**
   * Tipo Efetivada
   */
  EFFECTED(4, "Efetivada"),
  /**
   * Tipo Revers�o Solicitada
   */
  REQUESTED_REVERSAL(5, "Anulada"),
  /**
   * tipo unknown.
   */
  UNKNOWN(0, "UNKNOWN");

  /**
   * Campo Integer code.
   */
  private Integer code;
  /**
   * Campo String description.
   */
  private String description;

  /**
   * Construtor.
   * 
   * @param code codigo
   * @param description descricao
   */
  private FinanceAdjustmentStatusEnum(final Integer code, final String description) {
    this.code = code;
    this.description = description;
  }

  /**
   * Retorna o Enum correspondente ao c�digo passado
   * 
   * @return RefundStatusEnum
   * @param code codigo
   */
  public static FinanceAdjustmentStatusEnum parse(final Integer code) {

    for (FinanceAdjustmentStatusEnum refundStatus : FinanceAdjustmentStatusEnum.values()) {
      if (refundStatus.getCode().equals(code)) {
        return refundStatus;
      }
    }
    throw new IllegalArgumentException("Unknown Refund Status [" + code + "]");
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

}
