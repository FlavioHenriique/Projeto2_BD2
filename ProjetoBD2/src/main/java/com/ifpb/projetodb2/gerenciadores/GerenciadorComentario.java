package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.ComentarioDaoNeo4j;
import com.ifpb.projetobd2.modelo.Comentario;
import java.util.List;

public class GerenciadorComentario {
    
    
    public ComentarioDaoNeo4j dao;
    
    public GerenciadorComentario(){
    
        dao = new ComentarioDaoNeo4j();
    } 
    
    public void salvar(String idTopico, Comentario c){
        dao.salvar(c, idTopico);
    }        
    
    public List<Comentario> buscar(String id){
        
        return dao.buscar(id);
    }
}