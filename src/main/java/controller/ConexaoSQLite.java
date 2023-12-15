// Script para conexão do banco de dados SQLite.

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    private static final String SQLITE_JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String SQLITE_DATABASE_URL = "jdbc:sqlite:src\\main\\resources\\eletrotech_db";

    private static Connection conn = null;

    public static Connection getConexao() throws SQLException {
        if (conn == null) {
            try {
                // Carrega o driver JDBC do SQLite na memória
                Class.forName(SQLITE_JDBC_DRIVER);

                // Estabelece a conexão com o banco de dados
                conn = DriverManager.getConnection(SQLITE_DATABASE_URL);
            } catch (ClassNotFoundException e) {
                System.err.println("Erro ao carregar o driver do SQLite: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConexao() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
