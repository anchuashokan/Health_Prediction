
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

public class Addepartment extends HttpServlet{
        	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        		String di=request.getParameter("txtdis");
        		String dep=request.getParameter("txtdep");
        		System.out.println(di);
                System.out.println(dep);
        	try {
        	Connection con=new Connection();
        	Transaction tx = con.graphDb.beginTx();
        	ExecutionResult qry1,qry2,qry3,qry4,qry5;
        	HashMap <String, Object> depart= new HashMap <String,Object>();
        	depart.put("disease",di);
        	depart.put("departmnt",dep);
        	qry1=con.engine.execute("merge(p:dis_name{name:{disease}})",depart);
        	System.out.println(qry1.dumpToString());
            qry2= con.engine.execute("merge(u:dept_name{name:{departmnt}})",depart);
        	System.out.println(qry2.dumpToString());
        	qry3= con.engine.execute("match(r:dept{name:'department'}), (u:dept_name{name:{departmnt}}) merge(r)-[:DEPARTMENT]->(u)",depart);
            System.out.println(qry3.dumpToString()); 
            qry4=con.engine.execute("match(a:dis{name:'Diseases'}), (b:dis_name{name:{disease}}) merge (a)-[:DISEASES]->(b)",depart);
            System.out.println(qry4.dumpToString());
            qry5=con.engine.execute("match (b:dis_name{name:{disease}}), (u:dept_name{name:{departmnt}}) merge (b)-[:DIS_DEPT]->(u)",depart);
            System.out.println(qry5.dumpToString());
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
        

