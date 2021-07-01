package dbservices;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUser {

	public static boolean isValidUser(String useremail, String userpassword) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean result = false;

		
		Connection con = DbConnection.getConnection();
		try (Statement statement = con.createStatement()){
			try(ResultSet resultSet = statement.executeQuery("select count(userId) from user where Email = " + useremail + "and Password = "+ userpassword)){
				long userId = Long.parseLong(resultSet.getString(1));
				if (userId >0) {
					result = true;
					
				}
			} catch (Exception e) {
				result = false;
			} finally {
				con.close();
			}
			
			return result;
		}
	}
}
