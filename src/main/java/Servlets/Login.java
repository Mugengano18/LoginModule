package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Employ.DbConnect;
import Employ.Employee;
import Models.LoginClass;
import database1.DatabaseConnetion;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
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
		String unameString = request.getParameter("uname");
		String passwdString = request.getParameter("psw");
		
		
		DatabaseConnetion cDatabaseConnetion = new DatabaseConnetion();
		LoginClass loginClass = new LoginClass(unameString, passwdString);
		
//		String resultString = cDatabaseConnetion.insert(loginClass);
//		response.getWriter().print(resultString);
//		unameString.equals("alice23") && passwdString.equals("psw")
		if (cDatabaseConnetion.CheckCredentials(unameString, passwdString)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", unameString);
			session.setAttribute("password", passwdString);
			
			response.sendRedirect("Welcome.jsp");
			
		}
		else {
			response.sendRedirect("LoginForm.jsp");
		}
	}

}
