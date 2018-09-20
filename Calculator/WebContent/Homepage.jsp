<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.user.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #4CAF50;
}

/* .active {
    background-color: #4CAF50;
} */
</style>
</head>

<body>

<% user currentUser = (user)(session.getAttribute("currentSessionUser"));%>
 Welcome <%= currentUser.getName() %>
<ul>
  <li><a href="#home">Home</a></li>
  <li><a href="nextPage.html">calculator</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a href="#about">Logout</a></li>
</ul>

            
        
</body>
</html>