package ua.logos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Course;
import ua.logos.entity.Teacher;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		// addTeacher(em);
		
//		List<Teacher> teachers = 
//				em.createQuery("SELECT t FROM Teacher t", Teacher.class)
//					.getResultList();
//		teachers.forEach(System.out::println);
		
//		List<Teacher> teachers = 
//				em.createQuery("SELECT t FROM Teacher t WHERE t.id > :teacherId", Teacher.class)
//					.setParameter("teacherId", 35L).getResultList();
//		teachers.forEach(System.out::println);

//		List<Teacher> teachers = 
//em.createQuery("SELECT t FROM Teacher t WHERE t.id > :teacherId1 AND t.id < :teacherId2", Teacher.class)
//				.setParameter("teacherId1", 25L)
//				.setParameter("teacherId2", 40L)
//				.getResultList();
// teachers.forEach(System.out::println);
	
//em.createQuery("SELECT t FROM Teacher t WHERE t.firstName LIKE :likePattern", Teacher.class)
//		.setParameter("likePattern", "% _")
//		.getResultList()
//		.forEach(System.out::println);

//em.createQuery("SELECT t FROM Teacher t WHERE t.email LIKE :likePattern AND t.id > :teacherId", Teacher.class)
//		.setParameter("likePattern", "%6")
//		.setParameter("teacherId", 10L)
//		.getResultList()
//		.forEach(System.out::println);
		
//		em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//		.setParameter("start", 15L)
//		.setParameter("finish", 18L)
//		.getResultList()
//		.forEach(System.out::println);
		
//		em.createQuery("SELECT t FROM Teacher t WHERE t.id IN(:ids)", Teacher.class)
//		.setParameter("ids", Arrays.asList(12L, 34L, 45L, 35L, 1L, 120L))
//		.getResultList()
//		.forEach(System.out::println);

		// addCourse(em);
//		em.createQuery("SELECT c FROM Course c", Course.class)
//			.getResultList().forEach(System.out::println);
//		
		
		createCourses(em);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	private static void addTeacher(EntityManager em) {
		for (int i = 1; i < 50; i++) {
			Teacher teacher = 
					Teacher.builder()
						.email("teacher@gmail.com " + i)
						.firstName("John " + i)
						.lastName("Doe " + i)
					.build();

			em.persist(teacher);
		}
	}
	
	private static void addCourse(EntityManager em) {
		Teacher teacher = 
				em.createQuery("SELECT t FROM Teacher t WHERE t.id = :tId", Teacher.class)
				.setParameter("tId", 10L)
				.getSingleResult();
		System.out.println(teacher);
		
		for (int i = 1; i < 8; i++) {
			Course course = new Course();
			course.setTitle("MySQL for beginners#" + i);
			course.setDescription("Learn MySQL");
			course.setPrice(new BigDecimal(i + "59.99"));
			course.setTeacher(teacher);
			em.persist(course);
		}
	}
	
	private static void createCourses(EntityManager em) {
		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class)
				.getResultList();
		
		for(int i = 0; i < teachers.size(); i++) {
			Teacher teacher = teachers.get(i);
			
			for(int j = 0; j < 5; j++) {
				Course course = new Course();
				course.setTitle("Spring 5" + i * j + "sdf");
				course.setDescription("Description");
				course.setPrice(new BigDecimal("1" + i + ".99"));
				course.setTeacher(teacher);
				em.persist(course);
			}
		}
	}
}
