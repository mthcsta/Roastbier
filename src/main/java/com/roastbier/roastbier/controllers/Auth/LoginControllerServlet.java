package com.roastbier.roastbier.controllers.Auth;

import com.roastbier.roastbier.models.Usuario;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.map.util.JSONWrappedObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", value = "/auth/login")
public class LoginControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userCPF = Usuario.autenticar(request.getParameter("username"), request.getParameter("password"));

            response.setContentType("application/json");

            if (userCPF == null) {
                response.getWriter().print("{ \"success\": 0, \"message\": \"Username or password invalid\" }");
                return;
            }

            request.getSession().setAttribute("cpf", userCPF);

            response.getWriter().print("{ \"success\": 1, \"message\": \"Sign in with success\" }");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
