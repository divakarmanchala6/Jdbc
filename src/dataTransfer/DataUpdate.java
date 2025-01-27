package dataTransfer;
import java.sql.*;

public class DataUpdate {

	public static void main(String[] args) {
		try {
			//loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establishing the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			
			// user details to update 
			
			int id = 1;
			String firstName = "Divakar";
			String lastName = "Dv";
			int age = 27;
			
			// users details query
			String usersQuery = "SELECT * FROM employees";
			
			// update user details query if id exist in the database
			String updateUserQuery = "UPDATE employees SET first_name = ?, last_name = ?, age = ?  WHERE id = ?";
			
			
			//String query = "INSERT INTO employees(id, first_name, last_name, age) VALUES(?, ?, ?, ?)";
			
			PreparedStatement prpt = conn.prepareStatement(usersQuery);
			
			ResultSet results = prpt.executeQuery();
			
			
			
			while (results.next()) {
				// check the user id is already exist and updating
				if (id == results.getInt("id")) {
					PreparedStatement updatePrpt = conn.prepareStatement(updateUserQuery);
					updatePrpt.setString(1, firstName);
					updatePrpt.setString(2, lastName);
					updatePrpt.setInt(3, age);
					updatePrpt.setInt(4, id);
					updatePrpt.execute();
					System.out.println("updated");
					
				} else {
					
					// we can print here 
					System.out.println("can print without updates");
				}
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
