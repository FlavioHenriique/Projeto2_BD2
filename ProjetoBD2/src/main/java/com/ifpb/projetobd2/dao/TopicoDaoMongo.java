package com.ifpb.projetobd2.dao;

import com.ifpb.projetobd2.factory.ConFactoryMongo;
import com.ifpb.projetobd2.modelo.Topico;
import com.mongodb.client.MongoCollection;

public class TopicoDaoMongo {

    private MongoCollection conn;

    public TopicoDaoMongo() {

        conn = ConFactoryMongo.getCollection();
    }
    
    public void salvar(Topico topico){
        
        conn.insertOne(topico);
    }
    
}
