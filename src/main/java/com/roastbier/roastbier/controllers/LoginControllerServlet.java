package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.models.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", value = "/login")
public class LoginControllerServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuario user = Usuario.autenticar(request.getParameter("username"), request.getParameter("password"));

            response.setContentType("application/json");

            if (user == null) {
                response.getWriter().print("{ \"success\": 0, \"message\": \"Username or password invalid\" }");
                return;
            }

            request.getSession().setAttribute("nome", user.getNome());
            request.getSession().setAttribute("cpf", user.getCpf());

            response.getWriter().print("{ \"success\": 1, \"message\": \"Sign in with success\" }");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
