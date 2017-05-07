package br.com.cielo.test;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TestScheduler {

	private int count = 1;

//	@Schedule(second = "*/1", minute = "*", hour = "*", persistent = false)
	public void sendMessage() {
		String message = "Mensage " + count++;
		Logger.getLogger(this.getClass().getName()).info("TestScheduler: " + message);
//		settlementFinancialAdjustmentClient.send(new TesteDataVO());
	}
}