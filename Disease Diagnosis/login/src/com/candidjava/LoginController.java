package com.candidjava;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.neo4j.cypher.CypherException;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.*;

/**
 * Servlet implementation class LoginController
 */
@SuppressWarnings("deprecation")
public class LoginController extends HttpServlet {
	//public HttpSession session=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		System.out.println(un+";;;;;;;;;;;;;;;;;;;;;"+pw);
		// Connect to mysql and verify username password
		
		try {
		
			Connection con=new Connection();
			
		       Transaction tx = con.graphDb.beginTx();
	        ExecutionResult result,rslt,result2,result3,result4;
	        Map<String,Object> dis= new HashMap<String,Object>();
	        dis.put("u",un);
	        dis.put("p",pw);
	        String tp="";
	      result = con.engine.execute("match(c:cred) where c.uname={u} and c.pass={p} with c match ()-[ft]->(c) with c,type(ft) as tp return case when tp='CREDENT' then 'admin' when tp='DOCT_CRED' then 'doctor' else  'patient' end as type" ,dis);
	       //result = con.engine.eecute("match(c:cred) where c.uname={u} and c.pass={p} with c match ()-[ft]->(c) return c,type(ft) as tp" ,dis);
	       // System.out.println(result.dumpToString());
	        while (result.hasNext()) {
	        	
	        	
		      tp=(String)result.columnAs("type").next().toString();
		        System.out.println(tp);
				
		       HttpSession session=request.getSession();  
	       session.setAttribute("uname",un);  
	       session.setAttribute("pass",pw);  
	       session.setMaxInactiveInterval(30*60);
	       Cookie username=new Cookie("uname",un);
	       Cookie pass=new Cookie("pass",pw);
	       username.setMaxAge(30*60);
	       pass.setMaxAge(30*60);
	       response.addCookie(username);
	       response.addCookie(pass);
	        con.graphDb.shutdown();
	        if(tp.equalsIgnoreCase("admin"))
	       response.sendRedirect("Adminpage.html");
	        else if(tp.equalsIgnoreCase("doctor"))
	 	       response.sendRedirect("doctorpage.html");
	        else
	        	response.sendRedirect("Patienthome.html");
	        return;
	       }
		
		 con.graphDb.shutdown();
		 response.sendRedirect("error.html");
		    return;
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
}
		
	
		



