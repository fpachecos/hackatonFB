package br.com.cielo.settlement.movementgenerator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe responsável por enviar mensagem para fila de geração de movimentação financeira
 */
@Stateless
@LocalBean
public class SettlementFinancialMovementGeneratorClient {
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	public final static String JMS_FACTORY = "settlementFinancialMovementGeneratorCF";
	public final static String QUEUE = "settlementFinancialMovementGeneratorQueue";

	private QueueSession session = null;
    private QueueSender sender = null;
    private QueueConnection connection = null;
    private Queue destQueue;
    private Queue destQueueDLQ;

    @PostConstruct
    public void init() {
        try {
            InitialContext ic = new InitialContext();
            QueueConnectionFactory qcf = (QueueConnectionFactory) ic
                            .lookup(JMS_FACTORY);
            this.destQueue = (Queue) ic.lookup(QUEUE);
            this.destQueueDLQ = (Queue) ic.lookup(QUEUE);

            this.connection = qcf.createQueueConnection();
            this.session = this.connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            this.sender = this.session.createSender(this.destQueue);
            // this.sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ic.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void finilize() {
        try {
            this.connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * Envia os produtos a serem atualizados para a fila.
     *
     * @param productsToUpdate
     */
    public void send(final String message) {
        try {
    		Logger.getLogger(this.getClass().getName()).info("SettlementFinancialMovementGeneratorClient: "+message);
            ObjectMessage objectMessage = this.session.createObjectMessage(message);
            objectMessage.setStringProperty("message", message);
            this.sender.send(objectMessage);
        } catch (JMSException e) {
            Logger.getLogger(this.getClass().getName()).info("SettlementFinancialMovementGeneratorClient.send" + e);
        }
    }

    public List<ObjectMessage> browseQueue() {
        return this.browse(this.destQueue);
    }

    public List<ObjectMessage> browseQueueDLQ() {
        return this.browse(this.destQueueDLQ);
    }

    private List<ObjectMessage> browse(final Queue destQueue) {
        List<ObjectMessage> list = new ArrayList<ObjectMessage>();

        try {
            QueueBrowser browser;
            browser = this.session.createBrowser(destQueue);

            @SuppressWarnings("rawtypes")
            Enumeration msgs = browser.getEnumeration();

            if (!msgs.hasMoreElements()) {
                System.out.println("No messages in queue");
            } else {
                while (msgs.hasMoreElements()) {
                    ObjectMessage objectMessage = (ObjectMessage) msgs.nextElement();
                    list.add(objectMessage);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return list;
    }
}