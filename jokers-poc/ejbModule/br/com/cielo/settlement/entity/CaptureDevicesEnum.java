package br.com.cielo.settlement.entity;

/**
 * Enum que representa a tabela TBSETR_TECHNOLOGY_TYPE
 * 
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: CaptureDevicesEnum.java 17/06/2014 - 12:38:29
 */
public enum CaptureDevicesEnum {

  /**
   * Tipo POS
   */
  POS(1, "M�QUINA", 30),
  /**
   * Tipo TEF
   */
  TEF(2, "TEF", 30),
  /**
   * TIPO AUTOR_MANU
   */
  AUTOR_MANU(3, "AUTOR.MANU", 30),
  /**
   * TIPO URA
   */
  URA(4, "URA", 30),
  /**
   * TIPO EDI
   */
  EDI(5, "EDI", 30),
  /**
   * TIPO GDS
   */
  GDS(6, "GDS", 30),
  /**
   * TIPO E_COMMERCE
   */
  E_COMMERCE(7, "E-COMMERCE", 30),
  /**
   * TIPO MOBILE
   */
  MOBILE(8, "MOBILE", 30),
  /**
   * TIPO V_PEDAGIO
   */
  V_PEDAGIO(9, "V.PEDAGIO", 30),
  /**
   * TIPO BACKOFFICE
   */
  BACKOFFICE(10, "BACKOFFICE", 30),
  /**
   * TIPO CENTRAL
   */
  CENTRAL(11, "CENTRAL", 30),
  /**
   * TIPO UNKNOWN
   */
  UNKNOWN(-1, "UNKNOWN", 0);

  /**
   * refere-se ao code de CaptureDevicesEnum
   */
  private Integer code;

  /**
   * refere-se ao description de CaptureDevicesEnum
   */
  private String description;

  /**
   * refere-se ao refundLimitDay de CaptureDevicesEnum
   */
  private Integer refundLimitDay;

  /**
   * CaptureDevicesEnum
   * 
   * @param code codigo
   * @param description descricao
   * @param refundLimitDay limite de refund diario
   */
  private CaptureDevicesEnum(final Integer code, final String description,
      final Integer refundLimitDay) {
    this.code = code;
    this.description = description;
    this.refundLimitDay = refundLimitDay;
  }

  /**
   * Retorna o Enum correspondente ao c�digo passado
   * 
   * @param code codigo
   * @return captureDevice capture device
   */
  public static CaptureDevicesEnum parse(final Integer code) {
    CaptureDevicesEnum enumReturn = UNKNOWN;
    for (final CaptureDevicesEnum captureDevice : CaptureDevicesEnum.values()) {
      if (captureDevice.getCode().equals(code)) {
        enumReturn = captureDevice;
        break;
      }
    }
    return enumReturn;
  }

  /**
   * M�todo get do atributo code
   * 
   * @return O valor do atributo code
   */
  public Integer getCode() {
    return this.code;
  }

  /**
   * M�todo get do atributo description
   * 
   * @return O valor do atributo description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * M�todo get do atributo refundLimitDay
   * 
   * @return O valor do atributo refundLimitDay
   */
  public Integer getRefundLimitDay() {
    return this.refundLimitDay;
  }

}
