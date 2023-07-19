package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate dataEmissao;
    private LocalDate dataEntrega;
    private Float valorFrete;
    private int clienteId;

    public Pedido(int numero, LocalDate dataEmissao, LocalDate dataEntrega, Float valorFrete, int clienteId) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataEntrega = dataEntrega;
        this.valorFrete = valorFrete;
        this.clienteId = clienteId;
    }

     // Getters
     public int getNumero() {
        return numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Float getValorFrete() {
        return valorFrete;
    }

    public int getClienteId() {
        return clienteId;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setValorFrete(Float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    
    public void novo() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `pedidos` "
                    + "(data_emissao, data_entrega, valor_frete, cliente_id)"
                    + "VALUES (?, ?, ?, ?)");

            preparedStatement.setDate(1, Date.valueOf(this.dataEmissao));
            preparedStatement.setDate(2, Date.valueOf(this.dataEntrega));
            preparedStatement.setFloat(3, this.valorFrete);
            preparedStatement.setInt(4, this.clienteId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("UPDATE `pedidos` "
            + "SET numero = ?, data_emissao = ?, data_entrega = ?, valor_frete = ?, cliente_id = ? "
            + "WHERE numero = ?");

            preparedStatement.setDate(1, Date.valueOf(this.dataEmissao));
            preparedStatement.setDate(2, Date.valueOf(this.dataEntrega));
            preparedStatement.setFloat(3, this.valorFrete);
            preparedStatement.setInt(4, this.clienteId);
            preparedStatement.setInt(5, this.numero);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Usuario[] Listar(String search) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList();

        try {
            conexao = new Conexao().getConexao();
            preparedStatement = conexao.prepareStatement("select cpf, nome, data_nascimento, email, telefone, whats, Username, Senha from usuarios WHERE nome LIKE CONCAT( '%',?,'%')");

            preparedStatement.setString(1, search);

            rs = preparedStatement.executeQuery();

            /*
            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        LocalDate.parse(rs.getString("data_nascimento")),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        Boolean.parseBoolean(rs.getString("whats")),
                        rs.getString("Username"),
                        rs.getString("Senha")
                );
                lista.add(user);
            }
             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {

            }
        }

        return lista.toArray(new Usuario[0]);

    }

}
