package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;

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
}
