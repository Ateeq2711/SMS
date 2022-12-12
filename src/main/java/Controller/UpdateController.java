package Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Requirements_Impl;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		request.setAttribute("email", email);
		request.setAttribute("city", city);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Update.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		Requirements_Impl db=new Requirements_Impl();
		db.connection();
		db.UpdateRegistration(email, city);
		
		ResultSet result = db.ListAllRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/ListAll.jsp");
		rd.forward(request, response);
		
	}

}
