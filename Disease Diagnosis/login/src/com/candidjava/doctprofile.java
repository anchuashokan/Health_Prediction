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
    import com.candidjava.LoginController;
	public class doctprofile extends HttpServlet{
		protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session=request.getSession(true);
		      String uname= (String) session.getAttribute("uname");  
		       String pass=(String) session.getAttribute("pass"); 
		       System.out.println(uname);
		       System.out.println(pass);
		      	try {
    	Connection con=new Connection();
    	Transaction tx = con.graphDb.beginTx();
    	ExecutionResult qry1,qry2,qry3,qry4,qry5;
    	HashMap <String, Object> depart= new HashMap <String,Object>();
    	depart.put("un",uname);
    	depart.put("pass", pass);
        qry1= con.engine.execute("match(u:doc_name)-[r:DOCT_CRED]->(c:cred{uname:{un},pass:{pass}}) return u",depart);
    	System.out.println(qry1.dumpToString());
    	
    	tx.success();
    	tx.finish();
    	tx.close();
    	
    	con.graphDb.shutdown();
    	response.sendRedirect("Doctorprof.jsp");
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("unable to connect to database");
    	}
    	
    	}
    
}

	
