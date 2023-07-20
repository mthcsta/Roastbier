package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private Date dataEmissao;
    private Date dataEntrega;
    private Float valorFrete;
    private int clienteId;
    private Cliente cliente;
    private ProdutoHasPedido[] produtoHasPedidos;
    private ProdutoHasPedido phasp;
    private Float precoTotal;

    public Pedido(Date dataEmissao, Date dataEntrega, Float valorFrete, int clienteId) {
        this.dataEmissao = dataEmissao;
        this.dataEntrega = dataEntrega;
        this.valorFrete = valorFrete;
        this.clienteId = clienteId;
    }

    public Pedido(int numero, Date dataEmissao, Date dataEntrega, Float valorFrete, int clienteId) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataEntrega = dataEntrega;
        this.valorFrete = valorFrete;
        this.clienteId = clienteId;
    }
    public Pedido() {
        this.numero = 0;
        this.dataEmissao = null;
        this.dataEntrega = null;
        this.valorFrete = 0.0f;
        this.clienteId = 0;
    }

     // Getters
     public int getNumero() {
        return numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Float getValorFrete() {
        return valorFrete;
    }

    public int getClienteId() {
        return clienteId;
    }

    public Cliente getCliente() {
        if (cliente == null) {
            this.cliente = new Cliente(clienteId);
            this.cliente.selecionarPorId();
        }
        return cliente;
    }

    public ProdutoHasPedido[] getProdutoHasPedidos() {
        if (produtoHasPedidos == null) {
            this.produtoHasPedidos = ProdutoHasPedido.ListarPorPedido(numero);
        }
        return produtoHasPedidos;
    }

    public Float getPrecoTotal() {
        if (precoTotal == null) {
            this.precoTotal = valorFrete;
            for (ProdutoHasPedido produtoHasPedido : getProdutoHasPedidos()) {
                this.precoTotal += produtoHasPedido.getPrecoUnitario() * produtoHasPedido.getQuantidade();
            }
        }
        return precoTotal;
    }


    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setValorFrete(Float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutoHasPedidos(ProdutoHasPedido[] produtoHasPedidos) {
        this.produtoHasPedidos = produtoHasPedidos;
    }
    
    public void novo() throws Exception{
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `pedidos` "
                    + "(data_emissao, data_entrega, valor_frete, Clientes_id)"
                    + "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDate(1, this.dataEmissao);
            preparedStatement.setDate(2, this.dataEntrega);
            preparedStatement.setFloat(3, this.valorFrete);
            preparedStatement.setInt(4, this.clienteId);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.setNumero(resultSet.getInt(1));
            }
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

    public void atualizar() throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("UPDATE `pedidos` "
            + "SET data_emissao = ?, data_entrega = ?, valor_frete = ?, Clientes_id = ? "
            + "WHERE numero = ?");

            preparedStatement.setDate(1, this.dataEmissao);
            preparedStatement.setDate(2, this.dataEntrega);
            preparedStatement.setFloat(3, this.valorFrete);
            preparedStatement.setInt(4, this.clienteId);
            preparedStatement.setInt(5, this.numero);

            preparedStatement.executeUpdate();
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

    public static Pedido[] Listar(String search) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Pedido> lista = new ArrayList();

        try {
            Connection conexao = Conexao.GetConexao();
            StringBuilder sqlBuilder = new StringBuilder("select numero, data_emissao, valor_frete, data_entrega, Clientes_id from pedidos ");

            if (search != null && search.length() > 0) {
                sqlBuilder.append("WHERE numero = ?");
            }

            preparedStatement = conexao.prepareStatement(sqlBuilder.toString());

            if (search != null && search.length() > 0) {
                preparedStatement.setString(1, search);
            }

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Pedido order = new Pedido(
                    rs.getInt("numero"),
                    rs.getDate("data_emissao"),
                    rs.getDate("data_entrega"),
                    rs.getFloat("valor_frete"),
                    rs.getInt("Clientes_id")
                );
                lista.add(order);
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

        return lista.toArray(new Pedido[0]);
    }

    public static boolean Deletar(String[] ids) throws Exception {
        PreparedStatement preparedStatement = null;

        ProdutoHasPedido.Deletar(ids);

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("DELETE FROM pedidos WHERE numero IN (");
            for (int quantidade = ids.length - 1; quantidade > 0; quantidade--) {
                sqlBuilder.append("?,");
            }
            sqlBuilder.append("?)");

            Connection conexao = Conexao.GetConexao();
            preparedStatement = conexao.prepareStatement(sqlBuilder.toString());

            for (int indice = 0; indice < ids.length; indice++) {
                preparedStatement.setInt(indice + 1, Integer.parseInt(ids[indice]));
            }

            preparedStatement.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void selecionarPorId() {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Connection conexao = Conexao.GetConexao();
            preparedStatement = conexao.prepareStatement("select numero, data_emissao, valor_frete, data_entrega, Clientes_id from pedidos WHERE numero = ?");

            preparedStatement.setInt(1, this.getNumero());

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                this.setDataEmissao(rs.getDate("data_emissao"));
                this.setDataEntrega(rs.getDate("data_entrega"));
                this.setValorFrete(rs.getFloat("valor_frete"));
                this.setClienteId((rs.getInt("Clientes_id")));
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

    }

}
