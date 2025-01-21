package crudOps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ModifyUser {

	public static void main(String[] args) {
		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			//Establish the connection 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Connected to database successfully");
			
			//Establish the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created");
			
			//Executing the query
			String query = "UPDATE FROM employees SET name = 'Dv' WHERE employee_id = 1";
			statement.execute(query);
			System.out.println("Statement executed successfully");
			
			//Closing the connection
			connection.close();
			System.out.println("Connection closed succssfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
