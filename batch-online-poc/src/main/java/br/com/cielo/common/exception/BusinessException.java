package br.com.cielo.common.exception;

import java.io.Serializable;

/**
 * <i>Checked Exception</i> lançada para indicar erros funcionais, no nível da
 * aplicação.
 * <p>
 * Diferente das <i>unchecked exceptions</i>, que indicam bugs ou exceções no
 * nível de sistema, estas exceções precisam ser capturadas e tratadas em um
 * bloco <code>catch</code>.
 * <p>
 * Esta classe deve ser usada com parcimônia. Se houver necessidade de criar
 * novas exceções que estendam de <code>BusinessException</code>, o assunto deve
 * ser discutido com o time de Arquitetura.
 * 
 * @author <a href="mailto:acarazzai@cielo.com.br">acarazzai</a>
 * @version $Id: BusinessException.java 5614 2014-07-16 11:13:14Z eyvd67 $
 */
public class BusinessException extends AbstractException {

    private static final long serialVersionUID = -1598356443758347218L;

    /**
     * @param exceptionKey Chave da exceção no repositório de Mensagens
     */
    public BusinessException(final String exceptionKey) {
        super(exceptionKey);
    }

    /**
     * @param exceptionKey Chave da exceção no repositório de Mensagens
     * @param cause Causa raiz da exceção
     */
    public BusinessException(final String exceptionKey, final Throwable cause) {
        super(exceptionKey, cause);
    }

    /**
     * @param exceptionKey Chave da exceção no repositório de Mensagens
     * @param cause Causa raiz da Exceção
     * @param exceptionArgs Argumentos para preenchimento da mensagem do
     *            repositório. Utilize para prover detalhes adicionais do erro
     */
    public BusinessException(final String exceptionKey, final Throwable cause,
            final Serializable[] exceptionArgs) {
        super(exceptionKey, cause, exceptionArgs);
    }

}
