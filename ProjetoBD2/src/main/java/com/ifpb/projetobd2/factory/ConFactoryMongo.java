package com.ifpb.projetobd2.factory;

import com.ifpb.projetobd2.modelo.Topico;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConFactoryMongo {

    public static MongoCollection getCollection() {
        
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.
                getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().
                        automatic(true).build()));

        MongoClient client = new MongoClient("localhost", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());

        MongoDatabase db = client.getDatabase("projetobd2").withCodecRegistry(pojoCodecRegistry);

        return db.getCollection("topico",Topico.class);

    }
}
