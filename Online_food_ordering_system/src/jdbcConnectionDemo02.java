import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnectionDemo02 {

	
	
	public static void main(String[] args) throws SQLException {
		
//	    String JdbcURL = "jdbc:mysql://localhost:3306/hotel";
//	    String Username = "root";
//	    String password = "1511@#sU";
//	    Connection con = null;
//	    
//	    con = DriverManager.getConnection(JdbcURL, Username, password);
		

		
		
		addCustomer(4, "Kusal", "kusal@yandex.com", "card", "25000.00", "2021/03/02");
//		addCustomer(8, "Nimal", "nimal_s@outlook.com", "0702238989", "nimal", "2222");
//
//	    updateCustomer("H", "nimal@outlook.com", 8);
//
//	    removeCustomer(8);

	    showCustomer();

	}
	
	
//	public static void showCustomer(int id, String name, String email, String phone, String username, String pass) throws SQLException {
	
	public static void showCustomer() throws SQLException {
		
		 String JdbcURL = "jdbc:mysql://localhost:3306/online_food_delivery ";
		 String Username = "root";
		 String password = "1511@#sU";
		 Connection con = null;

		 
		 con = DriverManager.getConnection(JdbcURL, Username, password);

		 try(Statement statement = con.createStatement()){ 
//			 try(ResultSet resultset= statement.executeQuery("select id, name, email, phome, userName, password from customer")){
			 
			 try(ResultSet resultset= statement.executeQuery("select userId, Name, Email, userName, Password from user")){
				 while(resultset.next()) {
//	    			 System.out.println("ID = " + resultset.getString(1) + "  Name = " + resultset.getString(2)+
//	    					 			"\tEmail = " + resultset.getString(3)  + "\tPhone number = "+resultset.getString(4)+
//	    					 			"\tUser_name = " + resultset.getString(5) + "\tPassword  = " + resultset.getString(6));
					 
					 System.out.println("ID = " + resultset.getString(1) + "  Name = " + resultset.getString(2)+
					 			"\tEmail = " + resultset.getString(3)+
					 			"\tUser_name = " + resultset.getString(4) + "\tPassword  = " + resultset.getString(5));

	    		 }
			 }  		 
    	 }	
	}

	
	
	
	public static void updateCustomer(String name, String email, int id) throws SQLException {
		
		 String JdbcURL = "jdbc:mysql://localhost:3306/hotel";
		 String Username = "root";
		 String password = "1511@#sU";
		 Connection con = null;

		 con = DriverManager.getConnection(JdbcURL, Username, password);
		 
//		 String str = "update customer set name=?, email=? where id = ?";
		 
		 String str = "update customer set email=? where id = ?";
	   	 
		 try(PreparedStatement statment = con.prepareStatement(str)){
			 
		   	 statment.setString(1, email);
		   	 statment.setLong(2, id);
		   	 
//		   	 statment.setString(1, "Joe");
//		   	 statment.setString(2, "joe@123.com");
//		   	 statment.setLong(3, 4);
		   	 
		   	 int update = statment.executeUpdate();
		   	 
		   	 if(update > 0) {
		   		 System.out.println("An existing user was updated successfully!");
		   	 }else {
		   		 System.out.println("Failed to update");
		   	 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 } 	   	 
	}
	
	
	
	
	
	
//	public static void addCustomer(int id, String name, String email, String phone_num, String username, String pass) throws SQLException {
		
	public static void addCustomer(int id, String name, String email, String pay_method, String amount, String date) throws SQLException {
		
		 String JdbcURL = "jdbc:mysql://localhost:3306/online_food_delivery";
		 String Username = "root";
		 String password = "1511@#sU";
		 Connection con = null;

		 con = DriverManager.getConnection(JdbcURL, Username, password);
		 
		 int user_ID = id;
    	 String Name = name;
    	 String Email = email;
    	 String Method = pay_method;
    	 String Amount = amount;
    	 String Date = date ;
    	 
    	 String sql = "insert into payment(id, name, email, paymentMethod, amount, date) values(?,?,?,?,?,?)";
    	 
    	 try(PreparedStatement pst = con.prepareStatement(sql)){
    		 pst.setLong(1, user_ID);
        	 pst.setString(2, Name);
        	 pst.setString(3, Email);
        	 pst.setString(4, Method);
        	 pst.setString(5, Amount);
        	 pst.setString(6, Date);
        	 
        	 
//        	 pst.setString(4, Phone);
//        	 pst.setString(5, userName);
//        	 pst.setString(6, Pass);
        	 
        	 int i = pst.executeUpdate();
        	 
        	 if(i != 0) {
        		 System.out.println("added");
        	 }else {
        		 System.out.println("Error!");
        	 }
    		 
    	 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	
	
	
	public static void removeCustomer(int id) throws SQLException {
		 String JdbcURL = "jdbc:mysql://localhost:3306/hotel";
		 String Username = "root";
		 String password = "1511@#sU";
		 Connection con = null;

		 con = DriverManager.getConnection(JdbcURL, Username, password);
		
		 int ID = id;
		 
		 String str = "delete from customer where id=?";
		 
		 try(PreparedStatement pst = con.prepareStatement(str)){
			 
			 pst.setLong(1, ID);
			 
			 int x = pst.executeUpdate();
        	 
        	 if(x != 0) {
        		 System.out.println("Successfully deleted\r");

        	 }else {
        		 System.out.println("Error!");
        	 }
        	 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
}
