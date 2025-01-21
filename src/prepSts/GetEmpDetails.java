package prepSts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class GetEmpDetails {

	public static void main(String[] args) {
		try {
			//Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			// Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("connected to the database");
			
			// required query 
			String query = "SELECT * FROM employees WHERE employee_id = ?";
			
			// Establish the statement
			PreparedStatement prpt = connection.prepareStatement(query);
			prpt.setInt(1, 2);
			
			
			// Storing the signature
			ResultSet results = prpt.executeQuery();
			
			
			// displaying the details
			while (results.next()) {
				int employeeId = results.getInt("employee_id");
				String firstName = results.getString("first_name");
				String lastName = results.getString("last_name");
				int age = results.getInt("age");
				System.out.println("Employee ID: " + employeeId);
				System.out.println("First Name: " + firstName);
				System.out.println("Last Name: " + lastName);
				System.out.println("Age: " + age);
				
				
			}
			
			//closing the connection
			connection.close();
			System.out.println("Database connection closed");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
