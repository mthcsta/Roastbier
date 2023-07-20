package com.roastbier.roastbier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection;
    private static Conexao conexaoInstancia;

    public void startConnection() {
        try {
            Class.forName(System.getProperty("DB_DRIVER_CLASSNAME"));
            this.connection = DriverManager.getConnection(System.getProperty("DB_URL"), System.getProperty("DB_USER"), System.getProperty("DB_PASSWORD"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexao() throws SQLException {
        if (conexaoInstancia.getConexao().isClosed()) {
            conexaoInstancia.startConnection();
        }
        return connection;
    }

    public static Connection GetConexao() throws SQLException {
        return conexaoInstancia.getConexao();
    }

    public static Conexao GetInstancia() {
        if (conexaoInstancia == null) {
            conexaoInstancia = new Conexao();
        }
        return conexaoInstancia;
    }

    public static void DestroyConnection() {
        try {
            conexaoInstancia.getConexao().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
