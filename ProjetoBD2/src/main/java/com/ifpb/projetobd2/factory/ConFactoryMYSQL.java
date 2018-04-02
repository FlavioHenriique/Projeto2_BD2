package com.ifpb.projetobd2.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactoryMYSQL {

    private static final String url = "jdbc:mysql://localhost/projetobd2";
    private static final String user = "root";
    private static final String password = "flavio22";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
