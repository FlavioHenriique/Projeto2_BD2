package com.ifpb.projetobd2.factory;

import com.ifpb.projetobd2.dao.UsuarioDaoMYSQL;
import java.sql.SQLException;

public interface DaoFactoryIF {
 
    
    UsuarioDaoMYSQL criaUsuarioDaoMYSQL() throws SQLException, ClassNotFoundException;
}
