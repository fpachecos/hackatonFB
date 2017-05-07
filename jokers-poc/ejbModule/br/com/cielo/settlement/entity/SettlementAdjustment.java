package br.com.cielo.settlement.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.settlement.request.entity.enums.RequestTypeEnum;

/**
 * Classe que representa SettlementAdjustment - TBSETR_ADJUSTMENT
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: SettlementAdjustment.java 82745 2017-02-07 14:02:14Z t0112jff $
 */
public class SettlementAdjustment implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /**
     * Campo Long batchNumber. NU_BATCH NUMBER(20)
     */
    private Long batchNumber;

    /**
     * Campo Date batchDate. DT_BATCH DATE
     */
    private Date batchDate;

    /**
     * Campo EntryType entryType. CD_ENTRY_TYPE NUMBER(5)
     */
    private EntryType entryType;

    /**
     * Campo MovementTypeEnum movementTypeCode. CD_MOVEMENT_TYPE NUMBER(3)
     */
    private MovementTypeEnum movementTypeCode;

    /**
     * Campo Long refundRequestNumber. NU_REFUND_REQUEST
     */
    private Long requestNumber;

    /**
     * Campo Date requestDate.
     */
    private Date requestDate;

    /**
     * Campo Integer refundNsu. NU_NSU_REFUND
     */
    private Integer refundNsu;

    /**
     * Campo Long origialTransactionId. NU_TRANSACTION_ID_ORIGINAL
     */
    private Long origialTransactionId;

    /**
     * Campo Long customerNumber. NU_CUSTOMER NUMBER(16)
     */
    private Long customerNumber;

    /**
     * Campo BigDecimal adjustmentAmountValue. VL_ADJUSTMENT_AMOUNT
     */
    private BigDecimal adjustmentAmountValue;

    /**
     * Campo BigDecimal netAmountValue. VL_NET_AMOUNT
     */
    private BigDecimal netAmountValue;

    /**
     * Campo BigDecimal discountAmountValue. VL_DISCOUNT_AMOUNT
     */
    private BigDecimal discountAmountValue;

    /**
     * Campo Date adjustmentDate. DH_ADJUSTMENT
     */
    private Date adjustmentDate;

    /**
     * Campo Date settlementAdjstmentDate. DT_SETTLEMENT_ADJUSTMENT
     */
    private Date settlementAdjstmentDate;

    /**
     * Campo String inSettlement. IN_SETTLEMENT
     */
    private String inSettlement;

    /**
     * Campo Long loadFileIdNumber. NU_LOAD_FILE_ID NUMBER(20)
     */
    private Long loadFileIdNumber;

    /**
     * Campo Integer terminalNumber. NU_TERMINAL
     */
    private Integer terminalNumber;

    /**
     * Campo Integer productCode CD_PRODUCT
     */
    private Integer productCode;

    /**
     * Campo Integer customerModNumber. NU_MOD_CUSTOMER NUMBER
     */
    private Integer customerModNumber;

    /**
     * Campo Long acquirerCode. CD_ACQUIRER
     */
    private Long acquirerCode;

    /**
     * Campo CaptureDevicesEnum technologyType. CD_TECHNOLOGY_TYPE
     */
    private CaptureDevicesEnum technologyType;

    /**
     * Campo BigDecimal adjustementIcValue. VL_IC_ADJUSTMENT
     */
    private BigDecimal adjustmentIcValue;

    /**
     * Campo Integer installmentSequenceOrig. NU_INSTALLMENT_SEQ_ORIGINAL
     */
    private Integer installmentSequenceOrig;

    /**
     * Campo SettlementMovement movement.
     */
    private SettlementMovement movement;

    /**
     * Campo RequestTypeEnum requestType.
     */
    private RequestTypeEnum requestType;

    /**
     * Campo AdjustmentReasonEnum adjustmentReason CD_ADJUSTMENT_REASON
     */
    private Integer adjustmentReason;

    /**
     * Campo Long financialAdjustmentNumber NU_FINANCIAL_ADJUSTMENT
     */
    private String financialAdjustmentNumber;

    /**
     * Campo Long financialMovement NU_FINANCIAL_MOVEMENT
     */
    private String financialMovement;

