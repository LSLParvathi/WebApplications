<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
            <title>welcome page</title>
            <link rel="stylesheet" href="../css/welcome.css" type="text/css">
    </head>
         <body >
         <%
         String s =  request.getParameter("user");
         String temp = null;
         Cookie ck[] = request.getCookies();
         for(Cookie c : ck)
         {
        	 if(c.getName().equals("us"))
        		   temp = s; 
         }
          
         %> 
         <h2 align="center"> Welcome <%=s%></h2>  
         <form action="logout"> 
          <%
      	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
               if(session.getAttribute("username") == null)
               {
            	  response.sendRedirect("login.jsp"); 
               }
             %>
          <table border="1">
          <tr>
          	<th>Name</th>
          	<th>Mail</th>
          	<th>Phone</th>
          </tr> 
               <%  
                      String url = "jdbc:mysql://localhost:3306/users";
       		          String e1  = "root";
       		          String e2  = "12";
       		  
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con = DriverManager.getConnection(url,e1,e2);
  			             
               		String val=(String)request.getAttribute("check2");
               		if(val.equals("no"))
               		{
               			String n=(String)request.getAttribute("name");
               			String p=(String)request.getAttribute("pass");
               		    String sql = "select * from details where name=? and pass=?";
               			PreparedStatement ps = con.prepareStatement(sql);
               			ps.setString(1, n);
               			ps.setString(2, p);
               			
               		    ResultSet rs = ps.executeQuery();
               		
               		    while(rs.next())
               		    {
               		    %>
               		    <tr>
               		    <td><%= rs.getString("name")%></td>
               		     <td><%= rs.getString("email")%></td>
               		     <td><%= rs.getString("phone") %></td>
               		    </tr>
               		    <% }
                  		 
                  		} 
               		   
               		else
               		{
               			String sql = "select * from details";
               			PreparedStatement ps = con.prepareStatement(sql);  
               		    ResultSet rs = ps.executeQuery();
               		 while(rs.next())
            		    {
            		    %>
            		    <tr>
            		       <td><%= rs.getString("name")%></td>
            		       <td><%= rs.getString("email")%></td>
            		       <td><%= rs.getString("phone") %></td>
            		    </tr>
            		    <% }
               		}%>
               		
       		    
       		  </table>
               <br><br>
               <div align="center"> 
               <input type="submit" value="logout" >
               </div>	
               </form> 
         </body>
</html>