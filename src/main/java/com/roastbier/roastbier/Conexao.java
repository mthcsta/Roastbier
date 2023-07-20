package com.roastbier.roastbier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection;

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

    public Connection getConexao() {
        try {
            if (connection == null || connection.isClosed()) {
                startConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void destroyConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
