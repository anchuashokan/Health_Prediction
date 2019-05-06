package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.neo4j.cypher.CypherException;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import scala.collection.concurrent.Map;

//private static enum LabelTypes implements Label
//{
//person,country
//}

public class demo extends HttpServlet{
	private static enum RelTypes implements RelationshipType
	{
	DIS_DEPT
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		 try (PrintWriter out = response.getWriter()) { 
		       out.println("<!DOCTYPE html>"); 
		       out.println("<html>"); 
		       out.println("<head>"); 
		       out.println("<title>Servlet StudentServlet</title>"); 
		       out.println("</head>"); 
		       out.println("<body>"); 
		//List <String>  val= new ArrayList<String>();
    		String[] val=request.getParameterValues("sec");
    		for(int i=0;i<val.length;i++) 
    			System.out.println(val[i]);
    		    ArrayList<String> sl=new ArrayList<String>(Arrays.asList(val));		
    		    try {
        	Connection con=new Connection();
        	Transaction tx = con.graphDb.beginTx();
        	ExecutionResult qry1;
        	HashMap <String, Object> depart= new HashMap <String,Object>();
        	depart.put("lis1",sl);
        	qry1=con.engine.execute("with{lis1} as names match(d:symptoms)<-[r:SYMPTOMS]-(a:dis_name) where d.name in names with a,count(distinct d) as c with max(c) as mx, {lis1} as names match (d:symptoms)<-[r:SYMPTOMS]-(a:dis_name) where d.name in names with a,count(distinct d) as c,mx with a,c where c=mx return a as disease",depart);
        	 if (qry1.hasNext()) {
 	        	
 	        	
   		      Node dis=(Node)qry1.columnAs("disease").next();
   		      System.out.println(dis.getProperty("name"));
   				Relationship rel=(Relationship) dis.getSingleRelationship(RelTypes.DIS_DEPT,Direction.OUTGOING);
   				Node dep=rel.getOtherNode(dis);
   				System.out.println(dep.getProperty("name"));
   				request.setAttribute("dis",dis.getProperty("name"));
   				request.setAttribute("d",dep.getProperty("name"));
   				request.setAttribute("s",sl);
   				out.println("hai");
   				tx.success();
   	        	tx.finish();
   	        	tx.close();
   	        	
   	        	con.graphDb.shutdown();
   	        	//response.sendRedirect("dispage.jsp");
   	        	RequestDispatcher rd =  
   		             request.getRequestDispatcher("dispage.jsp"); 
   		  
   		       // The request will be forwarded to the resource  
   		       // specified, here the resource is a JSP named, 
   		       // "stdlist.jsp" 
   		          rd.forward(request, response); 

        	 }
    		    }
   	        	catch(Exception e) {
   	        		e.printStackTrace();
   	        		System.out.println("unable to connect to database");
   	        	}
    		    
    		            out.println("</body>"); 
    		            out.println("</html>"); 
		 }
   	        	}
	
   			 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
                { 
                      processRequest(request, response); 
                } 
        	//System.out.println(qry1.dumpToString());
        	
}