package dataTransfer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataTransfer {

	public static void main(String[] args) {
		
		String filePath = "/Users/divakarmanchala/Documents/data.csv";
		try {
			// Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establishing the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			
			//query
			String query = "INSERT INTO employees(employee_id, first_name, last_name, age, salary) VALUES (?, ?, ?, ?, ?)";
			
			// Establishing the statement 
			PreparedStatement prpt = connection.prepareStatement(query);
			
			
			//Getting data from the file
			BufferedReader rd = new BufferedReader(new FileReader(filePath));
			String line; 
			int count = 0;
			while ((line = rd.readLine()) != null) {
				
				if (count == 0) {
					count++;
					continue;
				}
				String[] ar = line.split(",");
				prpt.setInt(1, Integer.parseInt(ar[0]));
				prpt.setString(2, ar[1]);
				prpt.setString(3, ar[2]);
				prpt.setInt(4, Integer.parseInt(ar[3]));
				prpt.setInt(5, Integer.parseInt(ar[4]));
				//Executing the query
				prpt.executeUpdate();
				count++;
				
			}
			System.out.println("Query executed");
		
			rd.close();
			connection.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}

}
