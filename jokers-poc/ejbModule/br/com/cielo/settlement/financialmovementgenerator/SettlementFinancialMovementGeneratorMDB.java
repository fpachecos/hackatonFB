
package br.com.cielo.settlement.financialmovementgenerator;


import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.processor.FinancialMovementProcessor;

/**
 * Classe responsável por receber mensagem da fila de geração de movimentação financeira
 */
@MessageDriven(activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName",
	                    propertyValue = "settlementFinancialMovementGeneratorCF"),
	    @ActivationConfigProperty(propertyName = "destinationJndiName",
	                    propertyValue = "settlementFinancialMovementGeneratorQueue")
	})
public class SettlementFinancialMovementGeneratorMDB  implements MessageListener {

    @EJB
    private transient FinancialMovementProcessor financialMovementProcessor;

    public SettlementFinancialMovementGeneratorMDB() {
    }
    
    public void onMessage(final Message message) {
        try {
        	SettlementFinancialMovement  financialMovement;
			if (message instanceof ObjectMessage) {
				ObjectMessage msg = (ObjectMessage) message;
                financialMovement = (SettlementFinancialMovement) msg.getObject();
                Logger.getLogger(this.getClass().getName()).info("SettlementFinancialMovementGeneratorMDB: "+financialMovement);
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
//                financialMovement = new Gson().fromJson(msg.getText(), SettlementFinancialMovement.class);
                financialMovement=null;
                Logger.getLogger(this.getClass().getName()).info("SettlementFinancialMovementGeneratorMDB: "+msg.getText());
            } else {
            	throw new JMSException("Mensagem inválida para este Queue MDB");
            }

            financialMovementProcessor.process(financialMovement);
            
        } catch (JMSException e) {
            Logger.getLogger(this.getClass().getName()).info(
            		String.format("ERRO ao consumir mensagem:"+this.getClass()+".onMessage: {0}",
                            e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}