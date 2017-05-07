package br.com.cielo.settlement.entity;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.common.entity.HasheableEntity;

/**
 * Classe que representa SettlementMovement - TBSETR_SETTLEMENT_MOVEMENT
 *
 * @author <a href="mailto:eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id: Sale.java 11/07/2014 - 09:27:02
 */
public class SettlementMovement extends HasheableEntity implements Cloneable {

    /**
     * Campo int STRING_SIZE
     */
    private static final int STRING_SIZE = 43;

    /**
     * Campo Date batchDate. DT_BATCH DATE
     */
    private Date batchDate;

    /**
     * Campo Integer productCode. CD_PRODUCT NUMBER(4, 0) NOT NULL
     */
    private Integer productCode;

    /**
     * Campo Integer movementTypeCode. CD_MOVEMENT_TYPE NUMBER(3)
     */
    private Integer movementTypeCode;

    /**
     * Campo Long acquirerCode. CD_ACQUIRER NUMBER(4, 0)
     */
    private Long acquirerCode;

    /**
     * Campo Long customerNumber. NU_CUSTOMER NUMBER(10, 0) NOT NULL
     */
    private Long customerNumber;

    /**
     * Campo Date settlementDate. DT_SETTLEMENT DATE
     */
    private Date settlementDate;

    /**
     * Campo BigDecimal netMovementValue. VL_MOVEMENT_NET NUMBER(15,2)
     */
    private BigDecimal netMovementValue;

    /**
     * Campo Integer movementQtNumber. QT_MOVEMENT NUMBER(9)
     */
    private Integer movementQtNumber;

    /**
     * Campo BigDecimal grossMovementValue. VL_MOVEMENT_GROSS NUMBER(15,2)
     */
    private BigDecimal grossMovementValue;

    /**
     * Campo BigDecimal dailyDiscountValueAmt. VL_DAILY_DISCOUNT_AMOUNT
     * NUMBER(15,2)
     */
    private BigDecimal dailyDiscountValueAmt;

    /**
     * Campo BigDecimal dailyIcValueAmt. VL_DAILY_IC_AMOUNT NUMBER(15,2)
     */
    private BigDecimal dailyIcValueAmt;

    /**
     * Campo Long loadFileIdNumber. NU_LOAD_FILE_ID NUMBER(20, 0)
     */
    private Long loadFileIdNumber;

    /**
     * Campo String fundingCurrencyCode. CD_FUNDING_CURRENCY VARCHAR2(3)
     */
    private String fundingCurrencyCode;

    /**
     * Campo Date settlementBaseDate. DT_SETTLEMENT_BASE
     */
    private Date settlementBaseDate;

    /**
     * Campo String debitOrCredit. IN_DEBIT_CREDIT CHAR(1)
     */
    private String debitOrCredit;

    /**
     * Campo Integer customerModNumber. NU_MOD_CUSTOMER NUMBER
     */
    private Integer customerModNumber;

    /**
     * Campo Integer entryType. CD_ENTRY_TYPE NUMBER(5)
     */
    private Integer entryType;

    /**
     * Campo Date traceSettlementBaseDate. DT_SETTLEMENT_TRACE DATE
     */
    private Date traceSettlementDate;

    /**
     * Campo Integer traceCustomerModNumber. NU_MOD_CUSTOMER_TRACE
     */
    private Integer traceCustomerModNumber;

    /**
     * Campo CardAssociation cardAssociation. CD_CARD_ASSOCIATION
     */
    private CardAssociation cardAssociation;

    /**
     * Campo String currencyCode. CD_CURRENCY_CODE NUMBER(3, 0)
     */
    private String currencyCode;

    /**
     * Campo BigDecimal mdr. VL_MDR NUMBER(15, 2)
     */
    private BigDecimal mdr;

    /**
     * Campo BigDecimal interchangeCost. VL_IC NUMBER(15, 2)
     */
    private BigDecimal interchangeCost;

