/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
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
     * TIPO Ajuste a Crédito
     */
    CREDIT_ADJUST(1, "Ajuste a Crédito", "C"),
    /**
     * TIPO Ajuste a Débito
     */
    DEBIT_ADJUST(2, "Ajuste a Débito", "D"),
    /**
     * TIPO Chargeback (Debito)
     */
    CHARGEBACK(3, "Chargeback (Debito)", "D"),
    /**
     * TIPO Reversão de Chargeback (Credito)
     */
    CHARGEBACK_REVERSION(4, "Reversão de Chargeback (Credito)", "C"),
    /**
     * TIPO Antecipação de Recebíveis
     */
    ADVANCE_RECEIVABLES(5, "Antecipação de Recebíveis", null),
    /**
     * TIPO Compensação
     */
    CLEARING(6, "Compensação", null),

    ADVANCE_RECEIVABLES_COUNTER_PART(7, "Contrapartida de Antecipação de Recebíveis", null),

    CHARGEBACK_CANCEL(8, "Chargeback de Cancelamento", null),
    /**
     * TIPO Transação de Venda
     */
    SALE_TRANSACTION(22, "Transação de Venda", null),
    /**
     * TIPO Transação de Cancelamento
     */
    REFUND_TRANSACTION(27, "Transação de Cancelamento", null),
    /**
     * TIPO Reversão de Cancelamento
     */
    REVERSAL_REFUND(28, "Reversão de Cancelamento", "D"),

    /**
     * TIPO Ajuste a débito - Entrada em Debit Balance
     */
    DEBIT_ADJUST_GO_TO_DEBIT_BALANCE(29, "Ajuste a débito - Debit Balance", null),
    /**
     * TIPO Ajuste a crédito - Entrada em Debit Balance
     */
    CREDIT_ADJUST_GO_TO_DEBIT_BALANCE(30, "Ajuste a crédito - Debit Balance", null),
    /**
     * TIPO Ajuste a crédito - Retorno de Debit Balance
     */
    CREDIT_ADJUST_RETURN_FROM_DEBIT_BALANCE(31, "Ajuste a crédito - Retorno de Debit Balance", null),
    /**
     * TIPO Ajuste a débito - Retorno de Debit Balance
     */
    DEBIT_ADJUST_RETURN_FROM_DEBIT_BALANCE(32, "Ajuste a débito - Retorno de Debit Balance", null),
    /**
     * TIPO Ajuste a débito - Suspenso
     */
    DEBIT_ADJUST_SUSPENDED(33, "Ajuste a débito - Suspenso", null),
    /**
     * TIPO Ajuste a crédito - Suspenso
     */
    CREDIT_ADJUST_SUSPENDED(34, "Ajuste a crédito - Suspenso", null),
    /**
     * TIPO Ajuste a crédito - Retorno de Suspensão
     */
    CREDIT_ADJUST_RETURN_FROM_SUSPENDED(35, "Ajuste a crédito - Retorno de Suspensão", null),
    /**
     * TIPO Ajuste a débito - Retorno de Suspensão
     */
    DEBIT_ADJUST_RETURN_FROM_SUSPENDED(36, "Ajuste a débito - Retorno de Suspensão", null),
    /**
     * TIPO Cobrança
     */
    CHARGING(37, "Cobrança", "D"),

    /**
     * Entrada em retenção
     */
    ENTERING_RETENTION(38, "Início de Retenção", null),

    /**
     * Saída de retenção.
     */
    LEAVING_RETENTION(40, "Término de Retenção", null),

    /**
     * Saída de retenção por motivo de arv
     */
    LEAVING_RETENTION_BY_ARV_REASON(41, "Término de retenção por motivo de ARV", null),

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
     * Cobrança (EC Cielo)
     */
    BILLING_CUSTOMER_CIELO(45, "Cobrança (EC Cielo)", null),

    /**
     * Estorno Cobrança (POS)
     */
    BILLING_REVERSAL_POS(46, "EstornoCobrança (POS)", null),

    /**
     * Estorno Cobrança (Mobile)
     */
    BILLING_REVERSAL_MOBILE(47, "EstornoCobrança (Mobile)", null),

    /**
     * Cobrança Retroativa de Chargeback - Mobile
     */
    BILLING_RETROACTIVE_CHARGEBACK(48, "Cobrança Retroativa de Chargeback - Mobile", null),

    /**
     * Contrapartida de Compensacao de Credito
     */
    LEAVING_CREDIT(50, "Retirada de Credito Compensação", null),

    /**
     * Contrapartida de Compensacao de Debito
     */
    ENTERING_CREDIT(51, "Entrada de Credito Compensação", null),

    /**
     * Cobrança Retroativa de Chargeback - Mobile
     */
    CHARGING_REVERSAL_CHARGEBACK_MOBILE(48, "Cobrança Retroativa de Chargeback - Mobile", null),

    /**
     * Cobrança (EC Cielo)
     */
    CHARGING_EC_CIELO(45, "Cobrança (EC Cielo)", null),

    /**
     * Cobrança Farol
     */
    CHARGE_LIGHTHOUSE(52, "Cobrança Farol", null),

    /**
     * Recarga
     */
    RECHARGE(53, "Recarga", null),

    /**
     * Movimento FIDC
     */
    MOVEMENT_FIDC(54, "Movimento FIDC", null),

    /**
     * Reversão de contestação de cancelamento
     */
    VOUCHER_CHARGEBACK_REVERSAL(55, "Reversão de contestação de cancelamento", null),
    /**
     * Promo
     */
    PROMO(56, "Promo", null),
    /**
     * Contrapartida corretiva.
     */
    CORRECTIVE_COUNTERPART(57, "Contrapartida corretiva", null);

    /**
     * Código MovementTypeEnum
     */
    private Integer code;

    /**
     * Descrição MovementTypeEnum
     */
    private String description;

    /**
     * Sigla MovementTypeEnum
     */
    private String acronym;

    /**
     * contrutor
     *
     * @param code
     *            codigo
     * @param description
     *            descricao
     * @param acronym
     *            String
     */
    private MovementTypeEnum(final Integer code, final String description, final String acronym) {
        this.code = code;
        this.description = description;
        this.acronym = acronym;
    }

    /**
     * Retorna o Enum correspondente ao código passado
     *
     * @param code
     *            codigo
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

    /**
     * Método get do atributo acronym
     *
     * @return O valor do atributo acronym
     */
    public final String getAcronym() {
        return this.acronym;
    }

}
