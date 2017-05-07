package br.com.cielo.settlement.entity;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cielo.common.entity.HasheableEntity;

/**
 * Classe que representa SettlementMovement - TBSETR_SETTLEMENT_MOVEMENT_COMPANY
 *
 * @author <a href="mailto:eyve4g@prestadorcbmp.com.br">Jean Felipe Silva</a>
 * @version $Id: Sale.java 04/11/2016
 */
public class SettlementMovementCompany extends HasheableEntity implements Cloneable {

    /**
     * Campo String nuFinancialMovementCompany. NU_FINANCIAL_MOVEMENT_COMPANY
     * VARCHAR(40) Numero que identifica o movimento financeiro.
     *
     * Este Numero é um Hash, obtido a partir do agrupamento das seguintes
     * colunas: (DT_SETTLEMENT, CD_PRODUCT, DT_BATCH, NU_LOAD_FILE_ID,
     * NU_CUSTOMER, NU_MOD_CUSTOMER, NU_INSTALLMENT_SEGMENT , CD_MOVEMENT_TYPE,
     * CD_CURRENCY_CODE
     */
    private String nuFinancialMovementCompany;

    /**
     * Campo Date dtSettlement. Date & Time. Data de Liquidação da Transação.
     */
    private Date dtSettlement;

    /**
     * Campo Integer nuModCompany. NUMBER(2). Numero de identificação da empresa
     * parceira
     */
    private Integer nuModCompany;

    /**
     * Campo Date dtBatch. Date & Time.Data do Lote em que foi capturada a
     * Transação em Base II.
     */
    private Date dtBatch;

    /**
     * Campo Integer cdProduct.Number (4)."Código que identifica um Produto da
     * Cielo. Nota: A análise técnica detalhada está em andamento para
     * determinar a lista completa e descrição / fonte da lista."
     */
    private Integer cdProduct;

    /**
     * Campo Integer cdMovementType.Number (3).Código do Tipo de Movimento.
     */
    private Integer cdMovementType;

    /**
     * Long nuCompany.Number (10).Numero único que identifica o Parceiro Cielo
     * no Cadastro da empresa.
     */

    private Long nuCompany;

    /**
     * Campo BigDecimal vlMovementNet.Number (17,2).Valor Líquido daquele
     * Movimento
     */
    private BigDecimal vlMovementNet;

    /**
     * Campo BigDecimal vlMovementGross.Number (17,2). Valor Bruto daquele
     * Movimento.
     */
    private BigDecimal vlMovementGross;

    /**
     * Campo Integer cdMovementStatus. Number (2). Codigo que identifica a
     * situacao atual de um movimento (registro) desta tabela.
     */
    private Integer cdMovementStatus;

    /**
     * Campo cdFundingCurrency. Variable characters (3).Moeda que será utilizada
     * para liquidar a transação junto ao Estabelecimento Comercial
     */
    private String cdFundingCurrency;

    /**
     * Campo Integer nuLoadFileId. Number (20).Número Identificador dado ao
     * Arquivo de Base I importado na tabela Captured Transaction.
     */

    private Long nuLoadFileId;

    /**
     * Campo nuFinancialMovement. Characters (40).Numero que identifica o
     * movimento financeiro.
     */
    private String nuFinancialMovement;

    /**
     * Campo Integer nuModMovementCustomer. Number (2) .Número do cálculo do mod
     * do Cliente utilizado como chave e definir a subpartição.
     */
    private Integer nuModMovementCustomer;

    /**
     * Campo Integer nuCustomer. Number (10) .Número único que identifica um
     * Cliente no cadastro de cliente da emrpesa, que é reconhecido por todos os
     * sistemas de informação que manipulam informações dos Clientes.
     */

    private Long nuCustomer;

    /**
     * Campo Date dhRecordCreation. Date & Time .Data e hora de Criação do
     * Registro.
     */
    private Date dhRecordCreation;

    /**
     * Campo String nmLoginUserCreation.Variable characters (50).Nome do Login
     * do Usuário que realizou a Criação do Registro.
     */
    private String nmLoginUserCreation;

    /**
     * Campo Date dhRecordLastModified. Date & Time. Data e hora da Última
     * Atualização do Registro.
     */
    private Date dhRecordLastModified;

    private String nmLoginUserLastModified;

