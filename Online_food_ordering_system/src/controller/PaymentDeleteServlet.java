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

@WebServlet(urlPatterns = {"/PaymentDeleteServlet"})
public class PaymentDeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String nextURL = "/error.jsp";
		
		try(Connection con = DbConnection.getConnection()) {
			
			String str = "delete from payment where id=?;";
			long cId = 0;
			
			try(Statement state = con.createStatement()){
				try(ResultSet resultset= state.executeQuery("select max(id) from payment")){
					while(resultset.next()) {
						cId = Long.parseLong(resultset.getString(1));		
					}
				}
				
			}
			
			
			try(PreparedStatement pst = con.prepareStatement(str)){
				
				pst.setLong(1, cId);
				
				int j = pst.executeUpdate();
		       	 
		       	 if(j != 0) {
		       		 System.out.println("Successfully Removed!");
		       		 
		       		 nextURL = "/deleteSaved.jsp";
	 
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
