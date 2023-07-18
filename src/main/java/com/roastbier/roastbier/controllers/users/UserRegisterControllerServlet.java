package com.roastbier.roastbier.controllers.users;

import com.roastbier.roastbier.models.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UserRegisterControllerServlet", value = "/user/register")
public class UserRegisterControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            response.sendRedirect("error.jsp");
        }

    }
}
