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

    
    public void novo() throws Exception{
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `pedidos` "
                    + "(data_emissao, data_entrega, valor_frete, cliente_id)"
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
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public void atualizar() throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("UPDATE `pedidos` "
            + "SET numero = ?, data_emissao = ?, data_entrega = ?, valor_frete = ?, cliente_id = ? "
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
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static Usuario[] Listar(String search) throws Exception {
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
                        Date.parse(rs.getString("data_nascimento")),
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

    public static boolean Deletar(String[] ids) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("DELETE FROM pedidos WHERE numero IN (");
            for (int quantidade = ids.length - 1; quantidade > 0; quantidade--) {
                sqlBuilder.append("?,");
            }
            sqlBuilder.append("?)");

            conexao = new Conexao().getConexao();
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
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

}
