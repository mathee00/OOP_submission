package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbservices.DbConnection;
import dbservices.DbPayment;
import model.Payment;

@WebServlet(urlPatterns = {"/PaymentNewServlet"})
public class PaymentNewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Payment payment = new Payment();
		payment.setName(request.getParameter("user"));
		payment.setEmail(request.getParameter("email"));
		payment.setDate(request.getParameter("date"));
		payment.setPaymentMethod(request.getParameter("method"));
		payment.setAmount(request.getParameter("amount"));
		
//		HttpSession session = request.getSession();
		
		String nextURL = "/error.jsp";
		
		try(Connection con = DbConnection.getConnection()){
			
			int i = DbPayment.createPayment(con, payment);
			
			if(i != 0) {
	       		 System.out.println("Successfully added!");
	       		 
	       		 nextURL = "/paymentSuccess.jsp";
	       		 
	       		 request.setAttribute("first_name", payment.getName());
	       		 request.setAttribute("email", payment.getEmail());
	       		 request.setAttribute("method", payment.getPaymentMethod());
	       		 request.setAttribute("amount", payment.getAmount());
	       		 request.setAttribute("pay", payment.getDate());
	       		 
	       		 
	       	 }else {
	       		 System.out.println("Error!");
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
