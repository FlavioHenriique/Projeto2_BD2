package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.TopicoDaoMongo;
import com.ifpb.projetobd2.modelo.Topico;
import java.util.List;

public class GerenciadorTopico {

    private TopicoDaoMongo dao = null;

    public GerenciadorTopico() {
        dao = new TopicoDaoMongo();
    }

    public void salvar(Topico t) {
        dao.salvar(t);
    }

    public List<Topico> buscar(String email) {
        return dao.buscar(email);
    }

    public List<Topico> topicosUsuarios(String email) {
        return dao.topicosUsuarios(email);
    }

    public List<Topico> buscaTecnologia(String tecnologia) {
        return dao.buscarTecnologia(tecnologia);
    }
}
