package com.model;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.controller.logindao;
 
@WebFilter("/Resources/jsp/login")
public class DoFilter implements Filter {

     
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{ 
		
		String n = request.getParameter("user");
		String p = request.getParameter("pass"); 
		
		logindao d = new logindao();
		
		if(d.check(n, p) == true)
		{
			 
		
		if(n.equals("leela") && p.equals("1234"))
		{
			request.setAttribute("check","yes");
			chain.doFilter(request, response);
		}
		else
		{
			request.setAttribute("check","no");
			chain.doFilter(request, response);
		} 
	    }
		else
		{
			HttpServletResponse res=(HttpServletResponse) response;
			res.sendRedirect("login.jsp");
		}
	}

	@Override
	public void destroy() {
 		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
 		
	}

	 

}
