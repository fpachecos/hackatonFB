package br.com.cielo.settlement.adjustmentpaymenttype.dto;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.TreeSet;

import br.com.cielo.settlement.entity.MovementStatusEnum;
import br.com.cielo.settlement.entity.Product;

/**
 *
 * Representação do produto do domicilio bancario para determinar o produto do ajuste
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 *
 */
public class DomicilieProduct {

    private final static Comparator<FutureEntry> FUTURE_ENTRY_COMPARATOR = new Comparator<FutureEntry>() {
        @Override
        public int compare(final FutureEntry f1, final FutureEntry f2) {
            return f1.getDtSettlement().compareTo(f2.getDtSettlement());
        }
    };

    /**
     * Código do produto do domicilio
     */
    private Product product;

    /**
     * Lista ordenada por data de liquidação de forma crescente
     */
    private TreeSet<FutureEntry> futureEntries;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public TreeSet<FutureEntry> getFutureEntries() {
        return this.futureEntries;
    }

    public void add(final FutureEntry pFutureEntry) {
        if (this.futureEntries == null) {
            this.futureEntries = new TreeSet<>(FUTURE_ENTRY_COMPARATOR);
        }

        this.futureEntries.add(pFutureEntry);
    }

    /*
     * Valor futuro total
     */
    public BigDecimal getTotalNetVaue() {
        BigDecimal lTotal = BigDecimal.ZERO;

        if (this.getFutureEntries() != null && !this.getFutureEntries().isEmpty()) {
            for (FutureEntry futureEntry : this.getFutureEntries()) {
                lTotal = lTotal.add(futureEntry.getNetValue());
            }
        }

        return lTotal;
    }

    @Override
    public int hashCode() {
        if (this.getProduct() != null && this.getProduct().getCode() != null) {
            return this.getProduct().getCode().hashCode();
        } else {
            return this.hashCode();
        }
    }


    /**
     * Verifica se o produto encontra-se em debitbalance
     *
     * @return
     */
    public boolean isDebitBalance() {
        if (this.getFutureEntries() != null) {
            for (FutureEntry futureEntry : this.getFutureEntries()) {
                if (MovementStatusEnum.DEBIT_BALANCE.getCode().equals(futureEntry.getCdMovementStatus())) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean equals(final Object another) {
        if (another instanceof DomicilieProduct && this.getProduct() != null && this.getProduct().getCode() != null) {
            DomicilieProduct lDomicilieProduct = (DomicilieProduct) another;
            return this.getProduct().getCode().equals(lDomicilieProduct.getProduct().getCode());
        }

        return super.equals(another);
    }

}
