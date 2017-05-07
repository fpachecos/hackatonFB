package br.com.cielo.settlement.service;

import java.util.Date;
import java.util.List;

import br.com.cielo.settlement.entity.ContractedProduct;

/**
 * Definição de interface para serviço referentes ao Settlement
 *
 * @author waldeir
 * @version $Id: SettlementService.java 78996 2016-11-09 20:32:57Z eyve4g $
 */
public interface SettlementService {

    /**
     * Retorna Produto Contratado de acordo com regra de prioridade.
     *
     * @param contratedProducts
     *            List<ContractedProduct>
     * @param activeProduct
     *            boolean
     * @return ContractedProduct
     */
    ContractedProduct getContractedProduct(final List<ContractedProduct> contratedProducts, boolean activeProduct);
    
    /**
     * Ajusta o valor da data de Settlement para caso de transações represadas.
     *
     * @param settlementDate
     *            Date
     * @param settlementType
     *            String
     * @return Settlement Type maior que data atual.
     */
    Date adjustSettlementDate(Date settlementDate, String settlementType);
}
