<%@ page language="java" contentType="text/html; charset=ISO-8859-1 "
    pageEncoding="ISO-8859-1"%> 
    
    <%@ page import="com.candidjava.doctprofile"%>
    <%@ page import="com.candidjava.doctorregis" %>
    <%@ page import= "org.neo4j.cypher.javacompat.ExecutionEngine" %>
    <%@ page import="org.neo4j.graphdb.GraphDatabaseService" %>
    <%@ page import="org.neo4j.graphdb.factory.GraphDatabaseFactory" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String uname=(String) session.getAttribute("uname");
 System.out.println(uname);
 
 String pass=(String) session.getAttribute("pass"); 
 System.out.println(uname);
 System.out.println(pass);
 String s=(String)request.getAttribute("name");
// public class Connection {
		//public GraphDatabaseService graphDb=new GraphDatabaseFactory().newEmbeddedDatabase("D:/caredb_db");
		
		//public ExecutionEngine engine = new ExecutionEngine( graphDb );
//Transaction tx = graphDb.beginTx();
//ExecutionResult qry1,qry2,qry3,qry4,qry5;
//HashMap <String, Object> depart= new HashMap <String,Object>();
//depart.put("un",uname);
//depart.put("pass", pass);
//qry1= con.engine.execute("match(u:doc_name)-[r:DOCT_CRED]->(c:cred{uname:{un},pass:{pass}}) return u",depart);
//System.out.println(qry1.dumpToString());

//tx.success();
//tx.finish();
//tx.close();

//con.graphDb.shutdown();
//}
//catch(Exception e) {
//e.printStackTrace();
//System.out.println("unable to connect to database");
//}

 %>
 <table border="1">
  <tbody>
  <tr>
  <td>Name</td>
  <td><%= s  %></td>
  </tr>
  <tr>
  <!--  <td>Diagnosed Disease</td>-->
  <!--<td></td>-->
  <!--<tr>-->
  <!--<td>Concerned Department</td>-->
  <!-- <td></td>-->
  </tr>
  </tbody>
</table>
</body>
</html>