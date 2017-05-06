package br.com.cielo.common.entity;


/** 
 * Classe CodedEnum.
 * Utilizada para definição do método getCode().
 * @author <a href="mailto:eyvd67@prestadorcbmp.com.br">
 *              Daniel Perestrelo Vicente</a>
 * @version $Id: CodedEnum.java 6117 2014-07-21 16:54:10Z eyvd67 $
 * @param <T>
 */
public interface CodedEnum<T> {

    /**
     * Método getCode()
     * retorna código da entidade Enum pesquisada
     * @return T code
     */
    T getCode();

}