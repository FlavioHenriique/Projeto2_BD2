package com.ifpb.projetodb2.gerenciadores;

import com.ifpb.projetobd2.dao.UsuarioDaoMYSQL;
import com.ifpb.projetobd2.factory.DaoFactory;
import com.ifpb.projetobd2.factory.DaoFactoryIF;
import java.sql.SQLException;

public class GerenciadorUsuario {

    private DaoFactoryIF fabrica = null;
    private UsuarioDaoMYSQL dao = null;

    public GerenciadorUsuario() throws SQLException, ClassNotFoundException {

        fabrica = DaoFactory.createFactory(0);
        dao = fabrica.criaUsuarioDaoMYSQL();
    }
}
