/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import br.com.cielo.common.entity.CodedEnum;

/**
 * Classe MovementStatusEnum.
 * <p>
 * Enum que representa os tipos de Tipo de Status de Movimentos.
 *
 * @author <a href="mailto:eyvd67@prestadorcbmp.com.br">Daniel Perestrelo
 *         Vicente</a>
 * @version $Id: MovementStatusEnum.java 82447 2017-01-24 13:12:23Z t0112jff $
 */
public enum MovementStatusEnum implements CodedEnum<Integer> {

    /**
     * Enum do tipo "Pendente"
     */
    PENDING(0, "Pendente"),
    /**
     * Enum do tipo "Liquidado Crédito"
     */
    SETTLEMENT_CREDIT(1, "Liquidado Crédito"),
    /**
     * Enum do tipo "Liquidado Débito"
     */
    SETTLEMENT_DEBIT(2, "Liquidado Débito"),
    /**
     * Enum do tipo "Debit Balance"
     */
    DEBIT_BALANCE(3, "Debit Balance"),
    /**
     * Enum do tipo "Debito Compensado"
     */
    DEBIT_CLEARING(4, "Debito Compensado"),
    /**
     * Enum do tipo "Debito Pendente"
     */
    PENDING_EC_DEBIT(5, "Debito Pendente"),
    /**
     * Enum do tipo "Suspenso"
     */
    BLOCKED(6, "Suspenso"),
    /**
     * Enum do tipo "Suspenso"
     */
    REGULARIZED(7, "Regularizado"),
    /**
     * Determina quando um movimento está em retenção.
     */
    RETENTION(8, "Retenção"),
    /**
     * Determina que um movimento está pendente para Antecipação.
     */
    PENDING_ANTICIPATION(9, "Pendente por Antecipação"),
    /**
     * Determina que um movimento foi liquidado por Antecipação.
     */
    SETTLEMENT_ANTICIPATION(10, "Liquidado por Antecipação"),

    /**
     * Determina que um movimento esta Em Compensação
     */
    IN_COMPENSATION(11, "Em Compensação"),

    /**
     * Determina que um movimento foi Compensado
     */
    COMPENSATION(12, "Compensado"),

    /**
     * Determina que um movimento está pendente de Compensado
     */
    PENDING_COMPENSATION(13, "Pendente Compensação"),

    /**
     * Liquidação forçada.
     */
    FORCED_SETTLEMENT(14, "Liquidação forçada"),

    /**
     * Contrapartida de liquidação forçada.
     */
    FORCED_SETTLEMENT_COUNTERPART(15, "Contrapartida de liquidação forçada");

    /**
     * Campo Integer code.
     */
    private Integer code;

    /**
     * Campo String description.
     */
    private String description;

    /**
     * Construtor sobrecarregado.
     * <p>
     * Obtém um MovementStatusEnum a partir do código informado.
     *
     * @param code
     *            código de status de movimento.
     * @param description
     *            String
     */
    private MovementStatusEnum(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cielo.common.batch.entity.CodedEnum#getCode()
     */
    @Override
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

    /**
     * Método parse que cria um objeto MovementStatusEnum a partir do código
     * informado para pesquisa.
     *
     * @param code
     *            código de status de movimento para pesquisa.
     * @return MovementStatusEnum objeto encontrado para pesquisa.
     */
    public static MovementStatusEnum parse(final Integer code) {
        MovementStatusEnum result = PENDING;
        for (final MovementStatusEnum movementStatus : values()) {
            if (movementStatus.code.equals(code)) {
                result = movementStatus;
                break;
            }
        }
        return result;
    }
}
