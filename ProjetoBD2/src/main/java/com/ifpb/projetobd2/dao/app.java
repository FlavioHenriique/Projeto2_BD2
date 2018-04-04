package com.ifpb.projetobd2.dao;

import com.ifpb.projetobd2.modelo.Comentario;
import com.ifpb.projetobd2.modelo.Topico;
import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

public class app {

    public static void main(String[] args) {

        ComentarioDaoNeo4j dao = new ComentarioDaoNeo4j();

        Comentario c = new Comentario();
        c.setData(LocalDate.now());
        c.setTexto("relacionamentos");

        Topico t = new Topico();
        t.setId(new ObjectId());

//        dao.salvar(c, t.getId());

        ObjectId id = t.getId();
        
        List<Comentario> lista = dao.buscar("5ac50b0371761a5725adb270");

        for (Comentario comentario : lista) {
            System.out.println(comentario.toString());
        }
        
        
    }
}
