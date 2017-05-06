
package br.com.cielo.settlement.financialadjustment;


import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Classe respons�vel por receber mensagem da fila de ajuste financeiro
 */
@MessageDriven(activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName",
	                    propertyValue = "settlementFinancialAdjustmentCF"),
	    @ActivationConfigProperty(propertyName = "destinationJndiName",
	                    propertyValue = "settlementFinancialAdjustmentQueue")
	})
public class SettlementFinancialAdjustmentMDB implements MessageListener {

//    @Inject
//    private transient SettlementFinancialAdjustmentEJB settlementFinancialAdjustmentEJB;

    public SettlementFinancialAdjustmentMDB() {
    }
    
    public void onMessage(final Message message) {
        try {
        	//DomainObject domainObject;
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
//                domainObject = (DomainObject) msg.getObject();
                Logger.getLogger(this.getClass().getName()).info("SettlementFinancialAdjustmentMDB: "+msg.getStringProperty("message"));
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
//                domainObject = new Gson().fromJson(msg.getText(), DomainObject.class);
                Logger.getLogger(this.getClass().getName()).info("SettlementFinancialAdjustmentMDB: "+msg.getText());
            } else {
            	throw new JMSException("Mensagem inv�lida para este Queue MDB");
            }

            //TODO: chama servi�o que ir� processar a mensagem
        } catch (JMSException e) {
            Logger.getLogger(this.getClass().getName()).info(
            		String.format("ERRO ao consumir mensagem:"+this.getClass()+".onMessage: {0}",
                            e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}