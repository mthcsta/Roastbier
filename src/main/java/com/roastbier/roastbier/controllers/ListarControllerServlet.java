package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.DatatableSearchFormat;
import com.roastbier.roastbier.models.Cliente;
import com.roastbier.roastbier.models.Pedido;
import com.roastbier.roastbier.models.Produto;
import com.roastbier.roastbier.models.Usuario;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarControllerServlet", value = "/list")
public class ListarControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
