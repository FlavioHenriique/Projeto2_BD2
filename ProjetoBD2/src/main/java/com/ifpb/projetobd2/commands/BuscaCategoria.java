package com.ifpb.projetobd2.commands;

import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaCategoria implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    
        GerenciadorTopico gTopico = new GerenciadorTopico();
        
        request.setAttribute("topicosCategoria", gTopico.buscaTecnologia(request.getParameter("categoria")));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(BuscaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
