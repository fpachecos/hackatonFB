/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.batch.entity.HashFields;
import br.com.cielo.settlement.entity.HashFieldsCompany;

/**
 * Serviço para geração de hash ou da chave de agerupamento.
 *
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de
 *         Oliveira</a>
 * @version $Id: HashService.java 78996 2016-11-09 20:32:57Z eyve4g $
 */
public interface HashService {

    /**
     * Gera um hash com base no algoritmo SHA-1 a partir do valor passado como
     * parâmetro
     *
     * @param characters
     *            valor a partir do qual o hash será gerado.
     * @return hash gerado a partir do parâmetro characters.
     * @throws BusinessException
     *             caso ocorra um erro na geração do hash.
     */
    String generateHashSHA1(final String characters) throws BusinessException;

    /**
     * Gera a chave de agrupamento para uma transação capturada. A chave de
     * agrupamento passará por um algoritmo de hash SHA-1, sendo então utilizada
     * para identificar quais transações estão no mesmo agrupamento financeiro.
     *
     * @param hashFieldsKey
     *            chave com campo utilizados para gerar o hash.
     * @return chave de agrupamento
     */
    String generateGroupingKey(HashFields hashFieldsKey);

    /**
     * Gera a chave de agrupamento para uma transação capturada. A chave de
     * agrupamento passará por um algoritmo de hash SHA-1, sendo então utilizada
     * para identificar quais transações estão no mesmo agrupamento financeiro,
     * FIDC.
     *
     * @param hashFieldsKey
     *            chave com campo utilizados para gerar o hash.
     * @return chave de agrupamento
     */
    String generateGroupingKeyMovementCompany(HashFieldsCompany hashFieldsKey);
}
