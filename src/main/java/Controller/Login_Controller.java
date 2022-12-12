package Controller;

import java.io.IOException;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Requirements_Impl;


@WebServlet("/logincontroller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Requirements_Impl db =new Requirements_Impl();
		db.connection();
		
		boolean status = db.verification(email,password);
		
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
              RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registrationForm.jsp");
              rd.forward(request, response);
		}else {
			request.setAttribute("error", "Invalid Password/email !!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
