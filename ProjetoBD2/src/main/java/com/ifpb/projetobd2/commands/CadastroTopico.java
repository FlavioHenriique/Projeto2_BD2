package com.ifpb.projetobd2.commands;

import com.ifpb.projetobd2.modelo.Topico;
import com.ifpb.projetobd2.modelo.Usuario;
import com.ifpb.projetodb2.gerenciadores.GerenciadorTopico;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroTopico implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            
        Usuario atual = (Usuario) request.getSession().getAttribute("usuario");
        
        Topico t = new Topico();
        t.setCategoria(request.getParameter("categoria"));
        
        t.setConteudo(request.getParameter("conteudo"));
        t.setData(Date.valueOf(LocalDate.now()));
        t.setId(request.getParameter("id"));
        t.setTitulo(request.getParameter("tipo"));
        t.setUsuario(atual);
        GerenciadorTopico g = new GerenciadorTopico();
        g.salvar(t);
        try {
            response.sendRedirect("inicial.jsp");
        } catch (IOException ex) {
            Logger.getLogger(CadastroTopico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
