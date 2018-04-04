package com.ifpb.projetobd2.factory;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class ConFactoryNeo4j {

    public static GraphDatabaseService getDB() {
        GraphDatabaseFactory factory = new GraphDatabaseFactory();
        GraphDatabaseService db = factory.newEmbeddedDatabase(new File("graph.db"));
        
        return db;
    }
}