    /**
     * Campo BigDecimal netTransactionValueAmt. VL_TRANSACTION_AMOUNT NUMBER(15,
     * 2) - VL_MDR NUMBER(15, 2)
     */
    private BigDecimal netTransactionValueAmt;

    /**
     * Campo Integer movementStatusCode. CD_MOVIMENT_STATUS - NUMBER(2,0).
     */
    private Integer movementStatusCode;

    /**
     * Campo Long batchOffsetEntry. NU_BATCH_OFFSET_ENTRY - NUMBER(20)
     */
    private Long batchOffsetEntry;

    /**
     * Campo Date originalSettlementDate - cont�m data original de liquida��o.
     */
    private Date originalSettlementDate;

    /**
     * Campo String numberFinancialMovement
     */
    private String traceNumberFinancialMovement;

    /**
     * Campo String installmentSequence
     */
    private Integer installmentSequence = null;

    /**
     * Campo String totalInstallement
     */
    private Integer totalInstallement = null;

    /**
     * Campo String merchantBank
     */
    private String merchantBank;

    /**
     * Campo List<TransactionMovementKey> listTransactionMovementKey
     */
//    private List<TransactionMovementKey> listTransactionMovementKey;

    /**
     * Campo SettlementMovementRelPayment movementRelPayment
     */
//    private SettlementMovementRelPayment movementRelPayment;

    /**
     * Campo SettlementMovementRelAdjustment movementRelAdjustment
     */
    private SettlementMovementRelAdjustment movementRelAdjustment;

    /**
     * Campo String productSettlementType
     */
    private String productSettlementType;

    /**
     * Campo String paymentBlockedReason
     */
    private Integer paymentBlockedReason;

    /**
     * Campo String settlementTypeIndicator.
     */
    private String settlementTypeIndicator;

    /**
     * Campo String numberFinancialMovementOrig
     */
    private String numberFinancialMovementOrig;

    /**
     * Atributo que identifica o ajuste, caso o movimento seja oriundo de um
     * ajuste
     */
    private SettlementAdjustment adjustment;

    /**
     * Valor do desconto de prazo flex (VL_FLEXIBLE_TERM) - COMPLEMENT
     */
    private BigDecimal valueFlexibleTerm;

    /**
     * Valor do desconto total (VL_DISCOUNT_AMOUNT) - COMPLEMENT
     */
    private BigDecimal valueAmountDiscount;

    /**
     * inFidc.
     */
    private String inFidc;

    /**
     * nuCompany.
     */
    private Long nuCompany;

    /**
     * nuModCompany.
     */
    private Integer nuModCompany;
    /**
     * Campo Long inSettlementType. IN_SETTLEMENT_TYPE
     */
    private String inSettlementType;

    /**
     * M�todo do tipo factory, cria instancia da classe
     *
     * @return SettlementMovement
     */
    public static SettlementMovement createSettlementMovement() {
        return new SettlementMovement();
    }

    /**
     * Verifica se o movimento esta liquidado.
     *
     * @return Esta liquidado?
     */
    public Boolean isSettled() {
        return MovementStatusEnum.SETTLEMENT_CREDIT.getCode().equals(this.movementStatusCode)
                        || MovementStatusEnum.SETTLEMENT_DEBIT.getCode().equals(this.movementStatusCode)
                        || MovementStatusEnum.SETTLEMENT_ANTICIPATION.getCode().equals(this.movementStatusCode);
    }

    /**
     * Retorna se precisa atualizar status ou n�o, utilizado no processo de
     * copia da stage para movement.
     *
     * @return Atualiza status?
     */
    public boolean updateStatusArvProcess() {
        return !MovementTypeEnum.LEAVING_RETENTION_BY_ARV_REASON.getCode().equals(this.movementTypeCode);
    }

    /**
     * M�todo get do atributo batchDate
     *
     * @return O valor do atributo batchDate
     */
    public Date getBatchDate() {
        return this.batchDate;
    }

