package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbservices.DbUser;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("password");
		
		String nextURL = "/error.jsp";
		
		HttpSession session = request.getSession();
		
		try{
			if(DbUser.isValidUser(username, userpassword)) {
				session.setAttribute("user", username);
				nextURL = "/payment.jsp";
				
			}else {
				nextURL = "/login.jsp";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}
	
}
