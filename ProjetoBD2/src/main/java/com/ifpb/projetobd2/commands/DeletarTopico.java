package com.ifpb.projetobd2.commands;

import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;

public class DeletarTopico implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    
        GerenciadorTopico gTopico = new GerenciadorTopico();
        gTopico.deletar(new ObjectId(request.getParameter("topico")));
        
        try {
            response.sendRedirect("front?command=MeusTopicos&mensagem=2");
        } catch (IOException ex) {
            Logger.getLogger(DeletarTopico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
