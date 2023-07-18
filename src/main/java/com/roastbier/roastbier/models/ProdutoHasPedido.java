package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class ProdutoHasPedido {
    private int produtoId;
    private int pedidoNumero;
    private int quantidade;
    private float precoUnitario;
    private String unidade;

     public ProdutoHasPedido(int produtoId, int pedidoNumero, int quantidade, float precoUnitario, String unidade) {
        this.produtoId = produtoId;
        this.pedidoNumero = pedidoNumero;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
    }

        // Getters
        public int getProdutoId() {
            return produtoId;
        }
    
        public int getPedidoNumero() {
            return pedidoNumero;
        }
    
        public int getQuantidade() {
            return quantidade;
        }
    
        public float getPrecoUnitario() {
            return precoUnitario;
        }
    
        public String getUnidade() {
            return unidade;
        }
    
        // Setters
        public void setProdutoId(int produtoId) {
            this.produtoId = produtoId;
        }
    
        public void setPedidoNumero(int pedidoNumero) {
            this.pedidoNumero = pedidoNumero;
        }
    
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    
        public void setPrecoUnitario(float precoUnitario) {
            this.precoUnitario = precoUnitario;
        }
    
        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }

    public void novo() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `Produtos_has_Pedidos` "
                    + "(produto_id, pedido_numero, quantidade, preco_unitario, unidade)"
                    + "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, this.produtoId);
            preparedStatement.setInt(2, this.pedidoNumero);
            preparedStatement.setInt(3, this.quantidade);
            preparedStatement.setFloat(4, this.precoUnitario);
            preparedStatement.setString(5, this.unidade);

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
}
