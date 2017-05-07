package br.com.cielo.settlement.batch.repository;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;

/**
 * Repositório de Adjustement
 *
 * @author <a href="mailto?eyvd6c@prestadorcbmp.com.br">Jonas Almeida Cezar</a>
 * @version $Id? SettlementAdjustmentRepository.java 22/07/2014 - 15?13?07
 */
public interface SettlementAdjustmentRepository {

	public static String INSERT = "INSERT INTO tbsetr_adjustment ( " + " nu_financial_adjustment, " + " dt_batch, "
			+ " nu_mod_customer, " + " cd_entry_type, " + " nu_batch, " + " cd_movement_type, " + " nu_nsu_refund, "
			+ " nu_transaction_id_original, " + " nu_customer, " + " vl_adjustment_amount, " + " vl_net_amount, "
			+ " vl_discount_amount, " + " dh_adjustment, " + " dt_settlement_adjustment, " + " in_settlement, "
			+ " nu_request, " + " dh_request, " + " cd_request_type, " + " nu_load_file_id, " + " nu_terminal, "
			+ " cd_product, " + " cd_acquirer, " + " cd_adjustment_reason, " + " cd_technology_type, "
			+ " vl_ic_adjustment, " + " nu_installment_seq_original, " + " nu_financial_movement, "
			+ " vl_discount_orig, " + " vl_flexible_term, " + " vl_issuer_rate_base, " + " vl_rate_incremental "
			+ " ) VALUES ( " + " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, " + " ?,"
			+ " ?, " + " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, "
			+ " ?, " + " ?, " + " ?, " + " ?"
			+ " )";

	/**
	 *
	 * Insere ajuste do ajuste financeiro
	 *
	 * @return UpdateCommand<SettlementFinancialAdjustment>
	 */
	void createAdjustment(SettlementFinancialAdjustment financialAdjustment);

}
