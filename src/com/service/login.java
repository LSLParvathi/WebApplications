package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.*;

 
@WebServlet("/Resources/jsp/login")
public class login extends HttpServlet 
{
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
  
		String n = request.getParameter("user");
		String p = request.getParameter("pass");
		
		HttpSession session = request.getSession();
			 session.setAttribute("username", n);
		
		String a = (String) request.getAttribute("check");
		
		if(a.equals("yes"))
		{
			request.setAttribute("check2","yes");
		}
		if((a.equals("no")))
		{
			request.setAttribute("check2","no");
			request.setAttribute("name",n);
			request.setAttribute("pass",p);
		}
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
		 
	}

	 

}