<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
     <meta charset="UTF-8">
     <title>LOGIN PAGE</title>
     <link rel="stylesheet" href="../css/log.css" type="text/css">
   </head>
       <body>
           <form action="login"> 
              <div class="loginpage" align="center"> 
                 <img alt="Pic" src="../Images/Avatar.png" width="50" height="50"><br><br>
                 <input type="text" name="user" placeholder="Enter the user name"><br><br>
                 <input type="password" name="pass" placeholder="Enter the valid password"><br><br>
                 <input type="submit" value="login"> 
                 <input type="submit" value="SignUp" formaction="Register.jsp"> 
               </div>
            </form> 
       </body>
</html>