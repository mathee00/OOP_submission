package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbservices.DbConnection;

@WebServlet(urlPatterns = {"/PaymentViewServlet"})
public class PaymentViewServlet extends HttpServlet{

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String nextURL = "/error.jsp";
		
		try(Connection con = DbConnection.getConnection()) {

			try(Statement statement = con.createStatement()){ 
		
				//To get the latest inserted payment details.
				try(ResultSet resultset= statement.executeQuery("select id, name, email, paymentMethod, amount, date from payment where id=(select max(id) from payment)")){
					while(resultset.next()) {
						request.setAttribute("id", resultset.getString(1));	
						request.setAttribute("name", resultset.getString(2));	
						request.setAttribute("email", resultset.getString(3));
						request.setAttribute("method", resultset.getString(4));	
						request.setAttribute("amount", resultset.getString(5));	
						request.setAttribute("date", resultset.getString(6));	
					}
					
					nextURL = "/paymentView.jsp";
				}
				
				
//				try(ResultSet resultset= statement.executeQuery("select id, name, email, paymentMethod, amount, date from payment")){
//				while(resultset.next()) {
//					request.setAttribute("id", resultset.getString(1));	
//					request.setAttribute("name", resultset.getString(2));	
//					request.setAttribute("email", resultset.getString(3));
//					request.setAttribute("method", resultset.getString(4));	
//					request.setAttribute("amount", resultset.getString(5));	
//					request.setAttribute("date", resultset.getString(6));	
//				}
//				
//				nextURL = "/paymentView.jsp";

				
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}  	 
		
		
		 getServletContext().getRequestDispatcher(nextURL).forward(request, response); 
	}

}
