<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" type="text/css" href="../css/log.css">
    </head>
  <body>
        <form action="Register" >
          <div class="RegistrationPage" align="center"> 
             <img alt="Pic" src="../Images/Avatar.png" width="50" height="50"><br><br>
            <input type="text" name="user" placeholder="Enter the user name"><br><br>
            <input type="password" name="pass" placeholder="enter the valide password"><br><br>
            <input type="email" name="mail" placeholder="enter the email address"><br><br>
            <input type="tel" name="phone" Placeholder="1234567678" pattern="[0-9]{3}[0-9]{4}[0-9]{3}"><br><br>
            <input type="submit" value="submit"> 
          </div> 
        </form>
  </body>
</html>