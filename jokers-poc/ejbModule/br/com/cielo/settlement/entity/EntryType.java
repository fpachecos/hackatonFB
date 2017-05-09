/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.io.Serializable;

/**
 * Classe que representa os tipos de lan�amentos da transa��o.
 * 
 * @author <a href="mailto:rsousa@cielo.com.br>NOME_EXTENSO</a>
 * @version $Id: EntryType.java 56784 2016-02-04 21:41:26Z eyvdbm $
 */
public class EntryType implements Serializable {

  private static final long serialVersionUID = 1L;

  public EntryType() {}

  /**
   * Campo EntryType REFUND_ADJUSTEMENT
   */
  public static final EntryType REFUND_ADJUSTMENT = new EntryType(20005, "Ajuste de cancelamento");
  /**
   * Campo EntryType REVERSAL_ADJUSTEMENT
   */
  public static final EntryType REVERSAL_ADJUSTMENT =
      new EntryType(20006, "Ajuste de revers�o de cancelamento");

  /**
   * Campo EntryType GENERIC_ADJUSTMENT
   */
  public static final EntryType GENERIC_ADJUSTMENT = new EntryType(20009, "Ajuste Gen�rico");

  /**
   * Tipo de lan�amento para ajustes ARV.
   */
  public static final EntryType ANTICIPATION_ADJUSTMENT =
      new EntryType(20010, "Ajuste cr�dito para efeito de antecipa��o de receb�veis");

  /**
   * Tipo de lan�amento para ajustes Settlement/Biiling.
   */
  public static final EntryType SETTLEMENT_BIILING_ADJUSTMENT =
      new EntryType(20011, "Ajuste de lan�amento de cobran�a");


  /**
   * Campo EntryType CIELO_PLAN
   */
  public static final EntryType CIELO_PLAN = new EntryType(40001, "Plano Cielo");

  /**
   * Campo EntryType CIELO_PLAN
   */
  public static final EntryType RETROACTIVE_CIELO_PLAN =
      new EntryType(40002, "Plano Cielo retroativo");

  /**
   * Campo Integer codeType
   */
  private Integer codeType;

  /**
   * Campo String descriptionType
   */
  private String descriptionType;

  /**
   * M�todo construtor para criar o objeto EntryType.
   * 
   * @param codeType tipo do codigo
   * @param descriptionType tipo da descricao
   */
  public EntryType(final Integer codeType, final String descriptionType) {
    this.codeType = codeType;
    this.descriptionType = descriptionType;
  }

  /**
   * get de codeType
   * 
   * @return Integer codeType
   */
  public Integer getCodeType() {
    return this.codeType;
  }

  /**
   * setter de codeType
   * 
   * @param codeType tipo do codigo
   */
  public void setCodeType(final Integer codeType) {
    this.codeType = codeType;
  }

  /**
   * getter de descriptionType
   * 
   * @return descriptionType
   */
  public String getDescriptionType() {
    return this.descriptionType;
  }

  /**
   * setter de descriptionType
   * 
   * @param paramDescriptionType tipo de descricao
   */
  public void setDescription(final String paramDescriptionType) {
    this.descriptionType = paramDescriptionType;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "EntryType [codeType=" + this.codeType + ", this.descriptionType=" + this.descriptionType
        + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    int hashCode = super.hashCode();

    if (this.getCodeType() != null) {
      hashCode = this.getCodeType().hashCode();
    }
    return hashCode;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    boolean isEqual = super.equals(obj);

    if (obj instanceof EntryType) {
      final EntryType entryTypeParam = (EntryType) obj;
      if (entryTypeParam.getCodeType() != null && this.getCodeType() != null) {
        isEqual = entryTypeParam.getCodeType().equals(this.getCodeType());
      }
    }
    return isEqual;
  }
}
