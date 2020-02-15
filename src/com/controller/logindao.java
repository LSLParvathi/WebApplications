package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/logindao")
public class logindao   {
	 
	 
	public boolean check(String n,String p)
	{
		String url = "jdbc:mysql://localhost:3306/users";
		String e1 = "root";
		String e2 = "12";
		String sql = "select * from details where name=? and pass=?"; 
		
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(url,e1,e2);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1,n);
			 ps.setString(2,p);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				 return true;
			 }
		}
		 
		 catch (ClassNotFoundException | SQLException e)
		 { 
			e.printStackTrace();
		 }
		return false;
	 
		  
 	}
	
	 
	}
 
