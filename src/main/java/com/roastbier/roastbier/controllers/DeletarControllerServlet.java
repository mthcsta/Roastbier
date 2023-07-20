package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.models.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletarControllerServlet", value = "/delete")
public class DeletarControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("m");
        String[] delete = request.getParameterValues("delete[]");

        try {
            getListByModel(model, delete);
            request.setAttribute("message", "Registros removido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", true);
            request.setAttribute("message", e.getMessage());
        } finally {
            RequestDispatcher rd=request.getRequestDispatcher("results.jsp");
            rd.forward(request, response);
        }
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
