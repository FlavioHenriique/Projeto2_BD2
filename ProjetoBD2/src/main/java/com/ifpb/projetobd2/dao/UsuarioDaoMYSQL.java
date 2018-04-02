package com.ifpb.projetobd2.dao;

import com.ifpb.projetobd2.factory.ConFactoryMYSQL;
import com.ifpb.projetobd2.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDaoMYSQL {

    private Connection conn;

    public UsuarioDaoMYSQL() throws ClassNotFoundException, SQLException {

    }

    public boolean salvar(Usuario u) throws SQLException, ClassNotFoundException {

        conn = ConFactoryMYSQL.getConnection();
       
        String sql = "INSERT INTO usuario (nome,email,senha) VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.execute();
        stmt.close();
        conn.close();
        return true;
    }

    public Usuario buscar(String email) throws SQLException, ClassNotFoundException {

        conn = ConFactoryMYSQL.getConnection();

        String sql = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));

            stmt.close();
            conn.close();
            return usuario;
        }
        stmt.close();
        conn.close();
        return null;
    }

    public boolean autenticar(String email, String senha) throws ClassNotFoundException, SQLException {

        conn = ConFactoryMYSQL.getConnection();
        String sql = "SELECT email FROM usuario WHERE email = ? AND senha = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        if (stmt.executeQuery().next()) {

            stmt.close();
            conn.close();
            return true;
        }
        stmt.close();
        conn.close();
        return false;
    }
}
