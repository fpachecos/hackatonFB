
package br.com.cielo.settlement.financialadjustment;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.processor.FinancialAdjustmentProcessor;

/**
 * Classe responsável por receber mensagem da fila de ajuste financeiro
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "settlementFinancialAdjustmentCF"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "settlementFinancialAdjustmentQueue") 
})
public class SettlementFinancialAdjustmentMDB implements MessageListener {

	@EJB
	private transient FinancialAdjustmentProcessor financialAdjustmentProcessor;

	public SettlementFinancialAdjustmentMDB() {
	}

	public void onMessage(final Message message) {
		try {
			// DomainObject domainObject;
			if (message instanceof ObjectMessage) {
				ObjectMessage msg = (ObjectMessage) message;

				if (msg.getObject() instanceof SettlementFinancialAdjustment) {
					// domainObject = (DomainObject) msg.getObject();
//					Logger.getLogger(this.getClass().getName())
//							.info("SettlementFinancialAdjustmentMDB Obj: " + msg.getObject().toString());
					SettlementFinancialAdjustment entity = (SettlementFinancialAdjustment) msg.getObject();
					// entity.setNuCustomer(123L);
					// entity.setDtSettlementAdjustment(new Date());
					// entity.setVlGross(new BigDecimal(120));
					// entity.setCdMovementType(MovementTypeEnum.CREDIT_ADJUST);
					// entity.setNuModCustomer(1);
					financialAdjustmentProcessor.process(entity);
				}
			} else if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				// domainObject = new Gson().fromJson(msg.getText(),
				// DomainObject.class);
				Logger.getLogger(this.getClass().getName()).info("SettlementFinancialAdjustmentMDB Text: " + msg.getText());
			} else {
				throw new JMSException("Mensagem inválida para este Queue MDB");
			}

		} catch (JMSException e) {
			Logger.getLogger(this.getClass().getName()).info(
					String.format("ERRO ao consumir mensagem:" + this.getClass() + ".onMessage: {0}", e.getMessage()));
			throw new RuntimeException(e);
		}
	}
}