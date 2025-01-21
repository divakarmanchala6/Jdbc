package crudOps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class AddNewUser {

	public static void main(String[] args) {
		try {
			
			//Load MySql JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded successfully with Class.forName()");
			
			// Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Connected to database successfully");
			
			//Establish the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created");
			
			//Executing the query
			String query = "INSERT INTO employees(first_name, last_name, age) VALUES('Manideep', 'Manchala', 24)";
			statement.execute(query);
			System.out.println("Statement executed");
			
			//closing the connection
			connection.close();
			System.out.println("Connection closed successfully");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
