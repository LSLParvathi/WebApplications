package com.model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 
@WebListener("/Resources/jsp/login")
public class ListenersCount implements HttpSessionListener { 
	
	ServletContext cnt = null;
	
	static int UsersCount = 0,CurrentUsers =0;
  
    public void sessionCreated(HttpSessionEvent event)  
    { 
    	 
    	UsersCount++;
    	CurrentUsers++;
    	
    	cnt =  event.getSession().getServletContext();
    	
    	cnt.setAttribute("userscount", UsersCount);
    	cnt.setAttribute("currentusers", CurrentUsers);
    	
     }

	 
    public void sessionDestroyed(HttpSessionEvent arg0) 
    { 
    	CurrentUsers--;
    	cnt.setAttribute("currentusers", CurrentUsers);
     }


	 
	
}
