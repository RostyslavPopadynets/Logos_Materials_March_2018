package ua.logos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	// ua.logos.entity
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		
		
		em.close();
		factory.close();
	}
}
