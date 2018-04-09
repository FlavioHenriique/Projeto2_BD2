package com.ifpb.projetobd2.commands;

import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaConteudo implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        GerenciadorTopico gTopico = new GerenciadorTopico();
      
        request.getSession().setAttribute("buscaTopicos",
                gTopico.buscaConteudo(request.getParameter("conteudo")));
        
        try {
            response.sendRedirect("inicial.jsp");
        } catch (IOException ex) {
            Logger.getLogger(BuscaConteudo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
