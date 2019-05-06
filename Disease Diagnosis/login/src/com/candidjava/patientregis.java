package com.candidjava;
	import java.io.IOException;
	import java.util.HashMap;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.neo4j.cypher.CypherException;
	import org.neo4j.cypher.javacompat.ExecutionResult;
	import org.neo4j.graphdb.GraphDatabaseService;
	import org.neo4j.graphdb.Transaction;

	import scala.collection.concurrent.Map;

	public class patientregis extends HttpServlet{
	        	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
	        		String Name=request.getParameter("name");
	        		String Age=request.getParameter("age");
	        		String Gender=request.getParameter("gender");
	        		String Bgroup=request.getParameter("bgp");
	        		String Pnumber=request.getParameter("ph");
	        		String Email=request.getParameter("email");
	        		String Uname=request.getParameter("uname");
	        		System.out.println(Uname);
	        		String Passwd=request.getParameter("pass");
	                 System.out.println(Passwd);
	        	try {
	        	Connection con=new Connection();
	        	Transaction tx = con.graphDb.beginTx();
	        	ExecutionResult qry1,qry2,qry3,qry4,qry5;
	        	HashMap <String, Object> pat= new HashMap <String,Object> ();
	        	pat.put("nam",Name);
	        	pat.put("ag",Age);
	        	pat.put("gendr",Gender);
	        	pat.put("bgrp",Bgroup);
	        	pat.put("pno",Pnumber);
	        	pat.put("email",Email);
	        	pat.put("usrnam",Uname);
	        	pat.put("pass",Passwd);
	        	
				qry1= con.engine.execute("merge(p:patient{name:'Patient'})");
				qry2=con.engine.execute("merge(l:patientlist{name:{nam},age:{ag},gender:{gendr},bloodgroup:{bgrp},phone:{pno},email:{email}}) return l",pat);
				qry3=con.engine.execute("match(p:patient{name:'Patient'}), (l:patientlist{name:{nam},age:{ag},gender:{gendr},bloodgroup:{bgrp},phone:{pno},email:{email}}) merge(p)-[:PATIENTS]->(l)",pat);
				//System.out.println(qry3.dumpToString());
			    qry5=con.engine.execute("merge(c:cred{uname:{usrnam},pass:{pass}}) return c",pat);
				//System.out.println(qry5.dumpToString());
			    qry4=con.engine.execute("match(l:patientlist{name:{nam},age:{ag},gender:{gendr},bloodgroup:{bgrp},phone:{pno},email:{email}}), (c:cred{uname:{usrnam},pass:{pass}}) merge(l)-[:PAT_CRED]->(c)",pat);
				//System.out.println(qry4.dumpToString());
				response.sendRedirect("MainHome.html");
				tx.success();
	        	tx.finish();
	        	tx.close();
				con.graphDb.shutdown();
	        	//System.out.println("insertion successfully");
	        	 
	        	    }
	        	catch(Exception e) {
	        		e.printStackTrace();
	        		System.out.println("unable to connect to database");
	        	}
	        	
	        	}
	        
	}
	        


