package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Requirements_Impl;

@WebServlet("/registrationcontroller")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registrationForm.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");
			
			Requirements_Impl db =new Requirements_Impl();
			db.connection();
			db.saveRegistration(name, email, city, phone);
			
			request.setAttribute("msg", "record saves...!");
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registrationForm.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		}
			
		}
			
		
		


