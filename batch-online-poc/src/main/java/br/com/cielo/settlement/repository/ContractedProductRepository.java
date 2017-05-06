package br.com.cielo.settlement.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.cielo.settlement.entity.ContractedProduct;

@Stateless
public class ContractedProductRepository {
	public List<ContractedProduct> getContractedProductsForMerchant(Long nuCustomer){
		//TODO MOCK
		ContractedProduct contractedProduct = new ContractedProduct();
		List<ContractedProduct> list = new ArrayList<ContractedProduct>();
		list.add(contractedProduct);
		return list;
	}
}
