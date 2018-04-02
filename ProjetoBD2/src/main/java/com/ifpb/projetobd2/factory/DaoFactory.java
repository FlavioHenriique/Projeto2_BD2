package com.ifpb.projetobd2.factory;

import com.ifpb.projetobd2.dao.TopicoDaoMongo;

public class DaoFactory {

    public static final int DAO_MYSQL = 0;

    public static DaoFactoryIF createFactory(int tipo) {
        
        switch (tipo) {
            case 0: {
                return new DaoFactoryMYSQL();
            }
           
        }
        return null;
    }
}
