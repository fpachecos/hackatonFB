
package br.com.cielo.settlement.financialadjustment;


import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

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
                System.out.println("Queue: ObjectMessage recebida em " + new Date());
                ObjectMessage msg = (ObjectMessage) message;
//                domainObject = (DomainObject) msg.getObject();
            } else if (message instanceof TextMessage) {
                System.out.println("Queue:  TextMessage recebida em " + new Date());
                TextMessage msg = (TextMessage) message;
                System.out.println("Messagem: " + msg.getText());
//                domainObject = new Gson().fromJson(msg.getText(), DomainObject.class);
            } else {
            	throw new JMSException("Mensagem inválida para este Queue MDB");
            }

            //TODO: chama serviço que irá processar a mensagem
        } catch (JMSException e) {
            Logger.getLogger(this.getClass().getName()).info(
            		String.format("ERRO ao consumir mensagem:"+this.getClass()+".onMessage: {0}",
                            e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}