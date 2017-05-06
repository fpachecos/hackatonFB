package br.com.cielo.settlement.adjustmentpaymenttype.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.cielo.settlement.entity.Product;

public class DomicileBankAdjust {

    public enum Order {
        ASC, DESC;
    }

    /**
     * Código do domicilio bancario
     */
    private Long cdDomicileBank;

    private BigDecimal valueDomicilie;
    
    /**
     * Lista de produtos do domicilio
     */
    private List<DomicilieProduct> products;

    /**
     * Método get do atributo cdDomicileBank
     *
     * @return O valor do atributo cdDomicileBank
     */
    public Long getCdDomicileBank() {
        return this.cdDomicileBank;
    }

    /**
     * Método set do atributo cdDomicileBank
     *
     * @param cdDomicileBank
     *            Valor para setar no atributo cdDomicileBank
     */
    public void setCdDomicileBank(final Long cdDomicileBank) {
        this.cdDomicileBank = cdDomicileBank;
    }

    public BigDecimal getValueDomicilie() {
        return this.valueDomicilie;
    }

    public void setValueDomicilie(final BigDecimal valueDomicilie) {
        this.valueDomicilie = valueDomicilie;
    }
    
    public List<DomicilieProduct> getProducts() {
    	//TODO MOCK
    	this.products = new ArrayList<DomicilieProduct>();
    	DomicilieProduct domicilieProduct = new DomicilieProduct();
    	domicilieProduct.setProduct(new Product(40));
    	this.products.add(domicilieProduct);
        return this.products;
    }

    @Override
    public int hashCode() {
        if (this.getCdDomicileBank() != null) {
            return this.getCdDomicileBank().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj instanceof DomicileBankAdjust && this.getCdDomicileBank() != null) {
            return this.getCdDomicileBank().equals(((DomicileBankAdjust) obj).getCdDomicileBank());
        }
        return super.equals(obj);
    }
    
    public List<DomicilieProduct> getProductsForAdjustment(final BigDecimal adjustValue) {
        boolean isCreditAdjust = adjustValue.compareTo(BigDecimal.ZERO) >= 0;

        // Order lOrder = isCreditAdjust ? Order.DESC : Order.ASC;
        // List<DomicilieProduct> domicilies = this.getProductsOrderBy(lOrder);

        List<DomicilieProduct> positiveProducts = new ArrayList<>();
        List<DomicilieProduct> negativeProducts = new ArrayList<>();
        if(this.getProducts() != null) {
	        for (DomicilieProduct currentProduct : this.getProducts()) {
	
	            if (currentProduct.getTotalNetVaue().compareTo(BigDecimal.ZERO) >= 0) {
	                positiveProducts.add(currentProduct);
	            } else {
	                negativeProducts.add(currentProduct);
	            }
	
	        }
        }

        List<DomicilieProduct> lReturn = null;
        if (isCreditAdjust) {

            if (!negativeProducts.isEmpty()) {
                lReturn = negativeProducts;
            } else {
                lReturn = positiveProducts;
            }

        } else {
            if (!positiveProducts.isEmpty()) {
                lReturn = positiveProducts;
            } else {
                lReturn = negativeProducts;
            }
        }

        return lReturn;

    }
    
    /**
     * Método set do atributo products
     *
     * @param products
     *            Valor para setar no atributo products
     */
    public void setProducts(final List<DomicilieProduct> products) {
        this.products = products;
    }

    public void add(final FutureEntry pFutureEntry) {
        DomicilieProduct lDomicilieProduct = new DomicilieProduct();
        lDomicilieProduct.setProduct(pFutureEntry.getProduct());

        if (this.getProducts() == null) {
            this.setProducts(new ArrayList<DomicilieProduct>());
            this.getProducts().add(lDomicilieProduct);
        } else {
            int lIndex = this.getProducts().indexOf(lDomicilieProduct);
            if (lIndex != -1) {
                lDomicilieProduct = this.getProducts().get(lIndex);
            } else {
                this.getProducts().add(lDomicilieProduct);
            }
        }

        lDomicilieProduct.add(pFutureEntry);
    }

}
