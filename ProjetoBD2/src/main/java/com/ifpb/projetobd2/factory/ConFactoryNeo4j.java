package com.ifpb.projetobd2.factory;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class ConFactoryNeo4j {

    public static GraphDatabaseService getDB() {
        GraphDatabaseFactory factory = new GraphDatabaseFactory();
        GraphDatabaseService db = factory.newEmbeddedDatabase(new File("/home/flavio/ADS/4º Período/Banco de Dados II/Projeto2_BD2/ProjetoBD2/graph.db"));
      
        return db;
    }
}
