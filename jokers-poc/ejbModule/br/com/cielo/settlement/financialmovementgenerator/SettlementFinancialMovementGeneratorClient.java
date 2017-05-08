package br.com.cielo.settlement.financialmovementgenerator;

import br.com.cielo.settlement.entity.SettlementFinancialMovement;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe respons�vel por enviar mensagem para fila de gera��o de movimenta��o financeira.
 */
@Stateless
@LocalBean
public class SettlementFinancialMovementGeneratorClient {
  public static final String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
  public static final String JMS_FACTORY = "settlementFinancialMovementGeneratorCF";
  public static final String QUEUE = "settlementFinancialMovementGeneratorQueue";

  private QueueSession session = null;
  private QueueSender sender = null;
  private QueueConnection connection = null;
  private Queue destQueue;

  /**
   * Método para inicializar variáveis de contexto da fila.
   */
  @PostConstruct
  public void init() {
    try {
      InitialContext ic = new InitialContext();
      QueueConnectionFactory qcf = (QueueConnectionFactory) ic.lookup(JMS_FACTORY);
      this.destQueue = (Queue) ic.lookup(QUEUE);

      this.connection = qcf.createQueueConnection();
      this.session = this.connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      this.sender = this.session.createSender(this.destQueue);
      ic.close();
    } catch (NamingException | JMSException e) {
      e.printStackTrace();
    }
  }

  /**
   * Método que encerra conexões com a fila.
   */
  @PreDestroy
  public void finilize() {
    try {
      this.connection.close();
      this.session.close();
      this.sender.close();
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  /**
   * Envia mensagem de movimento financeiro para a fila do "JOB 1010".
   * 
   * @param financialMovement - Movimento financeiro
   */
  public void send(final SettlementFinancialMovement financialMovement) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      TextMessage message =
          this.session.createTextMessage(mapper.writeValueAsString(financialMovement));
      this.sender.send(message);
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName())
          .info("SettlementFinancialMovementGeneratorClient.send" + e);
    }
  }
}
