package br.senai.sc.livros.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/editora";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection connectionBD() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("A conexão com o banco de dados falhou", e);
        }
    }
}
