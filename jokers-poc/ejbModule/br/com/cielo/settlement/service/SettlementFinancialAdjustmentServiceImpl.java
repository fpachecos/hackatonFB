/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.settlement.adjustmentpaymenttype.filter.AdjustPaymentTypeFilter.AdjustPaymentTypeFilterBuilder;
import br.com.cielo.settlement.adjustmentpaymenttype.service.AdjustPaymentTypeService;
import br.com.cielo.settlement.batch.repository.SettlementAdjustmentRepository;
import br.com.cielo.settlement.entity.ContractedProduct;
import br.com.cielo.settlement.entity.EntryType;
import br.com.cielo.settlement.entity.FinanceAdjustmentStatusEnum;
import br.com.cielo.settlement.entity.HashFieldsBuilder;
import br.com.cielo.settlement.entity.MovementTypeEnum;
import br.com.cielo.settlement.entity.Product;
import br.com.cielo.settlement.entity.SettlementAdjustment;
import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.entity.SettlementMovement;
import br.com.cielo.settlement.entity.SettlementTypeEnum;
import br.com.cielo.settlement.repository.SettlementFinancialAdjustmentRepository;
import br.com.cielo.settlement.repository.SettlementMovementRepository;
import br.com.cielo.settlement.validation.validator.SettlementValidations;

/**
 * Implementeção do serviços, ajustes financeiros
 *
 * @author <a>Carlos Matsuo</a>
 * @version $Id: SettlementFinancialAdjustmentServiceImpl.java 68060 2016-07-12
 *          14:56:16Z roanbr $
 */
@Stateless
public class SettlementFinancialAdjustmentServiceImpl implements SettlementFinancialAdjustmentService {

/**
     * Valor de inSettlement
     */
    private static final String IN_SETTLEMENT = "y";
    
    /**
     * Codigo Cielo
     */
    private static final Long ACQUIRER_CODE = 8008L;
    
    /**
     * NÃ£o existe uma parcela de referencia.
     */
    private static final int NON_INSTALLMENT_SEQUENCE_NUMBER = 1;
    
    /**
     * Acesso aos serviços de settlement
     */
    @EJB
    private transient SettlementService settlementService;
    
    @EJB
    private SettlementAdjustmentRepository settlementAdjustmentRepository;
    
    @EJB
    private SettlementFinancialAdjustmentRepository settlementFinancialAdjustmentRepository; 
    
    @EJB
    private transient SettlementMovementRepository settlementMovementRepository;
    
    @EJB
    private AdjustPaymentTypeService adjustPaymentTypeService;
    
    @EJB
    private HashService hashService;
    
