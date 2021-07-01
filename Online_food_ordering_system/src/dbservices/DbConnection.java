package dbservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	final static String JdbcURL = "jdbc:mysql://localhost:3306/online_food_delivery";
	final static String Username = "root";
	final static String password = "1511@#sU";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection(JdbcURL, Username, password);
    	return con;
    }
}
