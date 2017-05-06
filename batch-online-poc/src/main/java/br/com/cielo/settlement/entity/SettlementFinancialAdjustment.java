/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.entity;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.settlement.request.entity.enums.RequestTypeEnum;

/**
 * Entidade representando a tabela TBSETR_FINANCE_ADJUSTMENT_REQ
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustment.java 46605 2015-08-05 13:50:22Z
 *          eyvd6c $
 */
public class SettlementFinancialAdjustment {

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
     * Verifica se irá realizar o insert
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
     * @param nuLoadFileId
     *            Long
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
     * @param nuCustomer
     *            Integer
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
     * @param nuModCustomer
     *            Integer
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
     * @param nuRequest
     *            Long
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
     * @param requestType
     *            RequestTypeEnum
     */
    public void setRequestType(final RequestTypeEnum requestType) {
        this.requestType = requestType;
    }

    /**
     * Retorna data e hora da requisição
     *
     * @return Date
     */
    public Date getDhRequest() {
        return this.dhRequest;
    }

    /**
     * Atualiza data e hora da requisição
     *
     * @param dhRequest
     *            Date
     */
    public void setDhRequest(final Date dhRequest) {
        this.dhRequest = dhRequest;
    }

    /**
     * Retorna tipo da rejeição
     *
     * @return Integer
     */
    public Integer getCdRejectReason() {
        return this.cdRejectReason;
    }

    /**
     * Atualiza tipo de rejeição
     *
     * @param cdRejectReason
     *            Integer
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
     * @param dtSettlementAdjustment
     *            Date
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
     * @param vlGross
     *            BigDecimal
     */
    public void setVlGross(final BigDecimal vlGross) {
        this.vlGross = vlGross;
    }

    /**
     * Retorna o id do usuário
     *
     * @return String
     */
    public String getCdUserId() {
        return this.cdUserId;
    }

    /**
     * Atualiza o id do usuário
     *
     * @param cdUserId
     *            String
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
     * @param cdTechnologyType
     *            Long
     */
    public void setCdTechnologyType(final CaptureDevicesEnum
    		cdTechnologyType) {
        this.cdTechnologyType = cdTechnologyType;
    }

    /**
     * Retorna status da requisição
     *
     * @return RefundStatusEnum
     */
    public FinanceAdjustmentStatusEnum getCdStatusRequest() {
        return this.cdStatusRequest;
    }

    /**
     * Atualiza o status da requisição
     *
     * @param cdStatusRequest
     *            RefundStatusEnum
     */
    public void setCdStatusRequest(final FinanceAdjustmentStatusEnum cdStatusRequest) {
        this.cdStatusRequest = cdStatusRequest;
    }

    /**
     * Retorna o número do batch
     *
     * @return Long
     */
    public Long getNuBatch() {
        return this.nuBatch;
    }

    /**
     * Atualiza o número do batch
     *
     * @param nuBatch
     *            Long
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
     * @param cdMovementType
     *            MovementTypeEnum
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
     * @param cdAdjustentReason
     *            Integer
     */
    public void setCdAdjustentReason(final Integer cdAdjustentReason) {
        this.cdAdjustentReason = cdAdjustentReason;
    }

    /**
     * Retorna comentário do ajuste
     *
     * @return String
     */
    public String getDcAdjustmentComments() {
        return this.dcAdjustmentComments;
    }

    /**
     * Atuliza o comentário do ajuste
     *
     * @param dcAdjustmentComments
     *            String
     */
    public void setDcAdjustmentComments(final String dcAdjustmentComments) {
        this.dcAdjustmentComments = dcAdjustmentComments;
    }

    /**
     * Método get do atributo adjustment
     *
     * @return O valor do atributo adjustment
     */
    public final SettlementAdjustment getAdjustment() {
        return this.adjustment;
    }

    /**
     * Método set do atributo adjustment
     *
     * @param adjustment
     *            Valor para setar no atributo adjustment
     */
    public final void setAdjustment(final SettlementAdjustment adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * Método get do atributo refundRequestStatus
     *
     * @return refundRequestStatus
     */
    public final RefundStatusEnum getRefundRequestStatus() {
        return this.refundRequestStatus;
    }

    /**
     * Método set do atributo refundRequestStatus
     *
     * @param refundRequestStatus
     *            Valor para setar no atributo refundRequestStatus
     */
    public final void setRefundRequestStatus(final RefundStatusEnum refundRequestStatus) {
        this.refundRequestStatus = refundRequestStatus;
    }

    /**
     * Método get do atributo cdProduct
     *
     * @return O valor do atributo cdProduct
     */
    public Integer getCdProduct() {
        return this.cdProduct;
    }

    /**
     * Método set do atributo cdProduct
     *
     * @param cdProduct
     *            Valor para setar no atributo cdProduct
     */
    public void setCdProduct(final Integer cdProduct) {
        this.cdProduct = cdProduct;
    }

    /**
     * Método get do atributo entryType
     *
     * @return O valor do atributo entryType
     */
    public final Integer getEntryType() {
        return this.entryType;
    }

    /**
     * Método set do atributo entryType
     *
     * @param entryType
     *            Valor para setar no atributo entryType
     */
    public final void setEntryType(final Integer entryType) {
        this.entryType = entryType;
    }

    /**
     * Método get do atributo inSettlementType
     *
     * @return O valor do atributo inSettlementType
     */
    public SettlementTypeEnum getInSettlementType() {
        return this.inSettlementType;
    }

    /**
     * Método set do atributo inSettlementType
     *
     * @param inSettlementType
     *            Valor para setar no atributo inSettlementType
     */
    public void setInSettlementType(final SettlementTypeEnum inSettlementType) {
        this.inSettlementType = inSettlementType;
    }

    /**
     * Método get do atributo insert
     *
     * @return O valor do atributo insert
     */
    public boolean isInsert() {
        return this.insert;
    }

    /**
     * Método set do atributo insert
     *
     * @param insert
     *            Valor para setar no atributo insert
     */
    public void setInsert(final boolean insert) {
        this.insert = insert;
    }
}
