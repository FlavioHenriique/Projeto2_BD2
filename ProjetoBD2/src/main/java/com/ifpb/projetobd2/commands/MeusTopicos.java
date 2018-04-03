package com.ifpb.projetobd2.commands;

import com.ifpb.projetobd2.modelo.Usuario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeusTopicos implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    
        GerenciadorTopico g = new GerenciadorTopico();
        Usuario atual = (Usuario) request.getSession().getAttribute("usuario");
        
        request.getSession().setAttribute("meusTopicos", g.buscar(atual.getEmail()));
        
        try {
            response.sendRedirect("meustopicos.jsp");
        } catch (IOException ex) {
            Logger.getLogger(MeusTopicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
