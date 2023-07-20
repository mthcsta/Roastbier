package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.models.Cliente;
import com.roastbier.roastbier.models.Pedido;
import com.roastbier.roastbier.models.Produto;
import com.roastbier.roastbier.models.Usuario;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Logado
@WebServlet(name = "ListarAjaxControllerServlet", value = "/ajax/list")
public class ListarAjaxControllerServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("m");
        String search = request.getParameter("search");

        try {
            Object[] list = getListByModel(model, search);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);

            response.setContentType("application/json");
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object[] getListByModel(String model, String search) throws Exception {
        switch (model) {
            case "user":
                return Usuario.Listar(search);
            case "client":
                return Cliente.Listar(search);
            case "product":
                return Produto.Listar(search);
            case "order":
                return Pedido.Listar(search);
            default:
                throw new Exception("Model not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
