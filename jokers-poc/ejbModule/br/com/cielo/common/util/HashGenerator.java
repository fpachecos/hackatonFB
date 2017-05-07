/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * Gera um hash baseado no algoritmo SHA-1 que será utilizado posteriormente para
 * agrupar as transações em lançamento financeiros.
 * 
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de Oliveira</a>
 * @version $Id: HashGenerator.java 54148 2015-12-22 18:42:45Z abdiel $
 *
 */
public class HashGenerator {

	/**
	 * Gera um hash com base no algoritmo SHA-1 a partir do valor passado como parâmetro
	 * @param characters valor a partir do qual o hash será gerado.
	 * @return hash gerado a partir do parâmetro characters.
	 * @throws NoSuchAlgorithmException caso o algoritmo de hash não seja encontrado no digest.
	 */
	public static String generateHashSHA1(final String characters) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
        return Hex.encodeHexString(md.digest(characters.getBytes()));
    }
}
