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
		
		for(int i = 1; i <= 60; i++) {
			addStudents(i);
		}
		
		// selectStudents();
		selectStudent(10);
		conn.close();
	}
	
	public static void createTable() throws SQLException {
		String dropQuery = "DROP TABLE IF EXISTS student;"; // <----
		String query = "CREATE TABLE student("
				+ "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "full_name VARCHAR(255) NOT NULL,"
				+ "city VARCHAR(255) NOT NULL,"
				+ "age INT NOT NULL"
				+ ");";
		
		Statement stmt = conn.createStatement();
		stmt.execute(dropQuery); // <---
		stmt.execute(query);
		System.out.println("Table 'Student' created!");
		stmt.close();
	}
	
	public static void addStudents(int i) throws SQLException {
		String query = "INSERT INTO student(full_name, city, age) VALUES (?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		//INSERT INTO student(full_name, city, age) VALUES (?, ?, ?)
		pstmt.setString(1, "John Doe #" + i);
		
		//INSERT INTO student(full_name, city, age) VALUES ('John Doe #2', ?, ?)
		pstmt.setString(2, "Lviv");
		
		//INSERT INTO student(full_name, city, age) VALUES ('John Doe #2', 'Lviv', ?)
		pstmt.setInt(3, i + 10);
		//INSERT INTO student(full_name, city, age) VALUES ('John Doe #2', 'Lviv', 15)
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public static void selectStudents() throws SQLException {
		String query = "SELECT * FROM student;";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		List<String> students = new ArrayList<>();
		
		while(rs.next()) {
			// System.out.println(rs.getString("full_name"));
			students.add("ID: " + rs.getInt("id") + "\t |"
						+ "Full Name: " + rs.getString("full_name") + "\t |"
						+ "City: " + rs.getString("city") + "\t |"
						+ "Age: " + rs.getString("age") + "\t |");
		}
		
		students.forEach(System.out::println);
		
		rs.close();
		pstmt.close();
	}
	
	private static void selectStudent(int i) throws SQLException {
		String query = "SELECT * FROM student WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, i);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + "\t |"
						+ "Full Name: " + rs.getString("full_name") + "\t |"
						+ "City: " + rs.getString("city") + "\t |"
						+ "Age: " + rs.getString("age") + "\t |");
		}
	}
	
}
