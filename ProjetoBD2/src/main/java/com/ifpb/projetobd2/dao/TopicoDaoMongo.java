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
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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

    public Topico buscarTopico(ObjectId id) {

        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        MongoCursor cursor = conn.find(query).iterator();

        if (cursor.hasNext()) {
            Topico t = (Topico) cursor.next();
          
            return t;
        }
        return null;
    }
    
    public void deletar(ObjectId id){
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id",id);
        
        conn.deleteOne(query);
        
        ComentarioDaoNeo4j dao = new ComentarioDaoNeo4j();
        dao.deletar(id.toString());
    }
}