    /**
     * M�todo set do atributo batchDate
     *
     * @param batchDate
     *            Valor para setar no atributo batchDate
     */

    public void setBatchDate(final Date batchDate) {
        this.batchDate = batchDate;
    }

    /**
     * M�todo get do atributo productCode
     *
     * @return O valor do atributo productCode
     */

    public Integer getProductCode() {
        return this.productCode;
    }

    /**
     * M�todo set do atributo productCode
     *
     * @param productCode
     *            Valor para setar no atributo productCode
     */

    public void setProductCode(final Integer productCode) {
        this.productCode = productCode;
    }

    /**
     * M�todo get do atributo movementTypeCode
     *
     * @return O valor do atributo movementTypeCode
     */

    public Integer getMovementTypeCode() {
        return this.movementTypeCode;
    }

    /**
     * M�todo set do atributo movementTypeCode
     *
     * @param movementTypeCode
     *            Valor para setar no atributo movementTypeCode
     */

    public void setMovementTypeCode(final Integer movementTypeCode) {
        this.movementTypeCode = movementTypeCode;
    }

    /**
     * M�todo get do atributo acquirerCode
     *
     * @return O valor do atributo acquirerCode
     */

    public Long getAcquirerCode() {
        return this.acquirerCode;
    }

    /**
     * M�todo set do atributo acquirerCode
     *
     * @param acquirerCode
     *            Valor para setar no atributo acquirerCode
     */

