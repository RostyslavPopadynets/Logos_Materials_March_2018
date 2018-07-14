package ua.logos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/university?useSSL=false";
		String username = "zavada";
		String password = "zavada";
		
		conn = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Connected? " + !conn.isClosed());
		
		createTable();
		
		for(int i = 1; i <= 50; i++) {
			addStudent(i);
		}
		
		selectStudents();
		
		conn.close();
	}
	
	private static void createTable() throws SQLException {
		String dropQuery = "DROP TABLE IF EXISTS student;";
		String query = "CREATE TABLE student("
				+ "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "first_name VARCHAR(30),"
				+ "last_name VARCHAR(30),"
				+ "age INT"
				+ ");";
		
		Statement stmt = conn.createStatement();
		stmt.execute(dropQuery);
		stmt.execute(query);
		
		stmt.close();
		
		System.out.println("Table 'student' created");
	}
	
	private static void addStudent(int i) throws SQLException {
		String query = "INSERT INTO student(first_name, last_name, age) "
				+ "VALUES(?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		//INSERT INTO student(first_name, last_name, age) VALUES(?, ?, ?)
		pstmt.setString(1, "John#" + i);
		//INSERT INTO student(first_name, last_name, age) VALUES('John#12', ?, ?)
		pstmt.setString(2, "Doe#" + i);
		pstmt.setInt(3, i);
		
		pstmt.executeUpdate();
		pstmt.close();
		
		System.out.println("Students added to DB");
	}
	
	private static void selectStudents() throws SQLException {
		String query = "SELECT * FROM student;";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		List<String> students = new ArrayList<>();
		
		while(rs.next()) {
			// System.out.println(rs.getString("first_name"));
			students.add("id: " + rs.getInt("id") + "\t | "
					+ "first_name: " + rs.getString("first_name") + "\t | "
					+ "last_name: " + rs.getString("last_name") + "\t | "
					+ "age: " + rs.getInt("age") 
			);
		}
		
		students.forEach(System.out::println);
		
		rs.close();
		pstmt.close();
	}
	
	private static void selectStudentById(int id) throws SQLException {
		String query = "SELECT * FROM student WHERE id = ?;";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println
			("id: " + rs.getInt("id") + "\t | "
					+ "first_name: " + rs.getString("first_name") + "\t | "
					+ "last_name: " + rs.getString("last_name") + "\t | "
					+ "age: " + rs.getInt("age") 
			);
		}
		
		rs.close();
		pstmt.close();
	}
	
	
	
}
