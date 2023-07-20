package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.models.Cliente;
import com.roastbier.roastbier.models.Pedido;
import com.roastbier.roastbier.models.Produto;
import com.roastbier.roastbier.models.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Logado()
@WebServlet(name = "DeletarControllerServlet", value = "/delete")
public class DeletarControllerServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("m");
        String[] delete = request.getParameterValues("delete[]");

        try {
            getListByModel(model, delete);
            request.setAttribute("message", "Delete successful!");
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
            case "client": return Cliente.Deletar(ids);
            case "product": return Produto.Deletar(ids);
            case "order": return Pedido.Deletar(ids);
            default: throw new Exception("Model not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
