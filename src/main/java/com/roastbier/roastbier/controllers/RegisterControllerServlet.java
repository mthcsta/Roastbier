package com.roastbier.roastbier.controllers;

import com.roastbier.roastbier.facades.HashFacade;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterControllerServlet", value = "/Register")
public class RegisterControllerServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.getWriter().print(
                    HashFacade.gerarHash("hehehe")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*
        try {
            Usuario usuario = new Usuario("12345679912", "Matheus", LocalDate.of(1997, 8, 20), "matheus@gmail.com", "51 91315467", true, "mamama", "1111");
            usuario.novo();
            ObjectMapper mapper = new ObjectMapper();
            String errorsJson = mapper.writeValueAsString(usuario);

            response.setContentType("application/json");
            response.getWriter().print(errorsJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }
}
