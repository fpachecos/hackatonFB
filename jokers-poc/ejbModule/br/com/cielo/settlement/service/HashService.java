/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.batch.entity.HashFields;
import br.com.cielo.settlement.entity.HashFieldsCompany;

/**
 * Servi�o para gera��o de hash ou da chave de agerupamento.
 *
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de Oliveira</a>
 * @version $Id: HashService.java 78996 2016-11-09 20:32:57Z eyve4g $
 */
public interface HashService {

  /**
   * Gera um hash com base no algoritmo SHA-1 a partir do valor passado como par�metro
   *
   * @param characters valor a partir do qual o hash ser� gerado.
   * @return hash gerado a partir do par�metro characters.
   * @throws BusinessException caso ocorra um erro na gera��o do hash.
   */
  String generateHashSHA1(final String characters) throws BusinessException;

  /**
   * Gera a chave de agrupamento para uma transa��o capturada. A chave de agrupamento passar� por um
   * algoritmo de hash SHA-1, sendo ent�o utilizada para identificar quais transa��es est�o no mesmo
   * agrupamento financeiro.
   *
   * @param hashFieldsKey chave com campo utilizados para gerar o hash.
   * @return chave de agrupamento
   */
  String generateGroupingKey(HashFields hashFieldsKey);

  /**
   * Gera a chave de agrupamento para uma transa��o capturada. A chave de agrupamento passar� por um
   * algoritmo de hash SHA-1, sendo ent�o utilizada para identificar quais transa��es est�o no mesmo
   * agrupamento financeiro, FIDC.
   *
   * @param hashFieldsKey chave com campo utilizados para gerar o hash.
   * @return chave de agrupamento
   */
  String generateGroupingKeyMovementCompany(HashFieldsCompany hashFieldsKey);
}
