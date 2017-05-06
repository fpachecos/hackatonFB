package br.com.cielo.test;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import br.com.cielo.settlement.financialadjustment.SettlementFinancialAdjustmentClient;

@Stateless
public class TestScheduler {
	
	@EJB
	private transient SettlementFinancialAdjustmentClient settlementFinancialAdjustmentClient;
	
	private int count = 1;
	
	@Schedule(second="*/1", minute="*", hour="*", persistent=false)
	public void sendMessage(){
		String message = "Mensage "+count++;
		Logger.getLogger(this.getClass().getName()).info("TestScheduler: "+message);
		settlementFinancialAdjustmentClient.send(message);
	}
}