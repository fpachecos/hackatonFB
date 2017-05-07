package br.com.cielo.test;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestPersistence {

	@PersistenceContext(unitName="bob")
	private transient EntityManager entityManager;
	
	@Schedule(second="*/20", minute="*", hour="*", persistent=false)
	public void sendMessage(){
		Object singleResult = entityManager.createNativeQuery("SELECT 123 FROM DUAL").getSingleResult();
		System.out.println(singleResult);
	}
}