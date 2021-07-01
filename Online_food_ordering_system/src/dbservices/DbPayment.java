package dbservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Payment;

public class DbPayment {
	
	

	public static int createPayment(Connection con, Payment payment) throws SQLException {
		
		String sql = "insert into payment(id, name, email, paymentMethod, amount, date) values(?,?,?,?,?,?)";
		long currentId = 0;
		
		
		Statement state = con.createStatement();
		
				try(ResultSet resultset= state.executeQuery("select max(id) from payment")){
					while(resultset.next()) {
						currentId = Long.parseLong(resultset.getString(1));		
					}
				}
		
				try(PreparedStatement pst = con.prepareStatement(sql)){
					
					pst.setLong(1, currentId+1);
			       	pst.setString(2, payment.getName());
			       	pst.setString(3, payment.getEmail());
			       	pst.setString(4, payment.getPaymentMethod());
			       	pst.setString(5, payment.getAmount());
			       	pst.setString(6, payment.getDate());
		      	 
			       	 int i = pst.executeUpdate();
			       	 
			       	 return i;
				}
						
		
	}
}
