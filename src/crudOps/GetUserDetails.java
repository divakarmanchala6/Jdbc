package crudOps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserDetails {

	public static void main(String[] args) {
		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			//Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Connected to the database");
			
			//Establish the statement
			String query = "SELECT * FROM employees WHERE employee_id = 1";
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				int employeeId = results.getInt("employee_id");
				String employeeFirstName = results.getString("first_name");
				String employeeLastName = results.getString("last_name");
				System.out.println("Employee Id: " + employeeId);
				System.out.println("First Name: " + employeeFirstName);
				System.out.println("Last Name: "  + employeeLastName);
				
			}
			
			System.out.println("statement executed");
			connection.close();
			
			System.out.println("Connection closed");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
