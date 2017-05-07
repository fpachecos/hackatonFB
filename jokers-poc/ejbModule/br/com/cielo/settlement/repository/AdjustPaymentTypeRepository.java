package br.com.cielo.settlement.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;

import br.com.cielo.settlement.adjustmentpaymenttype.dto.DomicileBankAdjust;
import br.com.cielo.settlement.adjustmentpaymenttype.dto.DomicileBankAdjustProduct;
import br.com.cielo.settlement.adjustmentpaymenttype.dto.FutureEntry;
import br.com.cielo.settlement.adjustmentpaymenttype.filter.AdjustPaymentTypeFilter;
import br.com.cielo.settlement.entity.Product;

@Stateless
public class AdjustPaymentTypeRepository {
	public DomicileBankAdjustProduct getResultDTO(AdjustPaymentTypeFilter adjustPaymentTypeFilter) {
		//TODO MOCK
		DomicileBankAdjustProduct dom = new DomicileBankAdjustProduct();
		Set<DomicileBankAdjust> set = new HashSet<DomicileBankAdjust>();
		DomicileBankAdjust domicileBankAdjust = new DomicileBankAdjust();
		domicileBankAdjust.setCdDomicileBank(341L);
		domicileBankAdjust.setValueDomicilie(new BigDecimal(120));
		FutureEntry pFutureEntry = new FutureEntry(new Product(40), new Date(), new BigDecimal(120) , 0);
		domicileBankAdjust.add(pFutureEntry);
		set.add(domicileBankAdjust);
		dom.setDomicilies(set);
		return dom;
	}

	public Product findDebitProductWithMoreSaleInThirtyDays(final Long pNuCustomer) {
		final Product lProduct = new Product(40);
		return lProduct;
	}
}
