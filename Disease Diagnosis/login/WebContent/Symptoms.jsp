
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <label>No.of Symptoms</label>-->
<!-- <input type="text" name="txtnum"><br>-->
<label>Enter your Symptoms</label>
 <input type="text" name="txtsymp">
<button type="button" onclick="addFunction()">+</button><br>
<script>
function addFunction() {
		var x = document.createElement("INPUT");
    x.setAttribute("type", "text"); 
    x.setAttribute("name" ,"txtsymb")
    document.body.appendChild(x);
	
}
</script>
<script>
function actionFunc()
{
	String cName = (String)request.getParameter("txtsymb");

if ( cName == null) {
   out.print("parameter is missing ");
}
else {
out.print(" Name is: " + cName );       
}
	}
  </script>

<button type="button" onClick="actionFunc()">Predict My Disease</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 </body>
    </html>
