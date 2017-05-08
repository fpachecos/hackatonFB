/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 * 
 * Copyright 2014
 */
package br.com.cielo.common.util;

import br.com.cielo.common.entity.CodedEnum;

/**
 * @author <a href="mailto:acarazzai@cielo.com.br>acarazzai</a>
 * @version $Id$
 */
public final class Enums {

  /**
   * Construtor privado para evitar instanciação de classe utilitária
   */
  private Enums() {
    throw new AssertionError();
  }

  /**
   * Interpreta o código informado, encontrando o valor do Enum correspondente entre o array de
   * valores passados como parâmetro.
   * 
   * @param code Código a ser interpretado
   * @param values Valores possíveis do Enum para comparação. O código informado como parâmetro será
   *        comparado ao código parametrizado no enum
   * @return Valor do Enum correspondente ao código informado ou null, caso não seja encontrada
   *         correspondência
   * 
   * @param <E> Tipo do Enum. Deve implementar a interface {@link CodedEnum}
   * @param <T> Tipo do código do Enum retornado na chamada {@link CodedEnum#getCode()}
   */
  public static <E extends CodedEnum<T>, T> E parse(final T code, final E[] values) {
    return parse(code, values, null);
  }

  /**
   * Interpreta o código informado, encontrando o valor do Enum correspondente entre o array de
   * valores passados como parâmetro.
   * 
   * @param code Código a ser interpretado
   * @param values Valores possíveis do Enum para comparação. O código informado como parâmetro será
   *        comparado ao código parametrizado no enum
   * @param defaultValue Valor padrão, caso não seja encontrada correspondência para o código
   *        informado
   * @return Valor do Enum correspondente ao código informado ou o valor padrão informado, caso não
   *         seja encontrada correspondência
   * 
   * @param <E> Tipo do Enum. Deve implementar a interface {@link CodedEnum}
   * @param <T> Tipo do código do Enum retornado na chamada {@link CodedEnum#getCode()}
   */
  public static <E extends CodedEnum<T>, T> E parse(final T code, final E[] values,
      final E defaultValue) {

    E returnValue = defaultValue;

    for (E e : values) {
      if (e.getCode() != null && e.getCode().equals(code)) {
        returnValue = e;
        break;
      }
    }

    return returnValue;
  }

  /**
   * Extrai o valor do Enum, sem risco de ocorrer NullPointerException.
   * 
   * @param enumValue Valor do Enum
   * @return Código correspondente
   * 
   * @param <T> Tipo do código do Enum
   */
  public static <T> T safeCode(final CodedEnum<T> enumValue) {
    return enumValue == null ? null : enumValue.getCode();
  }
}
