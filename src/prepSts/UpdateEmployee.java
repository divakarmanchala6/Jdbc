package prepSts;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateEmployee {

	public static void main(String[] args) {
		try {
			//loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loded");
			
			
			//Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("Establishing the connection");
			
			// query
			
			String query = "UPDATE employees SET first_name = ?, last_name= ?, age=? WHERE employee_id = ?";
			PreparedStatement prpt = connection.prepareStatement(query);
			
			prpt.setString(1, "Manideep");
			prpt.setString(2, "Manchala");
			prpt.setInt(3, 22);
			prpt.setInt(4, 2);
			
			prpt.executeUpdate();
			System.out.println("Prpt executed");
			
			connection.close();
			System.out.println("Connection closed");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
