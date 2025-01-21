package prepSts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewUser {

	public static void main(String[] args) {
		try {
			//Loading the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			//Establish the connection 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Establishing the connection");
			
			//Querying in the variable 
			String query = "INSERT INTO employees(employee_id, first_name, last_name, age) VALUES(?, ?, ?, ?)";
			
			//Establish the Statement
			PreparedStatement prpt = connection.prepareStatement(query);
			prpt.setInt(1, 3);
			prpt.setString(2, "John");
			prpt.setString(3, "Deo");
			prpt.setInt(4, 32);
			System.out.println("Establishing the statements");
			
			
			//Executing the query
			prpt.executeUpdate();
			System.out.println("Query executed");
			
			
			//Closing the connection
			connection.close();
			System.out.println("Connection closed");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
