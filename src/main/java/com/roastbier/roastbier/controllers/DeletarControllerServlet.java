package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.models.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletarControllerServlet", value = "/deletar")
public class DeletarControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String[] delete = request.getParameterValues("delete[]");

        try {
            System.out.println("MMMM");
            getListByModel(model, delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().print("DELETADO");

    }

    private boolean getListByModel(String model, String[] ids) throws Exception {
        switch (model) {
            case "user": return Usuario.Deletar(ids);
            case "cliente": return Usuario.Deletar(ids);
            case "produto": return Usuario.Deletar(ids);
            case "pedido": return Usuario.Deletar(ids);
            default: throw new Exception("Model not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
