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

	static Connection con;
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/university?serverTimezone=UTC";
		String username = "zavada";
		String password = "zavada";
		
		con = DriverManager.getConnection(url, username, password);
		System.out.println("Connected? " + !con.isClosed());
		
		createTable();
		
		for(int i = 0; i < 50; i++) {
			addStudent(i);
		}
		
		selectStudents();
		
		con.close();
	}
	
	static void createTable() throws SQLException {
		String dropQuery = "DROP TABLE IF EXISTS student;";
		String query = "CREATE TABLE student("
				+ "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "full_name VARCHAR(50) NOT NULL,"
				+ "age INT NOT NULL"
				+ ");";
		
		Statement stmt = con.createStatement();
		stmt.execute(dropQuery);
		stmt.execute(query);
		stmt.close();
	}
	
	static void addStudent(int i) throws SQLException {
		String query = "INSERT INTO student(full_name, age) VALUES(?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, "John Doe #" + i);
		pstmt.setInt(2, i);
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	static void selectStudents() throws SQLException {
		String query = "SELECT * FROM student;";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		List<String> students = new ArrayList<>();
		
		while (rs.next()) {
			//System.out.println(rs.getString("full_name"));
			students.add("ID: " + rs.getInt("id") + "\t | "
					+ "Full Name: " + rs.getString("full_name") + "\t | "
					+ "Age: " + rs.getInt("age"));
		}
		
		students.forEach(System.out::println);
		
		rs.close();
		pstmt.close();
		
	}

}
