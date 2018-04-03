package com.ifpb.projetobd2.commands;

import com.ifpb.projetobd2.modelo.Usuario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Topicos implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        GerenciadorTopico gTopico = new GerenciadorTopico();
        Usuario atual = (Usuario) request.getSession().getAttribute("usuario");

        request.setAttribute("topicos", gTopico.topicosUsuarios(atual.getEmail()));
        
        try {
           RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
           dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(Topicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