    @EJB
    private transient SettlementValidations validation;
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cielo.settlement.batch.service.
	 * SettlementFinancialAdjustmentService
	 * #generateAdjustment(br.com.cielo.settlement
	 * .batch.entity.SettlementFinancialAdjustment)
	 */
	@Override
	public SettlementFinancialAdjustment generateAdjustment(final SettlementFinancialAdjustment financialAdjustment) throws BusinessException {
		final ContractedProduct priorityProduc = new ContractedProduct();
		
		financialAdjustment.setInSettlementType(SettlementTypeEnum.CREDIT);

		Integer currencyCode = 986;

		return this.createAdjustmentByFinancialAdjustment(financialAdjustment, priorityProduc, currencyCode);
	}

	private SettlementFinancialAdjustment createAdjustmentByFinancialAdjustment(
			final SettlementFinancialAdjustment financialAdjustment, final ContractedProduct priorityProduct,
			final Integer codCurrency) throws BusinessException {

		final SettlementAdjustment adjustment = new SettlementAdjustment();

		// DT_BATCH
		adjustment.setBatchDate(new Date());
		// NU_MOD_CUSTOMER NU_MOD_CUSTOMER
		adjustment.setCustomerModNumber(financialAdjustment.getNuModCustomer());
		// NU_CUSTOMER NU_CUSTOMER
		adjustment.setCustomerNumber(financialAdjustment.getNuCustomer());
		// NU_BATCH NU_BATCH
		adjustment.setBatchNumber(financialAdjustment.getNuBatch());
		// CD_ENTRY_TYPE 20005
		if (financialAdjustment.getEntryType() == null
				|| new BigDecimal(0).equals(financialAdjustment.getEntryType())) {
			adjustment.setEntryType(EntryType.GENERIC_ADJUSTMENT);
		} else {
			adjustment.setEntryType(new EntryType(financialAdjustment.getEntryType(), null));
		}
		// NU_INSTALLMENT_SEQ_ORIGINAL Zero
		adjustment.setInstallmentSequenceOrig(0);
		// CD_MOVEMENT_TYPE CD_MOVEMENT_TYPE
		adjustment.setMovementTypeCode(financialAdjustment.getCdMovementType());
		// NU_NSU_REFUND Nulo
		adjustment.setRefundNsu(null);
		// NU_TRANSACTION_ID_ORIGINAL Nulo
		adjustment.setOrigialTransactionId(null);
		// DH_ADJUSTMENT Data e hora de geraÃ§Ã£o do ajuste
		adjustment.setAdjustmentDate(new Date());
		// IN_SETTLEMENT â€œyâ€�
		adjustment.setInSettlement(IN_SETTLEMENT);
		// NU_REQUEST NU_REQUEST
		adjustment.setRequestNumber(financialAdjustment.getNuRequest());
		// NU_LOAD_FILE_ID NU_LOAD_FILE_ID da TBSETR_FINANCE_ADJUSTMENT_REQ
		adjustment.setLoadFileIdNumber(financialAdjustment.getNuLoadFileId());
		// NU_TERMINAL Nulo
		adjustment.setTerminalNumber(null);
		// CD_ACQUIRER 8008 fixo
		adjustment.setAcquirerCode(ACQUIRER_CODE);
		// NU_REQUEST NU_REQUEST
		adjustment.setRequestNumber(financialAdjustment.getNuRequest());
		// DH_REQUEST DH_REQUEST
		adjustment.setRequestDate(financialAdjustment.getDhRequest());
		// CD_TECHNOLOGY_TYPE CD_TECHNOLOGY_TYPE
		adjustment.setTechnologyType(financialAdjustment.getCdTechnologyType());
		// VL_IC_ADJUSTMENT Zero
		adjustment.setAdjustmentIcValue(BigDecimal.ZERO);
		// CD_REQUEST_TYPE
		adjustment.setRequestType(financialAdjustment.getRequestType());
		// CD_ADJUSTMENT_REASON
		adjustment.setAdjustmentReason(financialAdjustment.getCdAdjustentReason());

		// VL_DISCOUNT_ORIG
		adjustment.setValueFlexibleTerm(BigDecimal.ZERO);
		// VL_FLEXIBLE_TERM
		adjustment.setValueOrigDiscount(BigDecimal.ZERO);

		// CD_PRODUCT
		if (financialAdjustment.getCdProduct() == null || financialAdjustment.getCdProduct() == 0) {

			AdjustPaymentTypeFilterBuilder filterBuilder = new AdjustPaymentTypeFilterBuilder();
			filterBuilder.nuCustomer(financialAdjustment.getNuCustomer())
					.dtSettlement(financialAdjustment.getDtSettlementAdjustment())
					.adjustValue(financialAdjustment.getVlGross())
					.movementType(financialAdjustment.getCdMovementType());

			Product lSelectedProduct = this.adjustPaymentTypeService.getAdjustmentProduct(filterBuilder.build());

			SettlementTypeEnum lSettlementType = null;
			if (lSelectedProduct != null) {
				adjustment.setProductCode(lSelectedProduct.getCode());
				lSettlementType = lSelectedProduct.getSettlementType();

			} else {
				if (priorityProduct != null) {// ContractedProduct esta vindo
												// nulo algumas vezes pela view
					lSettlementType = priorityProduct.getSettlementTypeIndicator();
				}
			}

			financialAdjustment.setInSettlementType(lSettlementType);

		} else {
			adjustment.setProductCode(financialAdjustment.getCdProduct());
		}

		// DT_SETTLEMENT_ADJUSTMENT DT_SETTLEMENT_ADJUSTMENT
		validateAdjustmentDate(financialAdjustment);
		adjustment.setSettlementAdjstmentDate(financialAdjustment.getDtSettlementAdjustment());

		validateAdjustmentValue(financialAdjustment, adjustment);

		if (adjustment.getProductCode() != null) {
			adjustment
					.setFinancialMovement(
							this.hashService
									.generateHashSHA1(
											adjustment.getRequestNumber()
													+ this.hashService
															.generateGroupingKey(new HashFieldsBuilder()
																	.settlementDate(
																			adjustment.getSettlementAdjstmentDate())
																	.batchDate(adjustment.getBatchDate())
																	.loadFileId(String.valueOf(
																			financialAdjustment.getNuLoadFileId()))
																	.customerNumber(adjustment.getCustomerNumber())
																	.customerModNumber(
																			adjustment.getCustomerModNumber())
																	.installmentSegment(0)
																	.productCode(adjustment.getProductCode())
																	.movementType(
																			adjustment.getMovementTypeCode().getCode())
																	.fundingCurrency(codCurrency)
																	.installmentSequenceNumber(
																			NON_INSTALLMENT_SEQUENCE_NUMBER)
																	.build())));

			financialAdjustment.setCdStatusRequest(FinanceAdjustmentStatusEnum.EFFECTED);
			financialAdjustment.setInsert(Boolean.TRUE);
		} else {
			financialAdjustment.setCdStatusRequest(FinanceAdjustmentStatusEnum.REJECTED);
		}

		financialAdjustment.setAdjustment(adjustment);
		
		settlementAdjustmentRepository.createAdjustment(financialAdjustment);
		
		settlementFinancialAdjustmentRepository.insertFinanceAdjustmentHistory(financialAdjustment);

		return financialAdjustment;

	}
	
    /**
     * Valida a data do Ajuste
     *
     * @param financialAdjustment
     *            SettlementFinancialAdjustment
     * @param dateService
     *            DateService
     * @param movementDate
     *            movementDate
     */
    private void validateAdjustmentDate(final SettlementFinancialAdjustment financialAdjustment) {

        final String settlementType = financialAdjustment.getInSettlementType().getCode();

        Date settlementDate = this.settlementService.adjustSettlementDate(
                        financialAdjustment.getDtSettlementAdjustment(), settlementType);
        financialAdjustment.setDtSettlementAdjustment(settlementDate);

    }
    
    /**
     * Tratamento para o valor do Ajuste.
     *
     * @param financialAdjustment
     *            SettlementFinancialAdjustment
     * @param adjustment
     *            SettlementAdjustment
     */
    private void validateAdjustmentValue(final SettlementFinancialAdjustment financialAdjustment,
                    final SettlementAdjustment adjustment) {

        BigDecimal value = null;
        if (MovementTypeEnum.DEBIT_ADJUST.equals(financialAdjustment.getCdMovementType())) {
            value = financialAdjustment.getVlGross().abs().negate();
        } else if (MovementTypeEnum.CREDIT_ADJUST.equals(financialAdjustment.getCdMovementType())) {
            value = financialAdjustment.getVlGross().abs();
        } else if (MovementTypeEnum.CHARGING.equals(financialAdjustment.getCdMovementType())) {
            value = financialAdjustment.getVlGross().abs().negate();
        }

        // VL_ADJUSTMENT_AMOUNT VL_GROSS
        adjustment.setAdjustmentAmountValue(value);

        // VL_NET_AMOUNT
        adjustment.setNetAmountValue(adjustment.getAdjustmentAmountValue());

        // VL_DISCOUNT_AMOUNT Zero
        adjustment.setDiscountAmountValue(BigDecimal.ZERO);

    }
    
    @Override
    public SettlementMovement generateMovement(final SettlementAdjustment adjustment) throws BusinessException {
        Integer currencyCode = this.settlementService.getCodCurrencyByCustomerNumber(adjustment.getCustomerNumber()
                        .toString());
        final SettlementMovement movement = this.validation.createMovementByAdjustment(adjustment, currencyCode);
        this.settlementMovementRepository.setCardAssociationAndPrincipalToMovement(movement);

        return movement;
    }
}
