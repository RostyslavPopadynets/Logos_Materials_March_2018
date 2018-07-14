package ua.logos;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Manufacturer;
import ua.logos.entity.Model;

public class App {

	public static void main(String[] args) throws ParseException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		// createManufacturer(em);
		// createModel(em);
		// generateRandom(em);
		
//		List<Manufacturer> manufacturers = em
//				.createQuery("SELECT m FROM Manufacturer m", Manufacturer.class)
//				.getResultList();
//		manufacturers.forEach(System.out::println);
		
		/*em.createQuery("SELECT m FROM Manufacturer m", Manufacturer.class)
			.getResultList()
			.forEach(System.out::println);
		
		em.createQuery("SELECT m FROM Model m", Model.class)
			.getResultList()
			.forEach(System.out::println);*/
		
//		Model model = em
//			.createQuery("SELECT m FROM Model m WHERE m.id = :modelId", Model.class)
//			.setParameter("modelId", 900)
//			.getSingleResult();
//		System.out.println(model);
		
		
//		em
//			.createQuery("SELECT m FROM Model m WHERE m.id = :modelId OR m.id = :modelId2", Model.class)
//			.setParameter("modelId", 500)
//			.setParameter("modelId2", 600)
//			.getResultList().forEach(System.out::println);
//		
//		Manufacturer manufacturer = 
//				em.createQuery("SELECT m FROM Manufacturer m WHERE m.name = :manufName", Manufacturer.class)
//				.setParameter("manufName", "manufacturer-6").getSingleResult();
//		System.out.println(manufacturer);
		
//		em.createQuery("SELECT m FROM Model m WHERE m.year LIKE :yearPattern", Model.class)
//			.setParameter("yearPattern", "%62")
//			.getResultList().forEach(System.out::println);
		
//		em.createQuery("SELECT m FROM Model m WHERE m.year LIKE :yearPattern AND m.id > :modelId", Model.class)
//		.setParameter("yearPattern", "%80")
//		.setParameter("modelId", 1000)
//		.getResultList().forEach(System.out::println);
		
		
		em.createQuery("SELECT m FROM Manufacturer m WHERE m.id BETWEEN :start AND :finish", Manufacturer.class)
			.setParameter("start", 40)
			.setParameter("finish", 60)
			.getResultList()
			.forEach(System.out::println);
		
		em.createQuery("SELECT m FROM Model m WHERE m.id IN (:ids)", Model.class)
			.setParameter("ids", Arrays.asList(23, 45, 67, 34, 675, 678, 345, 689769, 345345))
			.getResultList()
			.forEach(System.out::println);
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();

	}
	
	private static void createManufacturer(EntityManager em) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName("BMW");
		manufacturer.setShortName("BMW");
		System.out.println(manufacturer.toString());
		em.persist(manufacturer);
		System.out.println(manufacturer.toString());
		
		manufacturer = new Manufacturer();
		manufacturer.setName("Volkswagen");
		manufacturer.setShortName("VW");
		em.persist(manufacturer);
	}
	
	private static void createModel(EntityManager em) {
		// JPQL
		Manufacturer manufacturer = em
				.createQuery("SELECT m FROM Manufacturer m WHERE m.id = :manufId", Manufacturer.class)
				.setParameter("manufId", 2)
				.getSingleResult();
		
		System.out.println(manufacturer.toString());
		
		Model model = new Model();
		model.setName("Passat");
		model.setYear("2008");
		System.out.println(model.toString());
		model.setManufacturer(manufacturer);
		System.out.println(model.toString());
		
		em.persist(model);
		System.out.println(model.toString());
	}
	
	private static void generateRandom(EntityManager em) {
		
		for(int i = 0; i < 100; i++) {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setName("manufacturer-" + i);
			manufacturer.setShortName("m-short-" + i);
			em.persist(manufacturer);
			
			for(int j = 0; j < 20; j++) {
				Model model = new Model();
				model.setName("model-" + i + "-name");
				model.setYear(String.valueOf(1900 + i + j));
				model.setManufacturer(manufacturer);
				em.persist(model);
			}
		}
		
	}

}
