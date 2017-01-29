package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessServices.Account;
import businessServices.UserCheck;

@WebServlet("/NewAccount")
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String uId=request.getParameter("UserId");
          try
          {
             boolean b= UserCheck.check(uId);
             if(b==false)
             {
            	 String uName,pass;
            	 uName=request.getParameter("UserName");
            	 pass=request.getParameter("Password");
            	 Account.CreateAccount(uId,uName,pass);
            	 response.sendRedirect("CreateSucess.jsp");
             }
             else
             {
            	 response.sendRedirect("CreateError.jsp");
             }
          }
          catch(Exception e)
          {
        	  response.sendError(401,"Account Creation Failed");
          }
	}

}
