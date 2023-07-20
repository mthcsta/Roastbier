package com.roastbier.roastbier.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println(getClass().toString());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("KKKKKKKKK");
    }

}
