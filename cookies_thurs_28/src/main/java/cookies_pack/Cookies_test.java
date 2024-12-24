package cookies_pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cookies_test
 */
@WebServlet("/login")
public class Cookies_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies_test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId =request.getParameter("emailid");
		String password = request.getParameter("password");
		String checkstatus = request.getParameter("remb");
	PrintWriter out = response.getWriter();
//		out.println(emailId +password + checkstatus);
		if (emailId.equals("p@gmail.com") && password.equals("1234")) {
			if (checkstatus != null) {
				Cookie ck= new Cookie("loginstatus", "true");
				ck.setMaxAge(60*60*24*365);
				
				response.addCookie(ck);
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/profile");
			rd.forward(request, response);
		}
		else {
			out.println("wrong id or password");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			
		}
		
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
