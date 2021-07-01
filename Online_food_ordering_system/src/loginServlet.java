import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
	//Inputs that are given in login.jsp will be taken into variables in loginServlet.java (this) file using the following commands
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		
		
		
//		PrintWriter out = response.getWriter();
//		
//		//This part is copy pasted from the login.jsp
//		out.println("<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset=\"ISO-8859-1\">\r\n"
//				+ "<title>Insert title here</title>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+ "		Username := " +uname+ "<br>"
//				+ "		Password := " +pass+ "<br>" + "\r\n"
//				+ "</body>\r\n"
//				+ "</html>"
//				
//				);
		
		
		//default next url
		String nextURL = "/error.jsp";
		
		if(uname.matches("supun") && pass.matches("123")) {
			
			
			//Setting attributes
			session.setAttribute("user", uname);
			session.setAttribute("lastname", "Suriyaarachchi");
//			request.setAttribute("customer", uname);
			
			nextURL = "/payment.jsp";
			
		}else {
			nextURL = "/login.jsp";
		}
			
			
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
			
			
			
		
		
	}
}
