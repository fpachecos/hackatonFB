package br.com.cielo.common.exception;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Classe base para as <i>Checked Exceptions</i> do Sistema.
 * 
 * @author <a href="mailto:acarazzai@cielo.com.br">acarazzai</a>
 * @version $Id: AbstractException.java 13753 2014-09-19 18:47:10Z eyvd69 $
 */
public abstract class AbstractException extends Exception {

  private static final long serialVersionUID = -1035544782653090678L;

  private final transient String key;

  private transient Serializable[] args;

  /**
   * @param exceptionKey Chave da exceção no repositório de Mensagens
   */
  public AbstractException(final String exceptionKey) {
    super(exceptionKey);
    this.key = exceptionKey;
  }

  /**
   * @param exceptionKey Chave da exceção no repositório de Mensagens
   * @param cause Causa raiz da exceção
   */
  public AbstractException(final String exceptionKey, final Throwable cause) {

    super(exceptionKey, cause);
    this.key = exceptionKey;
  }

  /**
   * @param exceptionKey Chave da exceção no repositório de Mensagens
   * @param cause Causa raiz da Exceção
   * @param exceptionArgs Argumentos para preenchimento da mensagem do repositório. Utilize para
   *        prover detalhes adicionais do erro
   */
  public AbstractException(final String exceptionKey, final Throwable cause,
      final Serializable[] exceptionArgs) {

    super(exceptionKey, cause);
    this.key = exceptionKey;
    this.args = Arrays.copyOf(exceptionArgs, exceptionArgs.length);
  }

  /**
   * @return Chave da exceção no repositório de Mensagens
   */
  public final String getExceptionKey() {
    return this.key;
  }

  /**
   * @return Argumentos para preenchimento da mensagem do repositório, provendo informações
   *         adicionais a respeito do erro
   */
  public final Serializable[] getExceptionArgs() {
    return Arrays.copyOf(this.args, this.args.length);
  }
}
