package prepSts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteEmployee {

	public static void main(String[] args) {
		try {
			// Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			// Establish the connection 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Connected to database");
			
			// query
			String query = "DELETE FROM employees WHERE employee_id = ?";
			
			
			// Establish the statement
			PreparedStatement prpt = connection.prepareStatement(query);
			System.out.println("Establish the statement");
			prpt.setInt(1, 2);
			
			// Execute the query
			prpt.executeUpdate();
			
			System.out.println("Query executed");
			
			//closing the connection
			connection.close();
			System.out.println("Database discounnected");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
