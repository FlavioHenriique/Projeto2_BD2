package com.ifpb.projetobd2.dao;

import com.ifpb.projetobd2.factory.ConFactoryNeo4j;
import com.ifpb.projetobd2.modelo.Comentario;
import com.ifpb.projetobd2.modelo.Usuario;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.Iterators;

public class ComentarioDaoNeo4j {

    private GraphDatabaseService db;

    public ComentarioDaoNeo4j() {
        db = ConFactoryNeo4j.getDB();
    }

    public void salvar(Comentario c, String idTopico) {

        try (Transaction tx = db.beginTx()) {

            Node comentario = db.createNode(Entidade.Comentario);
            Node topico = db.createNode(Entidade.Topico);

            topico.setProperty("id", idTopico);
            comentario.setProperty("texto", c.getTexto());
            comentario.setProperty("data", Date.valueOf(c.getData()).toString());
            comentario.setProperty("usuario", c.getUsuario().getEmail());
            comentario.createRelationshipTo(topico, Relacionamento.Pertence);

            tx.success();
        }
        db.shutdown();
    }

    public List<Comentario> buscar(String id) throws ClassNotFoundException, SQLException {

        List<Comentario> comentarios = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (Transaction tx = db.beginTx()) {

            Map<String, Object> map = new HashMap<>();
            map.put("id", id.toString());

            Result rs = db.execute("match (n:Comentario)-[rel:Pertence]->(n2:Topico)"
                    + "WHERE n2.id = $id return n", map);

            if (rs.hasNext()) {
                Iterator<Node> n = rs.columnAs("n");

                for (Node node : Iterators.asIterable(n)) {
                    Comentario c = new Comentario();
                    c.setData(LocalDate.parse((CharSequence) node.getProperty("data"), formatter));
                    c.setTexto(node.getProperty("texto").toString());

                    UsuarioDaoMYSQL dao = new UsuarioDaoMYSQL();
                    Usuario usuario = dao.buscar(node.getProperty("usuario").toString());

                    c.setUsuario(usuario);
                    comentarios.add(c);
                }
            }
            tx.success();
        }
        db.shutdown();
        return comentarios;
    }

    public List<Comentario> buscarTodos() {
        List<Comentario> comentarios = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (Transaction tx = db.beginTx()) {

            Result rs = db.execute("match (n:Comentario)-[rel:Pertence]->(n2:Topico) return n");

            if (rs.hasNext()) {
                Iterator<Node> n = rs.columnAs("n");

                for (Node node : Iterators.asIterable(n)) {
                    Comentario c = new Comentario();
                    c.setData(LocalDate.parse((CharSequence) node.getProperty("data"), formatter));
                    c.setTexto(node.getProperty("texto").toString());

                    comentarios.add(c);
                }
            }
            tx.success();
        }
        db.shutdown();
        return comentarios;
    }

    public void deletar(String id) {

        try (Transaction tx = db.beginTx()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            
            db.execute("match (n:Comentario)-[rel:Pertence]->(n2:Topico)"
                    + " WHERE n2.id = $id DETACH DELETE  n, n2", map);

            tx.success();
        }
        db.shutdown();
    }
}
