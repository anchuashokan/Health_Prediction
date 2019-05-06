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

public class doctorregis extends HttpServlet{
        	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        		String N=request.getParameter("name");
        		String D=request.getParameter("dob");
        		String G=request.getParameter("gender");
        		String Q=request.getParameter("quali");
        		String DE=request.getParameter("dept");
        		String DOC=request.getParameter("did");
        		String PH=request.getParameter("ph");
        		String EM=request.getParameter("email");
        		String UN=request.getParameter("uname");
        		String PA=request.getParameter("pass");
        
        	try {
        	Connection con=new Connection();
        	Transaction tx = con.graphDb.beginTx();
        	ExecutionResult qry4,qry5,qry6,qry7,qry8,qry9;
        	HashMap <String, Object> doc= new HashMap <String,Object>();
        	doc.put("a",N);
        	doc.put("b",D);
        	doc.put("c",G);
        	doc.put("d",Q);
        	doc.put("e",DE);
        	doc.put("f",DOC);
        	doc.put("g",PH);
        	doc.put("h",EM);
        	doc.put("i",UN);
        	doc.put("j",PA);
			
        	qry4= con.engine.execute("merge(t:doc_name{name:{a},dateobirth:{b},gender:{c},qualification:{d},doctor_id:{f},phone:{g},email:{h}})",doc);
        	System.out.println(qry4.dumpToString());
        	qry5= con.engine.execute("match(q:doct{name:'doctor'}), (t:doc_name{name:{a},dateobirth:{b},gender:{c},qualification:{d},doctor_id:{f},phone:{g},email:{h}})  merge(q)-[:DOCTOR]->(t)",doc);
        	qry6= con.engine.execute("merge(u:dept_name{name:{e}})",doc);
        	
        	qry7= con.engine.execute("match(r:dept{name:'department'}), (u:dept_name{name:{e}}) merge(r)-[:DEPARTMENT]->(u)",doc);
        	qry9= con.engine.execute("merge(c:cred{uname:{i},pass:{j}})",doc);
        	qry8= con.engine.execute("match(t:doc_name{name:{a},dateobirth:{b},gender:{c},qualification:{d},doctor_id:{f},phone:{g},email:{h}}),(c:cred{uname:{i},pass:{j}}) merge(t)-[:DOCT_CRED]->(c)",doc);
        	System.out.println(qry8.dumpToString());
        	tx.success();
        	tx.finish();
        	tx.close();
        	response.sendRedirect("doctorpage.html");
        	con.graphDb.shutdown();
        	    }
        	catch(Exception e) {
        		e.printStackTrace();
        		System.out.println("unable to connect to database");
        	}
        	
        	}
        
}
        
