package com.ifpb.projetobd2.commands;

import com.ifpb.projetodb2.gerenciadores.GerenciadorUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            GerenciadorUsuario gerenciador = new GerenciadorUsuario();

            if (gerenciador.buscar(request.getParameter("email")) == null) {

                String email = request.getParameter("email");
                String nome = request.getParameter("nome");
                String senha = request.getParameter("senha");

                gerenciador.salvar(nome, email, senha);
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
