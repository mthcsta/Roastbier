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

@WebServlet(name = "ListarAjaxControllerServlet", value = "/ajax/list")
public class ListarAjaxControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("m");
        String search = request.getParameter("search[value]");
        int draw = Integer.parseInt(request.getParameter("draw"));

        try {
            Object[] list = getListByModel(model, search);

            ObjectMapper mapper = new ObjectMapper();
            DatatableSearchFormat k = DatatableSearchFormat.of(list, list.length, list.length, draw);
            String json = mapper.writeValueAsString(k);

            response.setContentType("application/json");
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object[] getListByModel(String model, String search) throws Exception {
        switch (model) {
            case "users":
                return Usuario.Listar(search);
            case "clients":
                return Cliente.Listar(search);
            case "products":
                return Produto.Listar(search);
            case "orders":
                return Pedido.Listar(search);
            default:
                throw new Exception("Model not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
