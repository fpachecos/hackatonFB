package br.com.cielo.settlement.entity;

/**
 * Enum que representa a tabela TBSETR_REFUND_STATUS
 * 
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: RefundStatusEnum.java 17/06/2014 - 12:27:41
 */
public enum RefundStatusEnum {

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
     * Tipo Reversão Solicitada
     */
    REQUESTED_REVERSAL(5, "Reversão Solicitada"),
    /**
     * Tipo Reversão Aprovada
     */
    REVERSAL_APPROVED(6, "Reversão Aprovada"),
    /**
     * Tipo Reversão Rejeitada
     */
    REVERSAL_REJECTED(7, "Reversão Rejeitada"),
    /**
     * Tipo Revertida
     */
    REVERSED(8, "Revertida"),
    /**
     * Tipo Cancelamento Anulado
     */
    ANNULLED(9, "Cancelamento Anulado"),

    /**
     * TIPO UNKNOWN
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
    private RefundStatusEnum(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Retorna o Enum correspondente ao código passado
     * 
     * @return RefundStatusEnum
     * @param code codigo
     */
    public static RefundStatusEnum parse(final Integer code) {

        RefundStatusEnum refundStatusReturn = UNKNOWN;

        for (RefundStatusEnum refundStatus : RefundStatusEnum.values()) {
            if (refundStatus.getCode().equals(code)) {
                refundStatusReturn = refundStatus;
                break;
            }
        }

        return refundStatusReturn;
    }

    /**
     * Método get do atributo code
     * 
     * @return O valor do atributo code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * Método get do atributo description
     * 
     * @return O valor do atributo description
     */
    public String getDescription() {
        return this.description;
    }

}
