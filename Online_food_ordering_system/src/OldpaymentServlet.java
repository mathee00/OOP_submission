import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/OldpaymentServlet"})
public class OldpaymentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//Inputs that are given in payment.jsp will be taken into paymentServlet.java (this) file using the following commands
//		String cname = request.getParameter("custname");
		String firstname = request.getParameter("user");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String Payed_date = request.getParameter("date");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		
		String nextURL = "/paymentHistory.jsp";
		
		session.setAttribute("user", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("email", email);
		session.setAttribute("date", Payed_date);
		session.setAttribute("method", method);
		session.setAttribute("amount", amount);
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String JdbcURL = "jdbc:mysql://localhost:3306/online_food_delivery";
			String Username = "root";
			String password = "1511@#sU";
			

			 try(Connection con = DriverManager.getConnection(JdbcURL, Username, password)) {

				 String sql = "insert into payment(id, name, email, paymentMethod, amount, date) values(?,?,?,?,?,?)";
			   	 
				 try(PreparedStatement pst = con.prepareStatement(sql)){
			   		 pst.setLong(1, 4);
			       	 pst.setString(2, firstname);
			       	 pst.setString(3, email);
			       	 pst.setString(4, method);
			       	 pst.setString(5, amount);
			       	 pst.setString(6, Payed_date);
		       	 
			       	 int i = pst.executeUpdate();
		       	 
			       	 if(i != 0) {
			       		 System.out.println("added");
			       	 }else {
			       		 System.out.println("Error!");
			       	 }
		   		 
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
				
				
			 } catch (SQLException e1) {
				e1.printStackTrace();
			 }
			 
			 getServletContext().getRequestDispatcher(nextURL).forward(request, response); 
			 
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	
	}
}
