<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="D:\\admin.png"; center:center; background-size:cover; >
<h3><img src="D://logo1.jpg" alt="logo" width="40px" />MaryGiri</h3>
<div id="menu">
<ul>
<li><a href="#">Home</a></li>
<li><a href="doctprofile.java">Doctor Profile</a></li>
<li><a href="#">View Patient Details</a></li>
<li><a href="#">Doctor Reply</a></li>
<li><a href="#">Logout</a></li>
</ul>
</div>
 <%
 String uname=(String) session.getAttribute("uname");
 System.out.println(uname);
 %>
   
</body>

</html>