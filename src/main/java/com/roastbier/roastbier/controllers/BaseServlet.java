package com.roastbier.roastbier.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getClass().isAnnotationPresent(Logado.class) && req.getSession().getAttribute("cpf") == null) {
            resp.sendRedirect(System.getProperty("BASE_URL") + "/login");
            return;
        }
        super.service(req, resp);
    }

}
