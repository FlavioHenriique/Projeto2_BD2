package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.UsuarioDaoMYSQL;
import com.ifpb.projetobd2.factory.DaoFactory;
import com.ifpb.projetobd2.factory.DaoFactoryIF;
import com.ifpb.projetobd2.modelo.Usuario;
import java.sql.SQLException;

public class GerenciadorUsuario {

    private DaoFactoryIF fabrica = null;
    private UsuarioDaoMYSQL dao = null;

    public GerenciadorUsuario() throws SQLException, ClassNotFoundException {

        fabrica = DaoFactory.createFactory(0);
        dao = fabrica.criaUsuarioDaoMYSQL();
    }

    public boolean salvar(String nome, String email, String senha) throws SQLException, ClassNotFoundException {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setNome(nome);
        u.setSenha(senha);
        return dao.salvar(u);
    }
    
    public Usuario buscar(String email) throws SQLException, ClassNotFoundException{
        return dao.buscar(email);
    }
}
