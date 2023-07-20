package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;
import com.roastbier.roastbier.enums.UnidadeMedida;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoHasPedido {
    private int produtoId;
    private int pedidoNumero;
    private int quantidade;
    private float precoUnitario;
    private UnidadeMedida unidade;
    private Produto produto;

    public ProdutoHasPedido(int produtoId, int pedidoNumero, int quantidade, float precoUnitario, UnidadeMedida unidade) {
        this.produtoId = produtoId;
        this.pedidoNumero = pedidoNumero;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
    }

    public ProdutoHasPedido(){
        this.produtoId = 0;
        this.pedidoNumero = 0;
        this.quantidade = 0;
        this.precoUnitario = 0.0f;
        this.unidade = null;
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
    
        public UnidadeMedida getUnidade() {
            return unidade;
        }

        public Produto getProduto() {
            if (produto == null) {
                this.produto = new Produto(produtoId);
                this.produto.selecionarPorId();
            }
            return produto;
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
    
        public void setUnidade(UnidadeMedida unidade) {
            this.unidade = unidade;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

    public void novo() throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `Produtos_has_Pedidos` "
                    + "(Produtos_id, Pedidos_numero, quantidade, preco_unitario, unidade)"
                    + "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, this.produtoId);
            preparedStatement.setInt(2, this.pedidoNumero);
            preparedStatement.setInt(3, this.quantidade);
            preparedStatement.setFloat(4, this.precoUnitario);
            preparedStatement.setString(5, this.unidade.getAbreviacao());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static ProdutoHasPedido[] ListarPorPedido(int pedidoNumero) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<ProdutoHasPedido> lista = new ArrayList();

        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("select Produtos_id, Pedidos_numero, quantidade, preco_unitario, unidade from produtos_has_pedidos WHERE Pedidos_numero = ?");

            preparedStatement.setInt(1, pedidoNumero);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProdutoHasPedido productHasOrder = new ProdutoHasPedido(
                        rs.getInt("Produtos_id"),
                        rs.getInt("Pedidos_numero"),
                        rs.getInt("quantidade"),
                        rs.getFloat("preco_unitario"),
                        UnidadeMedida.getByAbreviacao(rs.getString("unidade"))
                );
                lista.add(productHasOrder);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {

            }
        }

        return lista.toArray(new ProdutoHasPedido[0]);
    }

    public void selecionarPorIdENumero() {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("select Produtos_id, Pedidos_numero, quantidade, preco_unitario, unidade from produtos_has_pedidos WHERE Pedidos_numero = ? and Produtos_id = ?");

            preparedStatement.setInt(1, this.getPedidoNumero());
            preparedStatement.setInt(2, this.getProdutoId());

            System.out.println(preparedStatement.toString());

            rs = preparedStatement.executeQuery();

            if(!rs.next()){
                return;
            }

            this.setQuantidade(rs.getInt("quantidade"));
            this.setPrecoUnitario(rs.getFloat("preco_unitario"));
            this.setUnidade(UnidadeMedida.getByAbreviacao(rs.getString("unidade")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
