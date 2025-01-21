package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task1 {

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver done");

            // Establish connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
            System.out.println("Connection done");

            // Corrected table name and SQL query
            String data = "INSERT INTO employees(first_name, last_name, age) VALUES ('Divakar', 'Manchala', 29)";
            
            // Create Statement and execute the query
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            statement.execute(data);  // Use executeUpdate for INSERT, UPDATE, DELETE
            System.out.println("Data executed");

            // Close connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
