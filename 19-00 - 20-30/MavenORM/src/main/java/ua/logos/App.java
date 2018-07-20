package ua.logos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Teacher;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		
		//Teacher teacher = new Teacher();
		//teacher.setEmail("teacher@gmail.com");
		
		Teacher teacher = Teacher
				.builder()
					.email("teacher@gmail.com")
					.firstName("John")
					.lastName("Doe")
				.build();
		
		em.persist(teacher);
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
}
