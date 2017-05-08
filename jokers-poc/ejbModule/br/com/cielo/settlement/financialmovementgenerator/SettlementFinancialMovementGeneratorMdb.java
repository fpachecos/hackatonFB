
package br.com.cielo.settlement.financialmovementgenerator;

import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.processor.FinancialMovementProcessor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


/**
 * Classe respons�vel por receber mensagem da fila de gera��o de movimenta��o financeira.
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName",
        propertyValue = "settlementFinancialMovementGeneratorCF"),
    @ActivationConfigProperty(propertyName = "destinationJndiName",
        propertyValue = "settlementFinancialMovementGeneratorQueue")})
public class SettlementFinancialMovementGeneratorMdb implements MessageListener {

  @EJB
  private transient FinancialMovementProcessor financialMovementProcessor;

  public SettlementFinancialMovementGeneratorMdb() {}

  /**
   * {@inheritDoc}
   * 
   * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
   */
  public void onMessage(final Message message) {
    try {
      SettlementFinancialMovement financialMovement = null;
      if (message instanceof ObjectMessage) {
        ObjectMessage msg = (ObjectMessage) message;
        financialMovement = (SettlementFinancialMovement) msg.getObject();
      } else if (message instanceof TextMessage) {
        TextMessage msg = (TextMessage) message;
        ObjectMapper mapper = new ObjectMapper();
        try {
          financialMovement =
              mapper.readValue(msg.getText(), new TypeReference<SettlementFinancialMovement>() {});
        } catch (JsonParseException e) {
          e.printStackTrace();
        } catch (JsonMappingException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        throw new JMSException("Mensagem inv�lida para este Queue MDB");
      }

      financialMovementProcessor.process(financialMovement);

    } catch (JMSException e) {
      Logger.getLogger(this.getClass().getName()).info(String.format(
          "ERRO ao consumir mensagem:" + this.getClass() + ".onMessage: {0}", e.getMessage()));
      throw new RuntimeException(e);
    }
  }
}
