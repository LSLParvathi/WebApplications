package com.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/Resources/jsp/logout")
public class logout extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			HttpSession session = request.getSession(); 
			session.removeAttribute("username"); 
			session.invalidate();
			
			Cookie ck = new Cookie("us" ,"");
			ck.setMaxAge(0);
			response.addCookie(ck);
			
			response.sendRedirect("login.jsp");
 	}

}
