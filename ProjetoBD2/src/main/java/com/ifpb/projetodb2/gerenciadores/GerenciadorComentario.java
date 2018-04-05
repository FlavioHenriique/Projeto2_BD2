package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.ComentarioDaoNeo4j;
import com.ifpb.projetobd2.modelo.Comentario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorComentario {

    public ComentarioDaoNeo4j dao;

    public GerenciadorComentario() {

        dao = new ComentarioDaoNeo4j();
    }

    public void salvar(String idTopico, Comentario c) {
        dao.salvar(c, idTopico);
    }

    public List<Comentario> buscar(String id) {

        try {
            return dao.buscar(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
