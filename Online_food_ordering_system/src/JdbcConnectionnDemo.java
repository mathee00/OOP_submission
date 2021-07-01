import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectionnDemo {

	public static void main(String[] args) {
		String JdbcURL = "jdbc:mysql://localhost:3306/hotel";
	    String Username = "root";
	    String password = "1511@#sU";
	    Connection con = null;
	    
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         //System.out.println(con.getSchema());
	         System.out.println("Connection is successful!!!!!!");
	         try(Statement statement = con.createStatement()){
	        	 
	        	 
	        	 
//	        	 //Inserting data to the table
//	        	 int user_ID = 6;
//	        	 String name = "Namal";
//	        	 String email = "nimal@yandex.com";
//	        	 String phone = "0772644686";
//	        	 String userName = "nimal96";
//	        	 String pass = "123";
//	        	 
//	        	 String sql = "insert into customer(id, name, email, phome, userName, password) values(?,?,?,?,?,?)";
//	        	 PreparedStatement pst = con.prepareStatement(sql);
////	        	                                                               //These are the column names of the customer table
////	        	 PreparedStatement pst = con.prepareStatement("insert into customer(id, name, email, phome, userName, password) values(?,?,?,?,?,?)");
//	        
//	        	 pst.setLong(1, user_ID);
//	        	 pst.setString(2, name);
//	        	 pst.setString(3, email);
//	        	 pst.setString(4, phone);
//	        	 pst.setString(5, userName);
//	        	 pst.setString(6, pass);
//	        	 
//	        	 int i = pst.executeUpdate();
//	        	 
//	        	 if(i != 0) {
//	        		 System.out.println("added");
//	        	 }else {
//	        		 System.out.println("Error!");
//	        	 }
	        	 
	        	 
	        	 
//	        	 String str = "update customer set name=?, email=? where id = ?";
//	        	 
//	        	 PreparedStatement statment = con.prepareStatement(str);
//	        	 statment.setString(1, "Joe");
//	        	 statment.setString(2, "joe@123.com");
//	        	 statment.setLong(3, 4);
//	        	 
//	        	 int update = statment.executeUpdate();
//	        	 if(update > 0) {
//	        		 System.out.println("An existing user was updated successfully!");
//	        	 }else {
//	        		 System.out.println("Failed to update");
//	        	 }
	        	 
	        	 
	        	 
	        	 //Showing the data in the customer table                (only se)
	        	 try(ResultSet resultset= statement.executeQuery("select id, name, email, phome from customer")){ 
	        		 while(resultset.next()) {
	        			 System.out.println("ID = " + resultset.getString(1) + "  Name = " + resultset.getString(2)+
	        					 			"\tEmail = " + resultset.getString(3) + "\t\t" + "Phone number = "+resultset.getString(4));
	        			

	        		 }
	        		 
	        	 }
	         }
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }

	}

}
