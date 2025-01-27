package dataTransfer;

import java.io.*;
import java.sql.*;

public class AddAndUpdate {

	public static void main(String[] args) {
		String filePath = "/Users/divakarmanchala/Documents/userslist.csv";
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filePath));
			
			
			//loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			
			//Establishing the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "password");
			System.out.println("Connected to database");
			
			
			//Query for get users
			String getUsers = "SELECT * FROM employees";
			
			
			
			//Establishing the prepared statement
			PreparedStatement getUsersPrpt =  conn.prepareStatement(getUsers);
			System.out.println("Establishing Prpt");
			
			
			//Data representation in result set
			ResultSet userList = getUsersPrpt.executeQuery();
			
			String line;
			
			while ((line = buff.readLine()) != null) {
				String[] arr = line.split(",");
				int employeeId = Integer.parseInt(arr[0]);
				if (userList.next()) {
					while(userList.next()) {
						int dataBaseId = userList.getInt("id");
						System.out.println(dataBaseId);
						System.out.println(employeeId + " == " + dataBaseId);
						
						if (employeeId == dataBaseId) {
							String updateUserQuery = "UPDATE employees SET first_name = ?, last_name = ?, age = ?, salary = ? WHERE id = ?";
							PreparedStatement updatePrpt = conn.prepareStatement(updateUserQuery);
							updatePrpt.setString(1, arr[1]);
							updatePrpt.setString(2, arr[2]);
							updatePrpt.setInt(3, Integer.parseInt(arr[3]));
							updatePrpt.setInt(4, Integer.parseInt(arr[4]));
							updatePrpt.setInt(5, dataBaseId);
							updatePrpt.executeUpdate();
							System.out.println(userList.getString("first_name") + " has been updated");
						} else {
							String insertQuery = "INSERT INTO employees(id, first_name, last_name, age, salary) VALUES (?, ?, ?, ?, ?)";
							PreparedStatement insertPrpt = conn.prepareStatement(insertQuery);
							insertPrpt.setInt(1, Integer.parseInt(arr[0]));
							insertPrpt.setString(2, arr[1]);
							insertPrpt.setString(3, arr[2]);
							insertPrpt.setInt(4, Integer.parseInt(arr[3]));
							insertPrpt.setInt(5, Integer.parseInt(arr[4]));
							insertPrpt.executeUpdate();
							System.out.println(arr[1] + " inserted into database");
						}
					}
				} else {
					// inserting the data if table is completely empty
					
					
				}
			}
			
			
			// checking user details and updating user details;
			
//			String line;
//			while (userList.next()) {
//				//System.out.println(userList.getInt("id"));
//				
//				int dataBaseId = userList.getInt("id");
//				while ((line = buff.readLine()) != null) {
//					String[] arr = line.split(",");
//					int employeeId = Integer.parseInt(arr[0]);
//					if (dataBaseId == employeeId) {
//						String updateUserQuery = "UPDATE employees SET first_name = ?, last_name = ?, age = ?, salary = ? WHERE id = ?";
//						PreparedStatement updatePrpt = conn.prepareStatement(updateUserQuery);
//						updatePrpt.setString(1, arr[1]);
//						updatePrpt.setString(2, arr[2]);
//						updatePrpt.setInt(3, Integer.parseInt(arr[3]));
//						updatePrpt.setInt(4, Integer.parseInt(arr[4]));
//						updatePrpt.setInt(5, dataBaseId);
//						updatePrpt.executeUpdate();
//						System.out.println(userList.getString("first_name") + " has been updated");
//						
//					} else {
//						String insertQuery = "INSERT INTO employees(id, first_name, last_name, age, salary) VALUES (?, ?, ?, ?, ?)";
//						PreparedStatement insertPrpt = conn.prepareStatement(insertQuery);
//						insertPrpt.setInt(1, Integer.parseInt(arr[0]));
//						insertPrpt.setString(2, arr[1]);
//						insertPrpt.setString(3, arr[2]);
//						insertPrpt.setInt(4, Integer.parseInt(arr[3]));
//						insertPrpt.setInt(5, Integer.parseInt(arr[4]));
//						insertPrpt.executeUpdate();
//						System.out.println(arr[1] + " inserted into database");
//						
//					}
//				}
//				
//			}
			
			buff.close();
			conn.close();
			
			
			//String line;
			
			
//			while ((line = buff.readLine()) != null) {
//				String[] arr = line.split(",");
//				int employeeId = Integer.parseInt(arr[0]);
//				System.out.println(employeeId);
//			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}

}
