package ua.logos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Teacher;
import ua.logos.entity.TeacherDetails;

public class App {
	// ua.logos.entity
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		
//		List<Teacher> teachers = 
//				em.createQuery("SELECT t FROM Teacher t", Teacher.class)
//				.getResultList();
//		teachers.forEach(System.out::println);
		
//		for(int i = 0; i < 30; i++) {
//			addTeacher(em, i);
//		}
		
//		Teacher teacher = 
//	em.createQuery("SELECT t FROM Teacher t WHERE t.id = :teacherId", Teacher.class)
//	.setParameter("teacherId", 5L).getSingleResult();
//		System.out.println(teacher);
		
		Teacher teacher = Teacher
					.builder()
						.email("john@gmail.com")
						.firstName("Johnny")
						.lastName("Doee")
						.age(25)
					.build();
		
		TeacherDetails teacherDetails = new TeacherDetails();
		teacherDetails.setHobby("Programming");
		teacherDetails.setExperiance("10 years");
		
		System.out.println(teacherDetails);
		em.persist(teacherDetails);
		System.out.println(teacherDetails);
		
		teacher.setTeacherDetails(teacherDetails);
		em.persist(teacher);
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	private static void addTeacher(EntityManager em, int i) {
		Teacher teacher = new Teacher();
		teacher.setEmail("bestteacher" + i + "@gmail.com");
		teacher.setFirstName("John#" + i);
		teacher.setLastName("Doe#" + i);
		teacher.setAge(45);
		
		em.persist(teacher);
	}
}
