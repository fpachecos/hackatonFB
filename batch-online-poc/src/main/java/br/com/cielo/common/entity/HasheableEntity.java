/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 * 
 * Copyright 2014
 */
package br.com.cielo.common.entity;

/** 
 * Entidade representante da regra que associa chave de pesquisa 
 * para valores.
 * 
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de Oliveira</a>
 * @version $Id: HasheableEntity.java 44495 2015-12-22 16:30:58Z salvador $
 *
 */
public class HasheableEntity implements Hasheable {

	/**
	 * </br>Hash SHA-1 gerado a partir da concatenação
	 * dos campos que determinam o agrupamento das transações em lançamentos
	 * financeiros.
	 */
	protected String hash;

	/**
	 * Método set do atributo hash
	 * @param hash Valor para setar no atributo hash
	 */
	@Override
	public void setHash(String hash) {
		this.hash = hash;
	}

    /**
	 * Método get do atributo hash
	 * @return O valor do atributo hash
	 */
	@Override
	public String getHash() {
		return this.hash;
	}
}
