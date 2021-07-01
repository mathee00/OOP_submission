package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbservices.DbConnection;
import dbservices.DbPayment;
import model.Payment;


@WebServlet(urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		//Inputs that are given in payment.jsp will be taken into paymentServlet.java (this) file using the following commands.
		String firstname = request.getParameter("user");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String Payed_date = request.getParameter("date");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		
		String nextURL = "/error.jsp";
		
		session.setAttribute("user", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("email", email);
		session.setAttribute("date", Payed_date);
		session.setAttribute("method", method);
		session.setAttribute("amount", amount);

			 try(Connection con = DbConnection.getConnection()) {

				 String sql = "insert into payment(id, name, email, paymentMethod, amount, date) values(?,?,?,?,?,?)";
				 long currentId = 0;
				 
				 try(Statement state = con.createStatement()){
					          //below query returns the last id of the table 
						try(ResultSet resultset= state.executeQuery("select max(id) from payment")){
							while(resultset.next()) {
								currentId = Long.parseLong(resultset.getString(1));		
							}
						}
				 }
			   	 
				 try(PreparedStatement pst = con.prepareStatement(sql)){
					 
//					 System.out.println(currentId);
					 
			   		 pst.setLong(1, currentId+1);
			       	 pst.setString(2, firstname);
			       	 pst.setString(3, email);
			       	 pst.setString(4, method);
			       	 pst.setString(5, amount);
			       	 pst.setString(6, Payed_date);
		       	 
			       	 int i = pst.executeUpdate();	        
		       	 
			       	 if(i != 0) {
			       		 System.out.println("Successfully added!");
			       		 
			       		 nextURL = "/paymentSuccess.jsp";
			       		 
			       		 request.setAttribute("first_name", firstname);
			       		 request.setAttribute("email", email);
			       		 request.setAttribute("method", method);
			       		 request.setAttribute("amount", amount);
			       		 request.setAttribute("pay", Payed_date);
			       		 
			       		 
			       	 }else {
			       		 System.out.println("Error!");
			       	 }
		   		 
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
				
				
			 } catch (SQLException | ClassNotFoundException e1) {
				e1.printStackTrace();
			 }
			 
			 getServletContext().getRequestDispatcher(nextURL).forward(request, response); 

	
	}

	
}
