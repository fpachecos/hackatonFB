/**
 * Cielo S.A. Projeto BoB Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cielo.settlement.request.entity.enums.RequestTypeEnum;
import br.com.cielo.test.CamposEnum;

/**
 * Entidade representando a tabela TBSETR_FINANCE_ADJUSTMENT_REQ
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustment.java 46605 2015-08-05 13:50:22Z eyvd6c $
 */
public class SettlementFinancialAdjustment implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 49257982696974756L;

  public SettlementFinancialAdjustment() {

  }

  public SettlementFinancialAdjustment(List<String> listaCampos) throws ParseException {
    for (int i = 0; i < listaCampos.size(); i++) {
      switch (CamposEnum.values()[i]) {
        case NU_REQUEST:
          this.setNuRequest(listaCampos.get(i).isEmpty() ? null : Long.valueOf(listaCampos.get(i)));
          break;
        case CD_REQUEST_TYPE:
          this.setRequestType(
              listaCampos.get(i).isEmpty() ? null : RequestTypeEnum.parse(listaCampos.get(i)));
          break;
        case DH_REQUEST:
          this.setDhRequest(
              listaCampos.get(i).isEmpty() ? null : formatterDiaMesAno.parse(listaCampos.get(i)));
          break;
        case CD_REJECT_REASON:
          this.setCdRejectReason(
              listaCampos.get(i).isEmpty() ? null : Integer.parseInt(listaCampos.get(i)));
          break;
        case DT_SETTLEMENT_ADJUSTMENT:
          this.setDtSettlementAdjustment(listaCampos.get(i).isEmpty() ? null
              : formatterDiaMesAnoResumido.parse(listaCampos.get(i)));
          break;
        case VL_GROSS:
          this.setVlGross(listaCampos.get(i).isEmpty() ? null : new BigDecimal(listaCampos.get(i)));
          break;
        case CD_USER_ID:
          this.setCdUserId(listaCampos.get(i).isEmpty() ? null : listaCampos.get(i));
          break;
        case CD_TECHNOLOGY_TYPE:
          this.setCdTechnologyType(listaCampos.get(i).isEmpty() ? null
              : CaptureDevicesEnum.parse(Integer.valueOf(listaCampos.get(i))));
          break;
        case CD_STATUS_REQUEST:
          this.setCdStatusRequest(listaCampos.get(i).isEmpty() ? null
              : FinanceAdjustmentStatusEnum.parse(Integer.valueOf(listaCampos.get(i))));
          break;
        case NU_CUSTOMER:
          this.setNuCustomer(
              listaCampos.get(i).isEmpty() ? null : Long.valueOf(listaCampos.get(i)));
          break;
        case NU_MOD_CUSTOMER:
          this.setNuModCustomer(
              listaCampos.get(i).isEmpty() ? null : Integer.valueOf(listaCampos.get(i)));
          break;
        case NU_BATCH:
          this.setNuBatch(listaCampos.get(i).isEmpty() ? null : Long.valueOf(listaCampos.get(i)));
          break;
        case CD_MOVEMENT_TYPE:
          this.setCdMovementType(listaCampos.get(i).isEmpty() ? null
              : MovementTypeEnum.parse(Integer.valueOf(listaCampos.get(i))));
          break;
        case CD_REFUND_STATUS_REQUEST:
          this.setRefundRequestStatus(listaCampos.get(i).isEmpty() ? null
              : RefundStatusEnum.parse(Integer.valueOf(listaCampos.get(i))));
          break;
        case CD_ADJUSTMENT_REASON:
          this.setCdAdjustentReason(
              listaCampos.get(i).isEmpty() ? null : Integer.valueOf(listaCampos.get(i)));
          break;
        case DC_ADJUSTMENT_COMMENTS:
          this.setDcAdjustmentComments(listaCampos.get(i).isEmpty() ? null : listaCampos.get(i));
          break;
        case NU_LOAD_FILE_ID:
          this.setNuLoadFileId(
              listaCampos.get(i).isEmpty() ? null : Long.valueOf(listaCampos.get(i)));
          break;
        case CD_PRODUCT:
          this.setCdProduct(
              listaCampos.get(i).isEmpty() ? null : Integer.valueOf(listaCampos.get(i)));
          break;
        case CD_ENTRY_TYPE:
          this.setEntryType(
              listaCampos.get(i).isEmpty() ? null : Integer.parseInt(listaCampos.get(i)));
          break;
        default:
          break;
      }
    }
  }

  /**
   * format de data "dd/MM/yyyy HH:mm:ss"
   */
  private SimpleDateFormat formatterDiaMesAno = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  /**
   * format de data "dd/MM/yyyy"
   */
  private SimpleDateFormat formatterDiaMesAnoResumido = new SimpleDateFormat("dd/MM/yy");

  /**
   * NU_LOAD_FILE_ID
   */
  private Long nuLoadFileId;

  /**
   * NU_CUSTOMER*
   */
  private Long nuCustomer;

  /**
   * NU_MOD_CUSTOMER*
   */
  private Integer nuModCustomer;

  /**
   * NU_REQUEST*
   */
  private Long nuRequest;

  /**
   * CD_REQUEST_TYPE*
   */
  private RequestTypeEnum requestType;

  /**
   * DH_REQUEST*
   */
  private Date dhRequest;

  /**
   * CD_REJECT_REASON
   */
  private Integer cdRejectReason;

  /**
   * DT_SETTLEMENT_ADJUSTMENT
   */
  private Date dtSettlementAdjustment;

  /**
   * VL_GROSS
   */
  private BigDecimal vlGross;

  /**
   * CD_USER_ID
   */
  private String cdUserId;

  /**
   * CD_TECHNOLOGY_TYPE
   */
  private CaptureDevicesEnum cdTechnologyType;

  /**
   * CD_STATUS_REQUEST
   */
  private FinanceAdjustmentStatusEnum cdStatusRequest;

  /**
   * NU_BATCH
   */
  private Long nuBatch;

  /**
   * CD_MOVEMENT_TYPE
   */
  private MovementTypeEnum cdMovementType;

  /**
   * CD_ADJUSTMENT_REASON
   */
  private Integer cdAdjustentReason;

  /**
   * DC_ADJUSTMENT_COMMENTS
   */
  private String dcAdjustmentComments;

  /**
   * CD_REFUND_STATUS_REQUEST
   */
  private RefundStatusEnum refundRequestStatus = null;

  /**
   * TBSETR_ADJUSTMENT
   */
  private SettlementAdjustment adjustment;

  /**
   * CD_PRODUCT
   */
  private Integer cdProduct;

  /**
   * CD_ENTRY_TYPE
   */
  private Integer entryType;

  /**
   * IN_SETTLEMENT_TYPE
   */
  private SettlementTypeEnum inSettlementType;

  /**
   * Verifica se ir� realizar o insert
   */
  private boolean insert;

  /**
   * Retorna id
   *
   * @return Long
   */
  public Long getNuLoadFileId() {
    return this.nuLoadFileId;
  }

  /**
   * Atualiza id
   *
   * @param nuLoadFileId Long
   */
  public void setNuLoadFileId(final Long nuLoadFileId) {
    this.nuLoadFileId = nuLoadFileId;
  }

  /**
   * Retorna Customer Number
   *
   * @return Long
   */
  public Long getNuCustomer() {
    return this.nuCustomer;
  }

  /**
   * Atualiza Customer Number
   *
   * @param nuCustomer Integer
   */
  public void setNuCustomer(final Long nuCustomer) {
    this.nuCustomer = nuCustomer;
  }

  /**
   * Retorna Customer MOD number
   *
   * @return Integer
   */
  public Integer getNuModCustomer() {
    return this.nuModCustomer;
  }

  /**
   * Atualiza Customer MOD Number
   *
   * @param nuModCustomer Integer
   */
  public void setNuModCustomer(final Integer nuModCustomer) {
    this.nuModCustomer = nuModCustomer;
  }

  /**
   * Retorna request number
   *
   * @return Long
   */
  public Long getNuRequest() {
    return this.nuRequest;
  }

  /**
   * Atualiza request number
   *
   * @param nuRequest Long
   */
  public void setNuRequest(final Long nuRequest) {
    this.nuRequest = nuRequest;
  }

  /**
   * Retorna request type
   *
   * @return RequestTypeEnum
   */
  public RequestTypeEnum getRequestType() {
    return this.requestType;
  }

  /**
   * Atualiza request type
   *
   * @param requestType RequestTypeEnum
   */
  public void setRequestType(final RequestTypeEnum requestType) {
    this.requestType = requestType;
  }

  /**
   * Retorna data e hora da requisi��o
   *
   * @return Date
   */
  public Date getDhRequest() {
    return this.dhRequest;
  }

  /**
   * Atualiza data e hora da requisi��o
   *
   * @param dhRequest Date
   */
  public void setDhRequest(final Date dhRequest) {
    this.dhRequest = dhRequest;
  }

  /**
   * Retorna tipo da rejei��o
   *
   * @return Integer
   */
  public Integer getCdRejectReason() {
    return this.cdRejectReason;
  }

  /**
   * Atualiza tipo de rejei��o
   *
   * @param cdRejectReason Integer
   */
  public void setCdRejectReason(final Integer cdRejectReason) {
    this.cdRejectReason = cdRejectReason;
  }

  /**
   * Retorna a data do ajuste
   *
   * @return Date
   */
  public Date getDtSettlementAdjustment() {
    return this.dtSettlementAdjustment;
  }

  /**
   * Atualiza a data do ajuste
   *
   * @param dtSettlementAdjustment Date
   */
  public void setDtSettlementAdjustment(final Date dtSettlementAdjustment) {
    this.dtSettlementAdjustment = dtSettlementAdjustment;
  }

  /**
   * Retorna valor bruto do ajuste
   *
   * @return BigDecimal value
   */
  public BigDecimal getVlGross() {
    return this.vlGross;
  }

  /**
   * Retorna o valor bruto do ajuste
   *
   * @param vlGross BigDecimal
   */
  public void setVlGross(final BigDecimal vlGross) {
    this.vlGross = vlGross;
  }

  /**
   * Retorna o id do usu�rio
   *
   * @return String
   */
  public String getCdUserId() {
    return this.cdUserId;
  }

  /**
   * Atualiza o id do usu�rio
   *
   * @param cdUserId String
   */
  public void setCdUserId(final String cdUserId) {
    this.cdUserId = cdUserId;
  }

  /**
   * Retorna tipo de tecnologia
   *
   * @return CaptureDevicesEnum
   */
  public CaptureDevicesEnum getCdTechnologyType() {
    return this.cdTechnologyType;
  }

  /**
   * Atualiza o tipo de tecnologia
   *
   * @param cdTechnologyType Long
   */
  public void setCdTechnologyType(final CaptureDevicesEnum cdTechnologyType) {
    this.cdTechnologyType = cdTechnologyType;
  }

  /**
   * Retorna status da requisi��o
   *
   * @return RefundStatusEnum
   */
  public FinanceAdjustmentStatusEnum getCdStatusRequest() {
    return this.cdStatusRequest;
  }

  /**
   * Atualiza o status da requisi��o
   *
   * @param cdStatusRequest RefundStatusEnum
   */
  public void setCdStatusRequest(final FinanceAdjustmentStatusEnum cdStatusRequest) {
    this.cdStatusRequest = cdStatusRequest;
  }

  /**
   * Retorna o n�mero do batch
   *
   * @return Long
   */
  public Long getNuBatch() {
    return this.nuBatch;
  }

  /**
   * Atualiza o n�mero do batch
   *
   * @param nuBatch Long
   */
  public void setNuBatch(final Long nuBatch) {
    this.nuBatch = nuBatch;
  }

  /**
   * Retorna o tipo de movimento
   *
   * @return MovementTypeEnum
   */
  public MovementTypeEnum getCdMovementType() {
    return this.cdMovementType;
  }

  /**
   * Atualiza o tipo de movimento
   *
   * @param cdMovementType MovementTypeEnum
   */
  public void setCdMovementType(final MovementTypeEnum cdMovementType) {
    this.cdMovementType = cdMovementType;
  }

  /**
   * Retorna o motivo do ajuste
   *
   * @return Integer
   */
  public Integer getCdAdjustentReason() {
    return this.cdAdjustentReason;
  }

  /**
   * Atualiza o motivo do ajuste
   *
   * @param cdAdjustentReason Integer
   */
  public void setCdAdjustentReason(final Integer cdAdjustentReason) {
    this.cdAdjustentReason = cdAdjustentReason;
  }

  /**
   * Retorna coment�rio do ajuste
   *
   * @return String
   */
  public String getDcAdjustmentComments() {
    return this.dcAdjustmentComments;
  }

  /**
   * Atuliza o coment�rio do ajuste
   *
   * @param dcAdjustmentComments String
   */
  public void setDcAdjustmentComments(final String dcAdjustmentComments) {
    this.dcAdjustmentComments = dcAdjustmentComments;
  }

  /**
   * M�todo get do atributo adjustment
   *
   * @return O valor do atributo adjustment
   */
  public final SettlementAdjustment getAdjustment() {
    return this.adjustment;
  }

  /**
   * M�todo set do atributo adjustment
   *
   * @param adjustment Valor para setar no atributo adjustment
   */
  public final void setAdjustment(final SettlementAdjustment adjustment) {
    this.adjustment = adjustment;
  }

  /**
   * M�todo get do atributo refundRequestStatus
   *
   * @return refundRequestStatus
   */
  public final RefundStatusEnum getRefundRequestStatus() {
    return this.refundRequestStatus;
  }

  /**
   * M�todo set do atributo refundRequestStatus
   *
   * @param refundRequestStatus Valor para setar no atributo refundRequestStatus
   */
  public final void setRefundRequestStatus(final RefundStatusEnum refundRequestStatus) {
    this.refundRequestStatus = refundRequestStatus;
  }

  /**
   * M�todo get do atributo cdProduct
   *
   * @return O valor do atributo cdProduct
   */
  public Integer getCdProduct() {
    return this.cdProduct;
  }

  /**
   * M�todo set do atributo cdProduct
   *
   * @param cdProduct Valor para setar no atributo cdProduct
   */
  public void setCdProduct(final Integer cdProduct) {
    this.cdProduct = cdProduct;
  }

  /**
   * M�todo get do atributo entryType
   *
   * @return O valor do atributo entryType
   */
  public final Integer getEntryType() {
    return this.entryType;
  }

  /**
   * M�todo set do atributo entryType
   *
   * @param entryType Valor para setar no atributo entryType
   */
  public final void setEntryType(final Integer entryType) {
    this.entryType = entryType;
  }

  /**
   * M�todo get do atributo inSettlementType
   *
   * @return O valor do atributo inSettlementType
   */
  public SettlementTypeEnum getInSettlementType() {
    return this.inSettlementType;
  }

  /**
   * M�todo set do atributo inSettlementType
   *
   * @param inSettlementType Valor para setar no atributo inSettlementType
   */
  public void setInSettlementType(final SettlementTypeEnum inSettlementType) {
    this.inSettlementType = inSettlementType;
  }

  /**
   * M�todo get do atributo insert
   *
   * @return O valor do atributo insert
   */
  public boolean isInsert() {
    return this.insert;
  }

  /**
   * M�todo set do atributo insert
   *
   * @param insert Valor para setar no atributo insert
   */
  public void setInsert(final boolean insert) {
    this.insert = insert;
  }
}
