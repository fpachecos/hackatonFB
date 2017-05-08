
package br.com.cielo.settlement.financialadjustment;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import br.com.cielo.settlement.financialmovementgenerator.SettlementFinancialMovementGeneratorClient;
import br.com.cielo.settlement.processor.FinancialAdjustmentProcessor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



/**
 * Classe respons�vel por receber mensagem da fila de ajuste financeiro.
 */
@MessageDriven(name = "SettlementFinancialAdjustmentMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName",
        propertyValue = "settlementFinancialAdjustmentCF"),
    @ActivationConfigProperty(propertyName = "destinationJndiName",
        propertyValue = "settlementFinancialAdjustmentQueue")})
public class SettlementFinancialAdjustmentMdb implements MessageListener {

  @EJB
  private transient FinancialAdjustmentProcessor financialAdjustmentProcessor;


  @EJB
  private transient SettlementFinancialMovementGeneratorClient settFinancialMovementGeneratorClient;

  public SettlementFinancialAdjustmentMdb() {}

  /**
   * {@inheritDoc}
   * 
   * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
   */
  public void onMessage(final Message message) {

    ArrayList<SettlementFinancialAdjustment> entityList = null;

    try {
      if (message instanceof TextMessage) {
        TextMessage msg = (TextMessage) message;
        ObjectMapper mapper = new ObjectMapper();
        try {
          entityList = mapper.readValue(msg.getText(),
              new TypeReference<ArrayList<SettlementFinancialAdjustment>>() {});
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

      List<SettlementFinancialMovement> movementList = new ArrayList<SettlementFinancialMovement>();
      for (SettlementFinancialAdjustment settlementFinancialAdjustment : entityList) {
        financialAdjustmentProcessor.process(settlementFinancialAdjustment);
        movementList
            .add(new SettlementFinancialMovement(settlementFinancialAdjustment.getAdjustment()));
      }

      // Chamando próximo processamento - 1010
      this.settFinancialMovementGeneratorClient.send(movementList);

    } catch (JMSException e) {
      Logger.getLogger(this.getClass().getName()).info(String.format(
          "ERRO ao consumir mensagem:" + this.getClass() + ".onMessage: {0}", e.getMessage()));
      throw new RuntimeException(e);
    }
  }
}
