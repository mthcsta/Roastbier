package com.roastbier.roastbier;

import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;


public class OnInitServer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        // popula as variaveis de ambiente
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

        // inicia conexao com o banco
        try {
            Conexao.GetConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        Conexao.DestroyConnection();
    }
}
