package br.com.cielo.settlement.entity;

/**
 * Constantes de regras de reembolso
 * 
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: RefundReversal.java 18/06/2014 - 14:05:39
 */
public enum RefundRulesEnum {

    /**
     * Regras para solicitação de cancelamento.
     */
    REFUND_REQUEST_RULES,
    /**
     * Regras para ajustes de cancelamento.
     */
    REFUND_ADJUSTMENT_RULES,
    /**
     * Regras para reversão de cancelamento.
     */
    REFUND_REVERSAL_RULES,
    /**
     * Ajustes genéricos.
     */
    GENERIC_ADJUSTMENTS

}