    public void setAcquirerCode(final Long acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    /**
     * M�todo get do atributo customerNumber
     *
     * @return O valor do atributo customerNumber
     */

    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    /**
     * M�todo set do atributo customerNumber
     *
     * @param customerNumber
     *            Valor para setar no atributo customerNumber
     */

    public void setCustomerNumber(final Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * M�todo get do atributo settlementDate
     *
     * @return O valor do atributo settlementDate
     */

    public Date getSettlementDate() {
        return this.settlementDate;
    }

    /**
     * M�todo set do atributo settlementDate
     *
     * @param settlementDate
     *            Valor para setar no atributo settlementDate
     */

    public void setSettlementDate(final Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * M�todo get do atributo netMovementValue
     *
     * @return O valor do atributo netMovementValue
     */

    public BigDecimal getNetMovementValue() {
        return this.netMovementValue;
    }

    /**
     * M�todo set do atributo netMovementValue
     *
     * @param netMovementValue
     *            Valor para setar no atributo netMovementValue
     */

    public void setNetMovementValue(final BigDecimal netMovementValue) {
        this.netMovementValue = netMovementValue;
    }

    /**
     * M�todo get do atributo movementQtNumber
     *
     * @return O valor do atributo movementQtNumber
     */

    public Integer getMovementQtNumber() {
        return this.movementQtNumber;
    }

    /**
     * M�todo set do atributo movementQtNumber
     *
     * @param movementQtNumber
     *            Valor para setar no atributo movementQtNumber
     */

    public void setMovementQtNumber(final Integer movementQtNumber) {
        this.movementQtNumber = movementQtNumber;
    }

    /**
     * M�todo get do atributo grossMovementValue
     *
     * @return O valor do atributo grossMovementValue
     */

    public BigDecimal getGrossMovementValue() {
        return this.grossMovementValue;
    }

    /**
     * M�todo set do atributo grossMovementValue
     *
     * @param grossMovementValue
     *            Valor para setar no atributo grossMovementValue
     */

    public void setGrossMovementValue(final BigDecimal grossMovementValue) {
        this.grossMovementValue = grossMovementValue;
    }

    /**
     * M�todo get do atributo dailyDiscountValueAmt
     *
     * @return O valor do atributo dailyDiscountValueAmt
     */

    public BigDecimal getDailyDiscountValueAmt() {
        return this.dailyDiscountValueAmt;
    }

    /**
     * M�todo set do atributo dailyDiscountValueAmt
     *
     * @param dailyDiscountValueAmt
     *            Valor para setar no atributo dailyDiscountValueAmt
     */

    public void setDailyDiscountValueAmt(final BigDecimal dailyDiscountValueAmt) {
        this.dailyDiscountValueAmt = dailyDiscountValueAmt;
    }

    /**
     * M�todo get do atributo dailyIcValueAmt
     *
     * @return O valor do atributo dailyIcValueAmt
     */

    public BigDecimal getDailyIcValueAmt() {
        return this.dailyIcValueAmt;
    }

    /**
     * M�todo set do atributo dailyIcValueAmt
     *
     * @param dailyIcValueAmt
     *            Valor para setar no atributo dailyIcValueAmt
     */

    public void setDailyIcValueAmt(final BigDecimal dailyIcValueAmt) {
        this.dailyIcValueAmt = dailyIcValueAmt;
    }

    /**
     * M�todo get do atributo loadFileIdNumber
     *
     * @return O valor do atributo loadFileIdNumber
     */

    public Long getLoadFileIdNumber() {
        return this.loadFileIdNumber;
    }

    /**
     * M�todo set do atributo loadFileIdNumber
     *
     * @param loadFileIdNumber
     *            Valor para setar no atributo loadFileIdNumber
     */

    public void setLoadFileIdNumber(final Long loadFileIdNumber) {
        this.loadFileIdNumber = loadFileIdNumber;
    }

    /**
     * M�todo get do atributo fundingCurrencyCode
     *
     * @return O valor do atributo fundingCurrencyCode
     */

    public String getFundingCurrencyCode() {
        return this.fundingCurrencyCode;
    }

    /**
     * M�todo set do atributo fundingCurrencyCode
     *
     * @param fundingCurrencyCode
     *            Valor para setar no atributo fundingCurrencyCode
     */

    public void setFundingCurrencyCode(final String fundingCurrencyCode) {
        this.fundingCurrencyCode = fundingCurrencyCode;
    }

    /**
     * M�todo get do atributo settlementBaseDate
     *
     * @return O valor do atributo settlementBaseDate
     */

    public Date getSettlementBaseDate() {
        return this.settlementBaseDate;
    }

    /**
     * M�todo set do atributo settlementBaseDate
     *
     * @param settlementBaseDate
     *            Valor para setar no atributo settlementBaseDate
     */

    public void setSettlementBaseDate(final Date settlementBaseDate) {
        this.settlementBaseDate = settlementBaseDate;
    }

    /**
     * M�todo get do atributo debitOrCredit
     *
     * @return O valor do atributo debitOrCredit
     */

    public String getDebitOrCredit() {
        return this.debitOrCredit;
    }

    /**
     * M�todo set do atributo debitOrCredit
     *
     * @param debitOrCredit
     *            Valor para setar no atributo debitOrCredit
     */

    public void setDebitOrCredit(final String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    /**
     * M�todo get do atributo customerModNumber
     *
     * @return O valor do atributo customerModNumber
     */

    public Integer getCustomerModNumber() {
        return this.customerModNumber;
    }

    /**
     * M�todo set do atributo customerModNumber
     *
     * @param customerModNumber
     *            Valor para setar no atributo customerModNumber
     */

    public void setCustomerModNumber(final Integer customerModNumber) {
        this.customerModNumber = customerModNumber;
    }

    /**
     * M�todo get do atributo entryType
     *
     * @return O valor do atributo entryType
     */

    public Integer getEntryType() {
        return this.entryType;
    }

    /**
     * M�todo set do atributo entryType
     *
     * @param entryType
     *            Valor para setar no atributo entryType
     */

    public void setEntryType(final Integer entryType) {
        this.entryType = entryType;
    }

    /**
     * M�todo get do atributo traceSettlementDate
     *
     * @return O valor do atributo traceSettlementDate
     */

    public Date getTraceSettlementDate() {
        return this.traceSettlementDate;
    }

    /**
     * M�todo set do atributo traceSettlementDate
     *
     * @param traceSettlementDate
     *            Valor para setar no atributo traceSettlementDate
     */

    public void setTraceSettlementDate(final Date traceSettlementDate) {
        this.traceSettlementDate = traceSettlementDate;
    }

    /**
     * M�todo get do atributo traceCustomerModNumber
     *
     * @return O valor do atributo traceCustomerModNumber
     */

    public Integer getTraceCustomerModNumber() {
        return this.traceCustomerModNumber;
    }

    /**
     * M�todo set do atributo traceCustomerModNumber
     *
     * @param traceCustomerModNumber
     *            Valor para setar no atributo traceCustomerModNumber
     */

    public void setTraceCustomerModNumber(final Integer traceCustomerModNumber) {
        this.traceCustomerModNumber = traceCustomerModNumber;
    }

//    /**
//     * M�todo get do atributo cardAssociation
//     *
//     * @return O valor do atributo cardAssociation
//     */
//
//    public CardAssociation getCardAssociation() {
//        return this.cardAssociation;
//    }
//
//    /**
//     * M�todo set do atributo cardAssociation
//     *
//     * @param cardAssociation
//     *            Valor para setar no atributo cardAssociation
//     */
//
//    public void setCardAssociation(final CardAssociation cardAssociation) {
//        this.cardAssociation = cardAssociation;
//    }

    /**
     * M�todo get do atributo currencyCode
     *
     * @return O valor do atributo currencyCode
     */

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * M�todo set do atributo currencyCode
     *
     * @param currencyCode
     *            Valor para setar no atributo currencyCode
     */

    public void setCurrencyCode(final String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * M�todo get do atributo mdr
     *
     * @return O valor do atributo mdr
     */

    public BigDecimal getMdr() {
        return this.mdr;
    }

    /**
     * M�todo set do atributo mdr
     *
     * @param mdr
     *            Valor para setar no atributo mdr
     */

    public void setMdr(final BigDecimal mdr) {
        this.mdr = mdr;
    }

    /**
     * M�todo get do atributo interchangeCost
     *
     * @return O valor do atributo interchangeCost
     */

    public BigDecimal getInterchangeCost() {
        return this.interchangeCost;
    }

    /**
     * M�todo set do atributo interchangeCost
     *
     * @param interchangeCost
     *            Valor para setar no atributo interchangeCost
     */

    public void setInterchangeCost(final BigDecimal interchangeCost) {
        this.interchangeCost = interchangeCost;
    }

    /**
     * M�todo get do atributo netTransactionValueAmt
     *
     * @return O valor do atributo netTransactionValueAmt
     */

    public BigDecimal getNetTransactionValueAmt() {
        return this.netTransactionValueAmt;
    }

    /**
     * M�todo set do atributo netTransactionValueAmt
     *
     * @param netTransactionValueAmt
     *            Valor para setar no atributo netTransactionValueAmt
     */

    public void setNetTransactionValueAmt(final BigDecimal netTransactionValueAmt) {
        this.netTransactionValueAmt = netTransactionValueAmt;
    }

    /**
     * M�todo get do atributo movementStatusCode
     *
     * @return O valor do atributo movementStatusCode
     */

    public Integer getMovementStatusCode() {
        return this.movementStatusCode;
    }

    /**
     * M�todo set do atributo movementStatusCode
     *
     * @param movementStatusCode
     *            Valor para setar no atributo movementStatusCode
     */

    public void setMovementStatusCode(final Integer movementStatusCode) {
        this.movementStatusCode = movementStatusCode;
    }

    /**
     * M�todo get do atributo batchOffsetEntry
     *
     * @return O valor do atributo batchOffsetEntry
     */

    public Long getBatchOffsetEntry() {
        return this.batchOffsetEntry;
    }

    /**
     * M�todo set do atributo batchOffsetEntry
     *
     * @param batchOffsetEntry
     *            Valor para setar no atributo batchOffsetEntry
     */

    public void setBatchOffsetEntry(final Long batchOffsetEntry) {
        this.batchOffsetEntry = batchOffsetEntry;
    }

    /**
     * M�todo get do atributo originalSettlementDate
     *
     * @return O valor do atributo originalSettlementDate
     */

    public Date getOriginalSettlementDate() {
        return this.originalSettlementDate;
    }

    /**
     * M�todo set do atributo originalSettlementDate
     *
     * @param originalSettlementDate
     *            Valor para setar no atributo originalSettlementDate
     */

    public void setOriginalSettlementDate(final Date originalSettlementDate) {
        this.originalSettlementDate = originalSettlementDate;
    }

    /**
     * M�todo get do atributo numberFinancialMovement
     *
     * @return String numberFinancialMovement
     */

    public String getNumberFinancialMovement() {
        return this.getHash();
    }

    /**
     * M�todo set do atributo numberFinancialMovement.
     *
     * @param numberFinancialMovement
     *            String
     */

    public void setNumberFinancialMovement(final String numberFinancialMovement) {
        this.setHash(numberFinancialMovement);
    }

    /**
     * M�todo get do atributo traceNumberFinancialMovement.
     *
     * @return traceNumberFinancialMovement
     */

    public String getTraceNumberFinancialMovement() {
        return this.traceNumberFinancialMovement;
    }

    /**
     * M�todo set do atributo traceNumberFinancialMovement.
     *
     * @param traceNumberFinancialMovement
     *            String
     */

    public void setTraceNumberFinancialMovement(final String traceNumberFinancialMovement) {
        this.traceNumberFinancialMovement = traceNumberFinancialMovement;
    }

    /**
     * M�todo get do atributo listTransactionMovementKey
     *
     * @return List<TransactionMovementKey> getListTransactionMovementKey()
     */

//    public List<TransactionMovementKey> getListTransactionMovementKey() {
//        return this.listTransactionMovementKey;
//    }

    /**
     * M�todo set do atributo listTransactionMovementKey
     *
     * @param listTransactionMovementKey
     *            List<TransactionMovementKey>
     */

//    public void setListTransactionMovementKey(final List<TransactionMovementKey> listTransactionMovementKey) {
//        this.listTransactionMovementKey = listTransactionMovementKey;
//    }

    /**
     * M�todo get do atributo movementRelPayment
     *
     * @return O valor do atributo movementRelPayment
     */

//    public final SettlementMovementRelPayment getMovementRelPayment() {
//        return this.movementRelPayment;
//    }

    /**
     * M�todo set do atributo movementRelPayment
     *
     * @param movementRelPayment
     *            Valor para setar no atributo movementRelPayment
     */

//    public final void setMovementRelPayment(final SettlementMovementRelPayment movementRelPayment) {
//        this.movementRelPayment = movementRelPayment;
//    }

    /**
     * M�todo get do atributo productSettlementType
     *
     * @return O valor do atributo productSettlementType
     */

    public String getProductSettlementType() {
        return this.productSettlementType;
    }

    /**
     * M�todo set do atributo productSettlementType
     *
     * @param productSettlementType
     *            Valor para setar no atributo productSettlementType
     */

    public void setProductSettlementType(final String productSettlementType) {
        this.productSettlementType = productSettlementType;
    }

    /**
     * M�todo get do atributo installmentSequence
     *
     * @return O valor do atributo installmentSequence
     */

    public final Integer getInstallmentSequence() {
        return this.installmentSequence;
    }

    /**
     * M�todo set do atributo installmentSequence
     *
     * @param installmentSequence
     *            Valor para setar no atributo installmentSequence
     */

    public final void setInstallmentSequence(final Integer installmentSequence) {
        this.installmentSequence = installmentSequence;
    }

    /**
     * M�todo get do atributo totalInstallement
     *
     * @return O valor do atributo totalInstallement
     */

    public final Integer getTotalInstallement() {
        return this.totalInstallement;
    }

    /**
     * M�todo set do atributo totalInstallement
     *
     * @param totalInstallement
     *            Valor para setar no atributo totalInstallement
     */

    public final void setTotalInstallement(final Integer totalInstallement) {
        this.totalInstallement = totalInstallement;
    }

    /**
     * M�todo get do atributo paymentBlockedReason
     *
     * @return O valor do atributo paymentBlockedReason
     */

    public Integer getPaymentBlockedReason() {
        return this.paymentBlockedReason;
    }

    /**
     * M�todo set do atributo paymentBlockedReason
     *
     * @param paymentBlockedReason
     *            Valor para setar no atributo paymentBlockedReason
     */

    public void setPaymentBlockedReason(final Integer paymentBlockedReason) {
        this.paymentBlockedReason = paymentBlockedReason;
    }

    /**
     * getter de settlementTypeIndicator
     *
     * @return settlementTypeIndicator indicador do tipo de cancelamento
     */

    public String getSettlementTypeIndicator() {
        return this.settlementTypeIndicator;
    }

    /**
     * setter de settlementTypeIndicator
     *
     * @param settlementTypeIndicator
     *            indicador do tipo de cancelamento
     */

    public void setSettlementTypeIndicator(final String settlementTypeIndicator) {
        this.settlementTypeIndicator = settlementTypeIndicator;
    }

    /**
     * M�todo get do atributo merchantBank
     *
     * @return O valor do atributo merchantBank
     */

    public String getMerchantBank() {
        return this.merchantBank;
    }

    /**
     * M�todo set do atributo merchantBank
     *
     * @param merchantBank
     *            Valor para setar no atributo merchantBank
     */

    public void setMerchantBank(final String merchantBank) {
        this.merchantBank = merchantBank;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(SettlementMovement.STRING_SIZE);
        builder.append("SettlementMovement [batchDate=");
        builder.append(this.batchDate);

        builder.append(", productCode=");
        builder.append(this.productCode);

        builder.append(", movementTypeCode=");
        builder.append(this.movementTypeCode);

        builder.append(", customerNumber=");
        builder.append(this.customerNumber);

        builder.append(", settlementDate=");
        builder.append(this.settlementDate);

        builder.append(", entryType=");
        builder.append(this.entryType);

//        builder.append(", cardAssociation=");
//        builder.append(this.cardAssociation);

        builder.append(", numberFinancialMovement=");
        builder.append(this.getNumberFinancialMovement());

        builder.append(", traceNumberFinancialMovement=");
        builder.append(this.traceNumberFinancialMovement);

        builder.append(", installmentSequence=");
        builder.append(this.installmentSequence);

        builder.append(", paymentBlockedReason=");
        builder.append(this.paymentBlockedReason);

        builder.append(", settlementTypeIndicator=");
        builder.append(this.settlementTypeIndicator);

        builder.append(']');

        return builder.toString();
    }

    /**
     * M�todo get do atributo numberFinancialMovementOrig
     *
     * @return O valor do atributo numberFinancialMovementOrig
     */

    public final String getNumberFinancialMovementOrig() {
        return this.numberFinancialMovementOrig;
    }

    /**
     * M�todo set do atributo numberFinancialMovementOrig
     *
     * @param numberFinancialMovementOrig
     *            Valor para setar no atributo numberFinancialMovementOrig
     */

    public final void setNumberFinancialMovementOrig(final String numberFinancialMovementOrig) {
        this.numberFinancialMovementOrig = numberFinancialMovementOrig;
    }

    /**
     * Obtem o ajuste
     *
     * @return ajuste
     */
    public SettlementAdjustment getAdjustment() {
        return this.adjustment;
    }

    /**
     * seta o ajuste
     *
     * @param adjustment
     *            ajuste
     */
    public void setAdjustment(final SettlementAdjustment adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * Gera uma c�pia identifca do objeto. Utiliza o m�todo clone do objeto.
     *
     * @return c�pia do objeto.
     * @throws CloneNotSupportedException
     *             lan�ada quando a clonagem n�o � poss�vel
     */
    public SettlementMovement getCopy() throws CloneNotSupportedException {
        return this.clone();
    }

    /**
     * M�todo get do atributo valueFlexibleTerm
     *
     * @return O valor do atributo valueFlexibleTerm
     */
    public BigDecimal getValueFlexibleTerm() {
        return this.valueFlexibleTerm;
    }

    /**
     * M�todo set do atributo valueFlexibleTerm
     *
     * @param valueFlexibleTerm
     *            Valor para setar no atributo valueFlexibleTerm
     */
    public void setValueFlexibleTerm(final BigDecimal valueFlexibleTerm) {
        this.valueFlexibleTerm = valueFlexibleTerm;
    }

    /**
     * M�todo get do atributo valueAmountDiscount
     *
     * @return O valor do atributo valueAmountDiscount
     */
    public BigDecimal getValueAmountDiscount() {
        return this.valueAmountDiscount;
    }

    /**
     * M�todo set do atributo valueAmountDiscount
     *
     * @param valueAmountDiscount
     *            Valor para setar no atributo valueAmountDiscount
     */
    public void setValueAmountDiscount(final BigDecimal valueAmountDiscount) {
        this.valueAmountDiscount = valueAmountDiscount;
    }

    /**
     * M�todo get do atributo inFidc
     *
     * @return O valor do atributo inFidc
     */
    public String getInFidc() {
        return this.inFidc;
    }

    /**
     * M�todo set do atributo inFidc
     *
     * @param inFidc
     *            Valor para setar no atributo inFidc
     */
    public void setInFidc(final String inFidc) {
        this.inFidc = inFidc;
    }

    /**
     * M�todo get do atributo nuCompany
     *
     * @return O valor do atributo nuCompany
     */
    public Long getNuCompany() {
        return this.nuCompany;
    }

    /**
     * M�todo set do atributo nuCompany
     *
     * @param nuCompany
     *            Valor para setar no atributo nuCompany
     */
    public void setNuCompany(final Long nuCompany) {
        this.nuCompany = nuCompany;
    }

    /**
     * M�todo get do atributo nuModCompany
     *
     * @return O valor do atributo nuModCompany
     */
    public Integer getNuModCompany() {
        return this.nuModCompany;
    }

    /**
     * M�todo set do atributo nuModCompany
     *
     * @param nuModCompany
     *            Valor para setar no atributo nuModCompany
     */
    public void setNuModCompany(final Integer nuModCompany) {
        this.nuModCompany = nuModCompany;
    }
    @Override
    public SettlementMovement clone() {
        SettlementMovement settlementMovement = null;
        try {
            settlementMovement = (SettlementMovement) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return settlementMovement;
    }

    /**
     * M�todo get do atributo inSettlementType
     *
     * @return O valor do atributo inSettlementType
     */
    public String getInSettlementType() {
        return this.inSettlementType;
    }

    /**
     * M�todo set do atributo inSettlementType
     *
     * @param inSettlementType
     *            Valor para setar no atributo inSettlementType
     */
    public void setInSettlementType(final String inSettlementType) {
        this.inSettlementType = inSettlementType;
    }
    /**
     * M�todo get do atributo cardAssociation
     *
     * @return O valor do atributo cardAssociation
     */

    public CardAssociation getCardAssociation() {
        return this.cardAssociation;
    }

    /**
     * M�todo set do atributo cardAssociation
     *
     * @param cardAssociation
     *            Valor para setar no atributo cardAssociation
     */

    public void setCardAssociation(final CardAssociation cardAssociation) {
        this.cardAssociation = cardAssociation;
    }

	public SettlementMovementRelAdjustment getMovementRelAdjustment() {
		return movementRelAdjustment;
	}

	public void setMovementRelAdjustment(SettlementMovementRelAdjustment movementRelAdjustment) {
		this.movementRelAdjustment = movementRelAdjustment;
	}
}
