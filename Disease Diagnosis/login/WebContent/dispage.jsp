
<%@ page import="com.candidjava.demo"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="newfile.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% 
            //request.getAttribute("s");
   String s=(String)request.getAttribute("dis");
   String p=(String)request.getAttribute("d") ; 
   ArrayList<String> st=(ArrayList<String>)request.getAttribute("s");
	//for(String symb:st) 
		//System.out.println(symb);
	     //System.out.println("<html><body>hello</body></html>");
	    // label.setText(<html>)
	     
 %>
 
</head>

<body background="D:\\admin.png"; center:center; background-size:cover; >
<h3><img src="D://logo1.jpg" alt="logo" width="40px" />MaryGiri</h3>
<div id="loginbox">
<table border="1">
  <tbody>
  <tr>
  <td>Your Entered Symptoms</td>
  <td><%= st  %></td>
  </tr>
  <tr>
  <td>Diagnosed Disease</td>
  <td><%= s %></td>
  <tr>
  <td>Concerned Department</td>
  <td><%= p %></td>
  </tr>
  </tbody>
</table>
</body>
</html>