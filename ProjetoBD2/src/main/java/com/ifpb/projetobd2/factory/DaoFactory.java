package com.ifpb.projetobd2.factory;

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
