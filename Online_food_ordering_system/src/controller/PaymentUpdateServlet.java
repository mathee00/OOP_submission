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
import javax.servlet.http.HttpSession;

import dbservices.DbConnection;

@WebServlet(urlPatterns = {"/PaymentUpdateServlet"})
public class PaymentUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		String userId = request.getParameter("uid");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String Payed_date = request.getParameter("pay_date");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		
		String nextURL = "/error.jsp";
		
		try(Connection con = DbConnection.getConnection()) {
			
			String str = "update payment set paymentMethod=?, amount=? where id=?;";
			long currentId = 0;
			
			try(Statement state = con.createStatement()){
				try(ResultSet resultset= state.executeQuery("select max(id) from payment")){
					while(resultset.next()) {
						currentId = Long.parseLong(resultset.getString(1));		
					}
				}
				
			}
			
			
			try(PreparedStatement pst = con.prepareStatement(str)){
				
				pst.setString(1, method);
				pst.setString(2, amount);
				pst.setLong(3, currentId);
				
				int j = pst.executeUpdate();
		       	 
		       	 if(j != 0) {
		       		 System.out.println("Successfully Updated!");
		       		 
		       		 nextURL = "/updateSaved.jsp";
		       		 
		       		 request.setAttribute("userId", currentId);
		       		 request.setAttribute("name", name);
		       		 request.setAttribute("email", email);
		       		 request.setAttribute("method", method);
		       		 request.setAttribute("amount", amount);
		       		 request.setAttribute("pay", Payed_date);
		       		 
		       		 
		       	 }else {
		       		 System.out.println("Error!");
		       	 }
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
		

		getServletContext().getRequestDispatcher(nextURL).forward(request, response);

	}

}
