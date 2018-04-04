package com.ifpb.projetobd2.commands;

import com.ifpb.projetobd2.modelo.Comentario;
import com.ifpb.projetobd2.modelo.Topico;
import com.ifpb.projetobd2.modelo.Usuario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorComentario;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponderTopico implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        GerenciadorComentario gComentario = new GerenciadorComentario();

        Comentario c = new Comentario();
        c.setData(LocalDate.now());
        c.setTexto(request.getParameter("comentario"));
        Usuario atual = (Usuario) request.getSession().getAttribute("usuario");
        
        c.setUsuario(atual);
        
        gComentario.salvar(request.getParameter("topico"), c);

        try {
            response.sendRedirect("front?command=PaginaTopico&topico=" +
                    request.getParameter("topico"));
            
        } catch (IOException ex) {
            Logger.getLogger(ResponderTopico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
