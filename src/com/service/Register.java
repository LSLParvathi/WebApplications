package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resources/jsp/Register")
public class Register extends HttpServlet
{
 
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String n = req.getParameter("user");
		String p = req.getParameter("pass");
		String m = req.getParameter("mail");
		String l = req.getParameter("phone");
		
		String url = "jdbc:mysql://localhost:3306/users";
		String  e1 = "root";
		String  e2 = "12";
	    String sql = "insert into details values(?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con =  DriverManager.getConnection(url,e1,e2);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,n);
			ps.setString(2,p);
			ps.setString(3,m);
			ps.setString(4,l); 
			ps.executeUpdate();	
			
			con.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
 			e.printStackTrace();
		}
		 
		res.sendRedirect("login.jsp"); 
	}
}
