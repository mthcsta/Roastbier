package com.roastbier.roastbier.controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.protobuf.Message;
import com.mysql.cj.xdevapi.Client;
import com.roastbier.roastbier.enums.UnidadeMedida;
import com.roastbier.roastbier.models.Cliente;
import com.roastbier.roastbier.models.Pedido;
import com.roastbier.roastbier.models.Produto;
import com.roastbier.roastbier.models.ProdutoHasPedido;
import com.roastbier.roastbier.models.Usuario;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
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
            doRegisterByModel(request.getParameter("m"), request);
            request.setAttribute("message", "Registro inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", true);
            request.setAttribute("message", e.getMessage());
        } finally {
            RequestDispatcher rd=request.getRequestDispatcher("results.jsp");
            rd.forward(request, response);
        }

    }

    private boolean doRegisterByModel(String model, HttpServletRequest request) throws Exception {
        switch (model) {
            case "user":
                return userRegister(request);
            case "client":
                return clientRegister(request);
            case "product":
                return productRegister(request);
            case "order":
                return orderRegister(request);
            default:
                throw new Exception("Model not found");
        }
    }

    private boolean userRegister(HttpServletRequest request) throws Exception{

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Date data = Date.valueOf(request.getParameter("dataNascimento"));
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        Boolean whats = Boolean.parseBoolean(request.getParameter("whats"));
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
    
        Usuario user = new Usuario(cpf, nome, data, email, telefone, whats, username, senha);

        user.novo();

        return true;
    } 

    private boolean clientRegister(HttpServletRequest request) throws Exception{

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Date data = Date.valueOf(request.getParameter("dataNascimento"));
        String rg = request.getParameter("rg");
        String orgaoEmissor = request.getParameter("orgaoEmissor");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        Boolean whats = Boolean.parseBoolean(request.getParameter("whats"));
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
    
        Cliente client = new Cliente(cpf, nome, data, rg, orgaoEmissor, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep);

        client.novo();

        return true;
    } 

    private boolean productRegister(HttpServletRequest request) throws Exception{

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        UnidadeMedida unidade = UnidadeMedida.getByAbreviacao(request.getParameter("unidade"));
        float precoUnitario = Float.parseFloat(request.getParameter("precoUnitario"));
    
        Produto produto = new Produto(nome, descricao, unidade, precoUnitario);

        produto.novo();

        return true;
    } 

    private boolean orderRegister(HttpServletRequest request) throws Exception{

        Date dataEmissao = Date.valueOf(request.getParameter("dataEmissao"));
        Date dataEntrega = Date.valueOf(request.getParameter("dataEntrega"));
        Float valorFrete = Float.parseFloat(request.getParameter("valorFrete"));
        int clienteId = Integer.parseInt(request.getParameter("clientId"));
    
        Pedido pedido = new Pedido(dataEmissao, dataEntrega, valorFrete, clienteId);
        pedido.novo();

        String[] produtosId = request.getParameterValues("produtoId[]");
        String[] produtosQTD = request.getParameterValues("quantidade[]");
        String[] produtosPreco = request.getParameterValues("preco[]");
        String[] produtosUnidade = request.getParameterValues("unidade[]");

        for(int indice = 0; indice < produtosId.length; indice ++){
            ProdutoHasPedido produtoHasPedido = new ProdutoHasPedido();
            produtoHasPedido.setProdutoId(Integer.parseInt(produtosId[indice]));
            produtoHasPedido.setPedidoNumero(pedido.getNumero());
            produtoHasPedido.setQuantidade(Integer.parseInt(produtosQTD[indice]));
            produtoHasPedido.setPrecoUnitario(Float.parseFloat(produtosPreco[indice]));
            produtoHasPedido.setUnidade(UnidadeMedida.getByAbreviacao(produtosUnidade[indice]));
            produtoHasPedido.novo();
        }

        return true;
    } 
}