    /**
     * Método get do atributo nuFinancialMovementCompany
     *
     * @return O valor do atributo nuFinancialMovementCompany
     */
    public String getNuFinancialMovementCompany() {
        return this.nuFinancialMovementCompany;
    }

    /**
     * Método set do atributo nuFinancialMovementCompany
     *
     * @param nuFinancialMovementCompany
     *            Valor para setar no atributo nuFinancialMovementCompany
     */
    public void setNuFinancialMovementCompany(final String nuFinancialMovementCompany) {
        this.nuFinancialMovementCompany = nuFinancialMovementCompany;
    }

    /**
     * Método get do atributo dtSettlement
     *
     * @return O valor do atributo dtSettlement
     */
    public Date getDtSettlement() {
        return this.dtSettlement;
    }

    /**
     * Método set do atributo dtSettlement
     *
     * @param dtSettlement
     *            Valor para setar no atributo dtSettlement
     */
    public void setDtSettlement(final Date dtSettlement) {
        this.dtSettlement = dtSettlement;
    }

    /**
     * Método get do atributo nuModCompany
     *
     * @return O valor do atributo nuModCompany
     */
    public Integer getNuModCompany() {
        return this.nuModCompany;
    }

    /**
     * Método set do atributo nuModCompany
     *
     * @param nuModCompany
     *            Valor para setar no atributo nuModCompany
     */
    public void setNuModCompany(final Integer nuModCompany) {
        this.nuModCompany = nuModCompany;
    }

    /**
     * Método get do atributo dtBatch
     *
     * @return O valor do atributo dtBatch
     */
    public Date getDtBatch() {
        return this.dtBatch;
    }

