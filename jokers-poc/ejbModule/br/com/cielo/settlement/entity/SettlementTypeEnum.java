/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import br.com.cielo.common.entity.CodedEnum;
import br.com.cielo.common.util.Enums;

/**
 * Enum que representa os tipos de Tipo de Settlement
 *
 * @author <a href="mailto:waldeir@cielo.com.br>Waldeir</a>
 * @version $Id: SettlementTypeEnum.java 72602 2016-08-23 13:59:26Z eyvdg1 $
 */
public enum SettlementTypeEnum implements CodedEnum<String> {

    /**
     * Tipo Débito
     */
    DEBIT("D"),
    /**
     * Tipo Crédito
     */
    CREDIT("C");

    private String code;

    /**
     * Defini code Construtor sobrecarregado.
     *
     * @param code código referente ao tipo de settlement.
     */
    private SettlementTypeEnum(final String code) {
        this.code = code;
    }

    /*
     * (non-Javadoc)
     * @see br.com.cielo.common.batch.entity.CodedEnum#getCode()
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Valida se o código do banco está na lista do tipo de Settlement Método parse. Utilizado para parse utilizando
     * código do tipo de settlement.
     *
     * @param code código referente ao domícilio bancário a ser criado
     * @return SettlementTypeEnum entidade para definição de tipo de settlement.
     */
    public static SettlementTypeEnum parse(final String code) {
        return Enums.parse(code, values(), CREDIT);
    }

    /**
     * Traduz o tipo de liquidação do produto para a categoria de pagamento correspondente.
     *
     * @deprecated - conceitos diferentes, utilizar SettlementTypeEnum para tipo de liquidação
     * e PaymentCategoryEnum para tipo de pagamento
     *
     * @return Categoria de Pagamento correspondente ao Tipo de Liquidação do Produto
     * Traduz o tipo de liquidação do produto para a categoria de pagamento correspondente.
     *
     * @return Categoria de Pagamento correspondente ao Tipo de Liquidação do Produto
     */
    @Deprecated
    public PaymentCategoryEnum toPaymentCategory() {

        PaymentCategoryEnum paymentCategory;

        if (SettlementTypeEnum.CREDIT.equals(this)) {
            paymentCategory = PaymentCategoryEnum.CREDIT;
        } else {
            paymentCategory = PaymentCategoryEnum.DEBIT;
        }

        return paymentCategory;
    }

    /**
     * Verifica se o tipo de liquidação é crédito.
     * @param acronym - tipo de liquidação
     * @return TRUE - É CRÉDITO | FALSE - NÃO É CRÉDITO
     */
    public Boolean isCredit(final String acronym) {
        return SettlementTypeEnum.CREDIT.equals(acronym);
    }

    /**
     * Verifica se o tipo de liquidação é débito.
     * @param acronym - tipo de liquidação
     * @return TRUE - É Débito | FALSE - NÃO É DÉBITO
     */
    public Boolean isDebit(final String acronym) {
        return SettlementTypeEnum.DEBIT.equals(acronym);
    }

}