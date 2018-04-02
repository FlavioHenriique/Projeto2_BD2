package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.TopicoDaoMongo;
import com.ifpb.projetobd2.modelo.Topico;

public class GerenciadorTopico {
    
    private TopicoDaoMongo dao = null;
    
    public GerenciadorTopico(){
        dao = new TopicoDaoMongo();
    }
    
    public void salvar(Topico t){
        dao.salvar(t);
    }
}
