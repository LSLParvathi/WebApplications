<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Employee list</title>
<link rel="stylesheet" type="text/css" href="../css/first.css">
</head>
<body>

<form action="logout"> 
     
    <% 
    
    String url = "jdbc:mysql://localhost:3306/users";
    String u   = "root";
    String p   = "12";
     
    
	try {
		  
		 Class.forName("com.mysql.jdbc.Driver");
	     Connection con       = DriverManager.getConnection(url,u,p);
	      
	     String sql = "select * from employee limit ?,5";
	     PreparedStatement ps = con.prepareStatement(sql); 
	      String  b =   request.getParameter("pageno");
	      int a = Integer.parseInt(b);
	       
	      int t =0;
	      if(a==2)
	      {
	    	 t = 5; 
	      }
	      else if(a==3)
	      {
	    	  t = 10;
	      }
	      else  
	      {
	    	  t = 15;
	      } %>
	      <table border="1">
    <h2 align="center">Page no: <%= a %></h2><br>
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Salary</th> 
    </tr>
	      <%
	      ps.setInt( 1,t);
	     ResultSet rs         = ps.executeQuery();
		  
	     while(rs.next())
	     {
	    	 
	     %>
	     
	     <tr>
             <td><%= rs.getString("id") %></td>
             <td><%= rs.getString("name") %></td>
             <td><%= rs.getString("salary") %></td>
         </tr>
	    	 
	     <%  }
	} 
	catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	} 
    %> 
    </table>
    <br>
    <a href="/Pagination/Resourses/jsp/first.jsp">1</a> 
    <a href="/Pagination/Resourses/jsp/second.jsp?pageno=2">2</a> 
    <a href="/Pagination/Resourses/jsp/second.jsp?pageno=3">3</a> 
    <a href="/Pagination/Resourses/jsp/second.jsp?pageno=4">4</a>
    <br> <br><br>
    <input type="submit" value="logout">	
               </form>	
</body>
</html>