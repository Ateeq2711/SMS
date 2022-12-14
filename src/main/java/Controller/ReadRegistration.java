package Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Requirements_Impl;


@WebServlet("/listall")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			Requirements_Impl db =new Requirements_Impl();
			db.connection();
			ResultSet result = db.ListAllRegistration();
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/ListAll.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
