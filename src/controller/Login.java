package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessServices.UserCheck;
import dataTransferObject.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId,pass;
		uId=request.getParameter("UserId");
		pass=request.getParameter("Password");
		try
		{
		  User u =(User) UserCheck.check(uId,pass);
		  if(u==null)
		  {
		      response.sendRedirect("Error.jsp");
		  }
		  else
		  {
			  request.setAttribute("User",u);
			  RequestDispatcher dis=request.getRequestDispatcher("LoginSuccess.jsp");
			  dis.forward(request,response);
		  }
		}
		catch(Exception e)
		{
			response.sendError(401,"Login Failed");
		}
		
	}

}
