package com.ifpb.projetobd2.dao;

import com.ifpb.projetobd2.factory.ConFactoryMongo;
import com.ifpb.projetobd2.modelo.Topico;
import com.ifpb.projetobd2.modelo.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.ne;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

public class TopicoDaoMongo {

    private MongoCollection conn;

    public TopicoDaoMongo() {

        conn = ConFactoryMongo.getCollection();
    }

    public void salvar(Topico topico) {

        conn.insertOne(topico);
    }

    public List<Topico> buscar(String email) {

        MongoCursor cursor = conn.find(new BasicDBObject("usuario", email))
                .sort(descending("data")).iterator();
        List<Topico> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            Topico t = (Topico) cursor.next();
            lista.add(t);
        }
        return lista;
    }

    public List<Topico> topicosUsuarios(String email) {

        MongoCursor cursor = conn.find(new BasicDBObject("usuario", 
           (new BasicDBObject("$ne", email)))).sort(descending("data")).iterator();

        List<Topico> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            Topico t = (Topico) cursor.next();
            lista.add(t);
        }
        return lista;
    }

    public List<Topico> buscarTecnologia(String tecnologia) {

        BasicDBObject query = new BasicDBObject();
        query.append("categoria", tecnologia);

        MongoCursor cursor = conn.find(query).iterator();

        List<Topico> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            Topico t = (Topico) cursor.next();
            lista.add(t);
        }
        return lista;

    }
}
