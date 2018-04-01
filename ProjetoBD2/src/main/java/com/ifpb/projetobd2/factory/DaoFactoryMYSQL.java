package com.ifpb.projetobd2.factory;

import com.ifpb.projetobd2.dao.UsuarioDaoMYSQL;
import java.sql.SQLException;

public class DaoFactoryMYSQL implements DaoFactoryIF {

    @Override
    public UsuarioDaoMYSQL criaUsuarioDaoMYSQL() throws SQLException, ClassNotFoundException {

        return new UsuarioDaoMYSQL();
    }

}
