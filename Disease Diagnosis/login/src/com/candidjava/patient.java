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

	public class patient extends HttpServlet{
		protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
			try {
	        	Connection con=new Connection();
	        	Transaction tx = con.graphDb.beginTx();
                 Label label=Label.label

}
	}