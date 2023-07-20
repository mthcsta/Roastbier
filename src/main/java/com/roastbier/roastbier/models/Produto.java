package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;
import com.roastbier.roastbier.enums.UnidadeMedida;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id = -1;
    private String nome;
    private String descricao;
    private UnidadeMedida unidade;
    private float precoUnitario;

    public Produto(String nome, String descricao, UnidadeMedida unidade, float precoUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.precoUnitario = precoUnitario;
    }

    public Produto(int id, String nome, String descricao, UnidadeMedida unidade, float precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.precoUnitario = precoUnitario;
    }

    public Produto(int id){
        this.id = id;
    }

    public Produto(){
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.unidade = UnidadeMedida.UNIDADE;
        this.precoUnitario = 0.0f;
    }

     // Getters
     public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }

    public String getUnidadeString() {
        return unidade.getAbreviacao();
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUnidade(UnidadeMedida unidade) {
        this.unidade = unidade;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void novo() throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `produtos` "
                    + "(nome, descricao, unidade, preco_unitario)"
                    + "VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, this.nome);
            preparedStatement.setString(2, this.descricao);
            preparedStatement.setString(3, this.unidade.getAbreviacao());
            preparedStatement.setFloat(4, this.precoUnitario);

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

    public void atualizar() throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("UPDATE `produtos` "
                    + "SET nome = ?, descricao = ?, unidade = ?, preco_unitario = ? "
                    + "WHERE id = ?");

            preparedStatement.setString(1, this.nome);
            preparedStatement.setString(2, this.descricao);
            preparedStatement.setString(3, this.unidade.getAbreviacao());
            preparedStatement.setFloat(4, this.precoUnitario);
            preparedStatement.setInt(5, this.id);

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

    public void selecionarPorId() {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Connection conexao = Conexao.GetConexao();
            preparedStatement = conexao.prepareStatement("select id, nome, descricao, unidade, preco_unitario from produtos WHERE id = ?");

            preparedStatement.setInt(1, this.id);

            rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                return;
            }

            this.setNome(rs.getString("nome"));
            this.setDescricao(rs.getString("descricao"));
            this.setUnidade(UnidadeMedida.getByAbreviacao(rs.getString("unidade")));
            this.setPrecoUnitario(rs.getFloat("preco_unitario"));

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

    public static Produto[] Listar(String search) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Produto> lista = new ArrayList();

        try {
            Connection conexao = Conexao.GetConexao();
            preparedStatement = conexao.prepareStatement("select id, nome, descricao, unidade, preco_unitario from produtos WHERE nome LIKE CONCAT( '%',?,'%')");

            preparedStatement.setString(1, search);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Produto product = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        UnidadeMedida.getByAbreviacao(rs.getString("unidade")),
                        rs.getFloat("preco_unitario")
                );
                lista.add(product);
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

        return lista.toArray(new Produto[0]);

    }

    public static boolean Deletar(String[] ids) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("DELETE FROM produtos WHERE id IN (");
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
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("You cannot remove the product because it already has an order registered in the system");
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

}
