package com.roastbier.roastbier;

import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class DotenvContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }

    public void contextDestroyed(ServletContextEvent arg0) {  }
}
