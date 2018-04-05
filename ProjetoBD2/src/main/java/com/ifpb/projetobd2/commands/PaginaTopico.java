package com.ifpb.projetobd2.commands;

import com.ifpb.projetobd2.modelo.Topico;
import com.ifpb.projetobd2.modelo.Usuario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorComentario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import com.ifpb.projetodb2.gerenciadores.GerenciadorUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;

public class PaginaTopico implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            GerenciadorUsuario gUsuario = new GerenciadorUsuario();
            GerenciadorTopico gTopico = new GerenciadorTopico();
            GerenciadorComentario gComentario = new GerenciadorComentario();
            
            
            Topico topico = gTopico.buscarTopico(new ObjectId(request.getParameter("topico")));
            Usuario autor = gUsuario.buscar(request.getParameter("usuario"));
            
            request.getSession().setAttribute("sugeridos", gTopico.buscaTecnologia(topico.getCategoria()));
            request.getSession().setAttribute("topico",topico);
            request.getSession().setAttribute("autor", autor);
            request.getSession().setAttribute("comentarios", gComentario.buscar(request.getParameter("topico")));
            
            response.sendRedirect("topico.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(PaginaTopico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaginaTopico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaginaTopico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