//    /**
//     * Campo Refund refund.
//     */
//    private Refund refund;
//
//    /**
//     * Campo ChargebackRequest chargebackRequest
//     */
//    private ChargebackRequest chargebackRequest;
//    /**
//     * Campo ettlementMovementRelPayment movementRelPayment
//     */
//    private SettlementMovementRelPayment movementRelPayment;
//
//    /**
//     * Campo ChargebackRequest chargeBackReversal
//     */
//    private ChargebackRequest chargeBackReversal;

    /**
     * Valor do desconto original VL_DISCOUNT_ORIG
     */
    private BigDecimal valueOrigDiscount;

    /**
     *
     * Valor de prazo flexivel VL_FLEXIBLE_TERM
     */
    private BigDecimal valueFlexibleTerm;

    /**
     * Campo VL_GROSS_AVAILABLE_AMOUNT correspondente a transacao
     */
    private BigDecimal vlGrossAvailableAmountTrans;

    /**
     * Campo DT_BATCH_TRANS correspondente ao dt_batch_trans
     */
    private Date dtBatchTrans;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    /**
     * Método get do atributo batchNumber
     *
     * @return O valor do atributo batchNumber
     */
    public Long getBatchNumber() {
        return this.batchNumber;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SettlementAdjustment ["
                        + (this.batchNumber != null ? "batchNumber=" + this.batchNumber + ", " : "")
                        + (this.batchDate != null ? "batchDate=" + this.batchDate + ", " : "")
                        + (this.entryType != null ? "entryType=" + this.entryType + ", " : "")
                        + (this.movementTypeCode != null ? "movementTypeCode=" + this.movementTypeCode + ", " : "")
                        + (this.requestNumber != null ? "requestNumber=" + this.requestNumber + ", " : "")
                        + (this.requestDate != null ? "requestDate=" + this.requestDate + ", " : "")
                        + (this.refundNsu != null ? "refundNsu=" + this.refundNsu + ", " : "")
                        + (this.origialTransactionId != null ? "origialTransactionId=" + this.origialTransactionId
                                        + ", " : "")
                        + (this.customerNumber != null ? "customerNumber=" + this.customerNumber + ", " : "")
                        + (this.adjustmentAmountValue != null ? "adjustmentAmountValue=" + this.adjustmentAmountValue
                                        + ", " : "")
                        + (this.netAmountValue != null ? "netAmountValue=" + this.netAmountValue + ", " : "")
                        + (this.discountAmountValue != null
                                        ? "discountAmountValue=" + this.discountAmountValue + ", "
                                        : "")
                        + (this.adjustmentDate != null ? "adjustmentDate=" + this.adjustmentDate + ", " : "")
                        + (this.settlementAdjstmentDate != null ? "settlementAdjstmentDate="
                                        + this.settlementAdjstmentDate + ", " : "")
                        + (this.inSettlement != null ? "inSettlement=" + this.inSettlement + ", " : "")
                        + (this.loadFileIdNumber != null ? "loadFileIdNumber=" + this.loadFileIdNumber + ", " : "")
                        + (this.terminalNumber != null ? "terminalNumber=" + this.terminalNumber + ", " : "")
                        + (this.productCode != null ? "productCode=" + this.productCode + ", " : "")
                        + (this.customerModNumber != null ? "customerModNumber=" + this.customerModNumber + ", " : "")
                        + (this.acquirerCode != null ? "acquirerCode=" + this.acquirerCode + ", " : "")
                        + (this.technologyType != null ? "technologyType=" + this.technologyType + ", " : "")
                        + (this.adjustmentIcValue != null
                                        ? "adjustementIcValue=" + this.adjustmentIcValue + ", "
                                        : "")
                        + (this.installmentSequenceOrig != null ? "installmentSequenceOrig="
                                        + this.installmentSequenceOrig + ", " : "")
                        + (this.movement != null ? "movement=" + this.movement + ", " : "")
                        + (this.requestType != null ? "requestType=" + this.requestType + ", " : "")
                        + (this.adjustmentReason != null ? "adjustmentReason=" + this.adjustmentReason + ", " : "")
                        + (this.financialAdjustmentNumber != null ? "financialAdjustmentNumber="
                                        + this.financialAdjustmentNumber + ", " : "")
                        + (this.financialMovement != null ? "financialMovement=" + this.financialMovement + ", " : "")
//                        + (this.refund != null ? "refund=" + this.refund + ", " : "")
                        // + (this.chargebackRequest != null ?
                        // "chargebackRequest=" + this.chargebackRequest + ", "
                        // : "")
//                        + (this.movementRelPayment != null
//                                        ? "movementRelPayment=" + this.movementRelPayment + ", "
//                                        : "")
                        // + (this.chargeBackReversal != null
                        // ? "chargeBackReversal=" + this.chargeBackReversal +
                        // ", "
                        // : "")
                        + (this.valueOrigDiscount != null ? "valueOrigDiscount=" + this.valueOrigDiscount + ", " : "")
                        + (this.valueFlexibleTerm != null ? "valueFlexibleTerm=" + this.valueFlexibleTerm + ", " : "")
                        + (this.vlGrossAvailableAmountTrans != null ? "vlGrossAvailableAmountTrans="
                                        + this.vlGrossAvailableAmountTrans + ", " : "")
                        + (this.dtBatchTrans != null ? "dtBatchTrans=" + this.dtBatchTrans : "") + "]";
    }

    /**
     * Método set do atributo batchNumber
     *
     * @param batchNumber
     *            Valor para setar no atributo batchNumber
     */
    public void setBatchNumber(final Long batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * Método get do atributo batchDate
     *
     * @return O valor do atributo batchDate
     */
    public Date getBatchDate() {
        return this.batchDate;
    }

    /**
     * Método set do atributo batchDate
     *
     * @param batchDate
     *            Valor para setar no atributo batchDate
     */
    public void setBatchDate(final Date batchDate) {
        this.batchDate = batchDate;
    }

    /**
     * Método get do atributo entryType
     *
     * @return O valor do atributo entryType
     */
    public EntryType getEntryType() {
        return this.entryType;
    }

    /**
     * Método set do atributo entryType
     *
     * @param entryType
     *            Valor para setar no atributo entryType
     */
    public void setEntryType(final EntryType entryType) {
        this.entryType = entryType;
    }

    /**
     * Método get do atributo movementTypeCode
     *
     * @return O valor do atributo movementTypeCode
     */
    public MovementTypeEnum getMovementTypeCode() {
        return this.movementTypeCode;
    }

    /**
     * Método set do atributo movementTypeCode
     *
     * @param movementTypeCode
     *            Valor para setar no atributo movementTypeCode
     */
    public void setMovementTypeCode(final MovementTypeEnum movementTypeCode) {
        this.movementTypeCode = movementTypeCode;
    }

    /**
     * Método get do atributo requestNumber
     *
     * @return O valor do atributo requestNumber
     */
    public Long getRequestNumber() {
        return this.requestNumber;
    }

    /**
     * Método set do atributo requestNumber
     *
     * @param requestNumber
     *            Valor para setar no atributo requestNumber
     */
    public void setRequestNumber(final Long requestNumber) {
        this.requestNumber = requestNumber;
    }

    /**
     * Método get do atributo requestDate
     *
     * @return O valor do atributo requestDate
     */
    public Date getRequestDate() {
        return this.requestDate;
    }

    /**
     * Método set do atributo requestDate
     *
     * @param requestDate
     *            Valor para setar no atributo requestDate
     */
    public void setRequestDate(final Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Método get do atributo refundNsu
     *
     * @return O valor do atributo refundNsu
     */
    public Integer getRefundNsu() {
        return this.refundNsu;
    }

    /**
     * Método set do atributo refundNsu
     *
     * @param refundNsu
     *            Valor para setar no atributo refundNsu
     */
    public void setRefundNsu(final Integer refundNsu) {
        this.refundNsu = refundNsu;
    }

    /**
     * Método get do atributo origialTransactionId
     *
     * @return O valor do atributo origialTransactionId
     */
    public Long getOrigialTransactionId() {
        return this.origialTransactionId;
    }

    /**
     * Método set do atributo origialTransactionId
     *
     * @param origialTransactionId
     *            Valor para setar no atributo origialTransactionId
     */
    public void setOrigialTransactionId(final Long origialTransactionId) {
        this.origialTransactionId = origialTransactionId;
    }

    /**
     * Método get do atributo customerNumber
     *
     * @return O valor do atributo customerNumber
     */
    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    /**
     * Método set do atributo customerNumber
     *
     * @param customerNumber
     *            Valor para setar no atributo customerNumber
     */
    public void setCustomerNumber(final Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Método get do atributo adjustmentAmountValue
     *
     * @return O valor do atributo adjustmentAmountValue
     */
    public BigDecimal getAdjustmentAmountValue() {
        return this.adjustmentAmountValue;
    }

    /**
     * Método set do atributo adjustmentAmountValue
     *
     * @param adjustmentAmountValue
     *            Valor para setar no atributo adjustmentAmountValue
     */
    public void setAdjustmentAmountValue(final BigDecimal adjustmentAmountValue) {
        this.adjustmentAmountValue = adjustmentAmountValue;
    }

    /**
     * Método get do atributo netAmountValue
     *
     * @return O valor do atributo netAmountValue
     */
    public BigDecimal getNetAmountValue() {
        return this.netAmountValue;
    }

    /**
     * Método set do atributo netAmountValue
     *
     * @param netAmountValue
     *            Valor para setar no atributo netAmountValue
     */
    public void setNetAmountValue(final BigDecimal netAmountValue) {
        this.netAmountValue = netAmountValue;
    }

    /**
     * Método get do atributo discountAmountValue
     *
     * @return O valor do atributo discountAmountValue
     */
    public BigDecimal getDiscountAmountValue() {
        return this.discountAmountValue;
    }

    /**
     * Método set do atributo discountAmountValue
     *
     * @param discountAmountValue
     *            Valor para setar no atributo discountAmountValue
     */
    public void setDiscountAmountValue(final BigDecimal discountAmountValue) {
        this.discountAmountValue = discountAmountValue;
    }

    /**
     * Método get do atributo adjustmentDate
     *
     * @return O valor do atributo adjustmentDate
     */
    public Date getAdjustmentDate() {
        return this.adjustmentDate;
    }

    /**
     * Método set do atributo adjustmentDate
     *
     * @param adjustmentDate
     *            Valor para setar no atributo adjustmentDate
     */
    public void setAdjustmentDate(final Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    /**
     * Método get do atributo settlementAdjstmentDate
     *
     * @return O valor do atributo settlementAdjstmentDate
     */
    public Date getSettlementAdjstmentDate() {
        return this.settlementAdjstmentDate;
    }

    /**
     * Método set do atributo settlementAdjstmentDate
     *
     * @param settlementAdjstmentDate
     *            Valor para setar no atributo settlementAdjstmentDate
     */
    public void setSettlementAdjstmentDate(final Date settlementAdjstmentDate) {
        this.settlementAdjstmentDate = settlementAdjstmentDate;
    }

    /**
     * Método get do atributo inSettlement
     *
     * @return O valor do atributo inSettlement
     */
    public String getInSettlement() {
        return this.inSettlement;
    }

    /**
     * Método set do atributo inSettlement
     *
     * @param inSettlement
     *            Valor para setar no atributo inSettlement
     */
    public void setInSettlement(final String inSettlement) {
        this.inSettlement = inSettlement;
    }

    /**
     * Método get do atributo loadFileIdNumber
     *
     * @return O valor do atributo loadFileIdNumber
     */
    public Long getLoadFileIdNumber() {
        return this.loadFileIdNumber;
    }

    /**
     * Método set do atributo loadFileIdNumber
     *
     * @param loadFileIdNumber
     *            Valor para setar no atributo loadFileIdNumber
     */
    public void setLoadFileIdNumber(final Long loadFileIdNumber) {
        this.loadFileIdNumber = loadFileIdNumber;
    }

    /**
     * Método get do atributo terminalNumber
     *
     * @return O valor do atributo terminalNumber
     */
    public Integer getTerminalNumber() {
        return this.terminalNumber;
    }

    /**
     * Método set do atributo terminalNumber
     *
     * @param terminalNumber
     *            Valor para setar no atributo terminalNumber
     */
    public void setTerminalNumber(final Integer terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    /**
     * Método get do atributo customerModNumber
     *
     * @return O valor do atributo customerModNumber
     */
    public Integer getCustomerModNumber() {
        return this.customerModNumber;
    }

    /**
     * Método set do atributo customerModNumber
     *
     * @param customerModNumber
     *            Valor para setar no atributo customerModNumber
     */
    public void setCustomerModNumber(final Integer customerModNumber) {
        this.customerModNumber = customerModNumber;
    }

    /**
     * Método get do atributo acquirerCode
     *
     * @return O valor do atributo acquirerCode
     */
    public Long getAcquirerCode() {
        return this.acquirerCode;
    }

    /**
     * Método set do atributo acquirerCode
     *
     * @param acquirerCode
     *            Valor para setar no atributo acquirerCode
     */
    public void setAcquirerCode(final Long acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    /**
     * Método get do atributo technologyType
     *
     * @return O valor do atributo technologyType
     */
    public CaptureDevicesEnum getTechnologyType() {
        return this.technologyType;
    }

    /**
     * Método set do atributo technologyType
     *
     * @param technologyType
     *            Valor para setar no atributo technologyType
     */
    public void setTechnologyType(final CaptureDevicesEnum technologyType) {
        this.technologyType = technologyType;
    }

    /**
     * Método get do atributo adjustementIcValue
     *
     * @return O valor do atributo adjustementIcValue
     */
    public BigDecimal getAdjustmentIcValue() {
        return this.adjustmentIcValue;
    }

    /**
     * Método set do atributo adjustementIcValue
     *
     * @param adjustmentIcValue
     *            Valor para setar no atributo adjustementIcValue
     */
    public void setAdjustmentIcValue(final BigDecimal adjustmentIcValue) {
        this.adjustmentIcValue = adjustmentIcValue;
    }

    /**
     * Método get do atributo installmentSequenceOrig
     *
     * @return O valor do atributo installmentSequenceOrig
     */
    public Integer getInstallmentSequenceOrig() {
        return this.installmentSequenceOrig;
    }

    /**
     * Método set do atributo installmentSequenceOrig
     *
     * @param installmentSequenceOrig
     *            Valor para setar no atributo installmentSequenceOrig
     */
    public void setInstallmentSequenceOrig(final Integer installmentSequenceOrig) {
        this.installmentSequenceOrig = installmentSequenceOrig;
    }

    /**
     * Método get do atributo movement
     *
     * @return O valor do atributo movement
     */
    public SettlementMovement getMovement() {
        return this.movement;
    }

    /**
     * Método set do atributo movement
     *
     * @param movement
     *            Valor para setar no atributo movement
     */
    public void setMovement(final SettlementMovement movement) {
        this.movement = movement;
    }

    /**
     * Método get do atributo requestType
     *
     * @return O valor do atributo requestType
     */
    public RequestTypeEnum getRequestType() {
        return this.requestType;
    }

    /**
     * Método set do atributo requestType
     *
     * @param requestType
     *            Valor para setar no atributo requestType
     */
    public void setRequestType(final RequestTypeEnum requestType) {
        this.requestType = requestType;
    }

//    /**
//     * Método get do atributo refund
//     *
//     * @return O valor do atributo refund
//     */
//    public Refund getRefund() {
//        return this.refund;
//    }
//
//    /**
//     * Método set do atributo refund
//     *
//     * @param refund
//     *            Valor para setar no atributo refund
//     */
//    public void setRefund(final Refund refund) {
//        this.refund = refund;
//    }

    /**
     * Método get do atributo productCode
     *
     * @return O valor do atributo productCode
     */
    public Integer getProductCode() {
        return this.productCode;
    }

    /**
     * Método set do atributo productCode
     *
     * @param productCode
     *            Valor para setar no atributo productCode
     */
    public void setProductCode(final Integer productCode) {
        this.productCode = productCode;
    }

    /**
     * Método get do atributo adjustmentReason
     *
     * @return O valor do atributo adjustmentReason
     */
    public final Integer getAdjustmentReason() {
        return this.adjustmentReason;
    }

    /**
     * Método set do atributo adjustmentReason
     *
     * @param adjustmentReason
     *            Valor para setar no atributo adjustmentReason
     */
    public final void setAdjustmentReason(final Integer adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }

//    /**
//     * Método get do atributo movementRelPayment
//     *
//     * @return O valor do atributo movementRelPayment
//     */
//    public final SettlementMovementRelPayment getMovementRelPayment() {
//        return this.movementRelPayment;
//    }
//
//    /**
//     * Método set do atributo movementRelPayment
//     *
//     * @param movementRelPayment
//     *            Valor para setar no atributo movementRelPayment
//     */
//    public final void setMovementRelPayment(final SettlementMovementRelPayment movementRelPayment) {
//        this.movementRelPayment = movementRelPayment;
//    }

    /**
     * Método get do atributo financialAdjustmentNumber
     *
     * @return O valor do atributo financialAdjustmentNumber
     */
    public final String getFinancialAdjustmentNumber() {
        return this.financialAdjustmentNumber;
    }

    /**
     * Método set do atributo financialAdjustmentNumber
     *
     * @param financialAdjustmentNumber
     *            Valor para setar no atributo financialAdjustmentNumber
     */
    public final void setFinancialAdjustmentNumber(final String financialAdjustmentNumber) {
        this.financialAdjustmentNumber = financialAdjustmentNumber;
    }

    /**
     * metodo get financial movement
     *
     * @return número do lançamento financeiro.
     */
    public String getFinancialMovement() {
        return this.financialMovement;
    }

    /**
     * metodo set financialMovement
     *
     * @param financialMovement
     *            número do lançamento financeiro.
     */
    public void setFinancialMovement(final String financialMovement) {
        this.financialMovement = financialMovement;
    }

//    /**
//     * metodo set financialMovement
//     *
//     * @param financialMovement
//     *            número do lançamento financeiro.
//     */
//    public ChargebackRequest getChargebackRequest() {
//        return this.chargebackRequest;
//    }
//
//    /**
//     * metodo set chargebackRequest
//     *
//     * @param chargebackRequest
//     */
//    public void setChargebackRequest(final ChargebackRequest chargebackRequest) {
//        this.chargebackRequest = chargebackRequest;
//    }
//
//    public ChargebackRequest getChargeBackReversal() {
//        return this.chargeBackReversal;
//    }
//
//    public void setChargeBackReversal(final ChargebackRequest chargeBackReversal) {
//        this.chargeBackReversal = chargeBackReversal;
//    }

    /**
     * Método get do atributo valueOrigDiscount
     *
     * @return O valor do atributo valueOrigDiscount
     */
    public BigDecimal getValueOrigDiscount() {
        return this.valueOrigDiscount;
    }

    /**
     * Método set do atributo valueOrigDiscount
     *
     * @param valueOrigDiscount
     *            Valor para setar no atributo valueOrigDiscount
     */
    public void setValueOrigDiscount(final BigDecimal valueOrigDiscount) {
        this.valueOrigDiscount = valueOrigDiscount;
    }

    /**
     * Método get do atributo valueFlexibleTerm
     *
     * @return O valor do atributo valueFlexibleTerm
     */
    public BigDecimal getValueFlexibleTerm() {
        return this.valueFlexibleTerm;
    }

    /**
     * Método set do atributo valueFlexibleTerm
     *
     * @param valueFlexibleTerm
     *            Valor para setar no atributo valueFlexibleTerm
     */
    public void setValueFlexibleTerm(final BigDecimal valueFlexibleTerm) {
        this.valueFlexibleTerm = valueFlexibleTerm;
    }

    /**
     * Método get do atributo vlGrossAvailableAmountTrans
     *
     * @return O valor do atributo vlGrossAvailableAmountTrans
     */
    public BigDecimal getVlGrossAvailableAmountTrans() {
        return this.vlGrossAvailableAmountTrans;
    }

    /**
     * Método set do atributo vlGrossAvailableAmountTrans
     *
     * @param vlGrossAvailableAmountTrans
     *            Valor para setar no atributo vlGrossAvailableAmountTrans
     */
    public void setVlGrossAvailableAmountTrans(final BigDecimal vlGrossAvailableAmountTrans) {
        this.vlGrossAvailableAmountTrans = vlGrossAvailableAmountTrans;
    }

    /**
     * Método get do atributo dtBatchTrans
     *
     * @return O valor do atributo dtBatchTrans
     */
    public Date getDtBatchTrans() {
        return this.dtBatchTrans;
    }

    /**
     * Método set do atributo dtBatchTrans
     *
     * @param dtBatchTrans
     *            Valor para setar no atributo dtBatchTrans
     */
    public void setDtBatchTrans(final Date dtBatchTrans) {
        this.dtBatchTrans = dtBatchTrans;
    }

}
