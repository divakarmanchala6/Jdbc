package crudOps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {

	public static void main(String[] args) {
		try {
			// loading the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			//establishing the connection
			Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Connected to database");
			
			//establishing the statement 
			Statement statement = connection.createStatement();
			
			String query = "DELETE FROM employees WHERE employee_id = 1";
			statement.execute(query);
			
			System.out.println("Statement executed");
			connection.close();
			
			System.out.println("Connection closed");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
