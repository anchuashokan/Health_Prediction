
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

public class Addisease extends HttpServlet{
        	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        		String symp=request.getParameter("txts");
        		String dis=request.getParameter("txtd");
                System.out.println(symp);
                System.out.println(dis);
        	try {
        	Connection con=new Connection();
        	Transaction tx = con.graphDb.beginTx();
        	ExecutionResult qry1,qry2,qry3,qry4,qry5;
        	HashMap <String, Object> sym= new HashMap <String,Object>();
        	sym.put("symptom",symp);
        	sym.put("disease",dis);
			
        	qry1= con.engine.execute("merge(b:dis_name{name:{disease}}) return b",sym);
        	System.out.println(qry1.dumpToString());
        	qry2= con.engine.execute("merge(c:symptoms{name:{symptom}}) return c",sym);
        	System.out.println(qry2.dumpToString());
        	qry3= con.engine.execute("match(a:dis{name : 'Diseases'}),(b:dis_name{name : {disease}}) merge(a)-[:DISEASES]->(b)",sym);
        	System.out.println(qry3.dumpToString());
        	qry4= con.engine.execute("match(b:dis_name{name : {disease}}),(c:symptoms{name : {symptom}}) merge(b)-[:SYMPTOMS]->(c)",sym);
        	System.out.println(qry4.dumpToString());
        	tx.success();
        	tx.finish();
        	tx.close();
        	response.sendRedirect("Adminpage.html");
        	con.graphDb.shutdown();
        	    }
        	catch(Exception e) {
        		e.printStackTrace();
        		System.out.println("unable to connect to database");
        	}
        	
        	}
        
}
        

