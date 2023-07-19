package com.roastbier.roastbier.controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.protobuf.Message;
import com.roastbier.roastbier.models.Usuario;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "RegisterControllerServlet", value = "/register")
public class RegisterControllerServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            LocalDate data = LocalDate.parse(request.getParameter("data"));
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            Boolean whats = Boolean.parseBoolean(request.getParameter("whats"));
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");
    
            Usuario user = new Usuario(cpf, nome, data, email, telefone, whats, username, senha);

            user.novo();

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            RequestDispatcher rd=request.getRequestDispatcher("results.jsp");
            rd.forward(request, response);
        }

    }
}