    /**
     * Método set do atributo dtBatch
     *
     * @param dtBatch
     *            Valor para setar no atributo dtBatch
     */
    public void setDtBatch(final Date dtBatch) {
        this.dtBatch = dtBatch;
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
     * Método get do atributo cdMovementType
     *
     * @return O valor do atributo cdMovementType
     */
    public Integer getCdMovementType() {
        return this.cdMovementType;
    }

    /**
     * Método set do atributo cdMovementType
     *
     * @param cdMovementType
     *            Valor para setar no atributo cdMovementType
     */
    public void setCdMovementType(final Integer cdMovementType) {
        this.cdMovementType = cdMovementType;
    }

    /**
     * Método get do atributo vlMovementNet
     *
     * @return O valor do atributo vlMovementNet
     */
    public BigDecimal getVlMovementNet() {
        return this.vlMovementNet;
    }

    /**
     * Método set do atributo vlMovementNet
     *
     * @param vlMovementNet
     *            Valor para setar no atributo vlMovementNet
     */
    public void setVlMovementNet(final BigDecimal vlMovementNet) {
        this.vlMovementNet = vlMovementNet;
    }

    /**
     * Método get do atributo vlMovementGross
     *
     * @return O valor do atributo vlMovementGross
     */
    public BigDecimal getVlMovementGross() {
        return this.vlMovementGross;
    }

    /**
     * Método set do atributo vlMovementGross
     *
     * @param vlMovementGross
     *            Valor para setar no atributo vlMovementGross
     */
    public void setVlMovementGross(final BigDecimal vlMovementGross) {
        this.vlMovementGross = vlMovementGross;
    }

    /**
     * Método get do atributo cdMovementStatus
     *
     * @return O valor do atributo cdMovementStatus
     */
    public Integer getCdMovementStatus() {
        return this.cdMovementStatus;
    }

    /**
     * Método set do atributo cdMovementStatus
     *
     * @param cdMovementStatus
     *            Valor para setar no atributo cdMovementStatus
     */
    public void setCdMovementStatus(final Integer cdMovementStatus) {
        this.cdMovementStatus = cdMovementStatus;
    }

    /**
     * Método get do atributo cdFundingCurrency
     *
     * @return O valor do atributo cdFundingCurrency
     */
    public String getCdFundingCurrency() {
        return this.cdFundingCurrency;
    }

    /**
     * Método set do atributo cdFundingCurrency
     *
     * @param cdFundingCurrency
     *            Valor para setar no atributo cdFundingCurrency
     */
    public void setCdFundingCurrency(final String cdFundingCurrency) {
        this.cdFundingCurrency = cdFundingCurrency;
    }

    /**
     * Método get do atributo nuFinancialMovement
     *
     * @return O valor do atributo nuFinancialMovement
     */
    public String getNuFinancialMovement() {
        return this.nuFinancialMovement;
    }

    /**
     * Método set do atributo nuFinancialMovement
     *
     * @param nuFinancialMovement
     *            Valor para setar no atributo nuFinancialMovement
     */
    public void setNuFinancialMovement(final String nuFinancialMovement) {
        this.nuFinancialMovement = nuFinancialMovement;
    }

    /**
     * Método get do atributo nuModMovementCustomer
     *
     * @return O valor do atributo nuModMovementCustomer
     */
    public Integer getNuModMovementCustomer() {
        return this.nuModMovementCustomer;
    }

    /**
     * Método set do atributo nuModMovementCustomer
     *
     * @param nuModMovementCustomer
     *            Valor para setar no atributo nuModMovementCustomer
     */
    public void setNuModMovementCustomer(final Integer nuModMovementCustomer) {
        this.nuModMovementCustomer = nuModMovementCustomer;
    }

    /**
     * Método get do atributo dhRecordCreation
     *
     * @return O valor do atributo dhRecordCreation
     */
    public Date getDhRecordCreation() {
        return this.dhRecordCreation;
    }

    /**
     * Método set do atributo dhRecordCreation
     *
     * @param dhRecordCreation
     *            Valor para setar no atributo dhRecordCreation
     */
    public void setDhRecordCreation(final Date dhRecordCreation) {
        this.dhRecordCreation = dhRecordCreation;
    }

    /**
     * Método get do atributo nmLoginUserCreation
     *
     * @return O valor do atributo nmLoginUserCreation
     */
    public String getNmLoginUserCreation() {
        return this.nmLoginUserCreation;
    }

    /**
     * Método set do atributo nmLoginUserCreation
     *
     * @param nmLoginUserCreation
     *            Valor para setar no atributo nmLoginUserCreation
     */
    public void setNmLoginUserCreation(final String nmLoginUserCreation) {
        this.nmLoginUserCreation = nmLoginUserCreation;
    }

    /**
     * Método get do atributo dhRecordLastModified
     *
     * @return O valor do atributo dhRecordLastModified
     */
    public Date getDhRecordLastModified() {
        return this.dhRecordLastModified;
    }

    /**
     * Método set do atributo dhRecordLastModified
     *
     * @param dhRecordLastModified
     *            Valor para setar no atributo dhRecordLastModified
     */
    public void setDhRecordLastModified(final Date dhRecordLastModified) {
        this.dhRecordLastModified = dhRecordLastModified;
    }

    /**
     * Método get do atributo nuCompany
     *
     * @return O valor do atributo nuCompany
     */
    public Long getNuCompany() {
        return this.nuCompany;
    }

    /**
     * Método set do atributo nuCompany
     *
     * @param nuCompany
     *            Valor para setar no atributo nuCompany
     */
    public void setNuCompany(final Long nuCompany) {
        this.nuCompany = nuCompany;
    }

    /**
     * Método get do atributo nuCustomer
     *
     * @return O valor do atributo nuCustomer
     */
    public Long getNuCustomer() {
        return this.nuCustomer;
    }

    /**
     * Método set do atributo nuCustomer
     *
     * @param nuCustomer
     *            Valor para setar no atributo nuCustomer
     */
    public void setNuCustomer(final Long nuCustomer) {
        this.nuCustomer = nuCustomer;
    }

    /**
     * Método get do atributo nuLoadFileId
     *
     * @return O valor do atributo nuLoadFileId
     */
    public Long getNuLoadFileId() {
        return this.nuLoadFileId;
    }

    /**
     * Método set do atributo nuLoadFileId
     *
     * @param nuLoadFileId
     *            Valor para setar no atributo nuLoadFileId
     */
    public void setNuLoadFileId(final Long nuLoadFileId) {
        this.nuLoadFileId = nuLoadFileId;
    }

    /**
     * Método get do atributo nmLoginUserLastModified
     *
     * @return O valor do atributo nmLoginUserLastModified
     */
    public String getNmLoginUserLastModified() {
        return this.nmLoginUserLastModified;
    }

    /**
     * Método set do atributo nmLoginUserLastModified
     *
     * @param nmLoginUserLastModified
     *            Valor para setar no atributo nmLoginUserLastModified
     */
    public void setNmLoginUserLastModified(final String nmLoginUserLastModified) {
        this.nmLoginUserLastModified = nmLoginUserLastModified;
    }

}
