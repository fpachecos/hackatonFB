package br.com.cielo.settlement.financialadjustment;

import java.util.ArrayList;
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
import javax.json.stream.JsonGenerator;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;

/**
 * Classe respons�vel por enviar mensagem para fila de ajuste financeiro
 */
@Stateless
@LocalBean
public class SettlementFinancialAdjustmentClient {
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	public final static String JMS_FACTORY = "settlementFinancialAdjustmentCF";
	public final static String QUEUE = "settlementFinancialAdjustmentQueue";

	private QueueSession session = null;
	private QueueSender sender = null;
	private QueueConnection connection = null;
	private Queue destQueue;
	@PostConstruct
	private void init() {
			try {
				InitialContext ic = new InitialContext();
				QueueConnectionFactory qcf;
				qcf = (QueueConnectionFactory) ic.lookup(JMS_FACTORY);
				this.destQueue = (Queue) ic.lookup(QUEUE);
				
				this.connection = qcf.createQueueConnection();
				this.session = this.connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
				this.sender = this.session.createSender(this.destQueue);
				ic.close();
			} catch (NamingException | JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@PreDestroy
	private void end() {
		try {
			this.connection.close();
			this.session.close();
			this.sender.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Envia os produtos a serem atualizados para a fila.
	 *
	 * @param productsToUpdate
	 */
	public void send(final ArrayList<SettlementFinancialAdjustment> settlementFinancialAdjustment) {
		try {
//			Logger.getLogger(this.getClass().getName())
//					.info("SettlementFinancialAdjustment: " + settlementFinancialAdjustment.toString());
			ObjectMapper mapper = new ObjectMapper();
			TextMessage message = this.session.createTextMessage(mapper.writeValueAsString(settlementFinancialAdjustment));
			this.sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(this.getClass().getName()).info("ContractedProductEditPriceMDBClient.send" + e);
		}
	}
}