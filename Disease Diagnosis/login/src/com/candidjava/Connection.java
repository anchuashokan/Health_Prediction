package com.candidjava;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Connection {
	public GraphDatabaseService graphDb=new GraphDatabaseFactory().newEmbeddedDatabase("D:/caredb_db");
	
	public ExecutionEngine engine = new ExecutionEngine( graphDb );
}
