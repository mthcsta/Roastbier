package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id = -1;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String rg;
    private String orgaoEmissor;
    private String email;
    private String telefone;
    private Boolean whats;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Cliente(String cpf, String nome, Date dataNascimento, String rg, String orgaoEmissor,
            String email, String telefone, Boolean whats, String logradouro, String numero, String bairro,
            String cidade, String estado, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.orgaoEmissor = orgaoEmissor;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Cliente(int id, String cpf, String nome, Date dataNascimento, String rg, String orgaoEmissor,
    String email, String telefone, Boolean whats, String logradouro, String numero, String bairro,
    String cidade, String estado, String cep) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.orgaoEmissor = orgaoEmissor;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

     // Getters
     public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Boolean getWhats() {
        return whats;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setWhats(Boolean whats) {
        this.whats = whats;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void novo() throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `clientes` "
                    + "(cpf, nome, data_nascimento, rg, orgao_emissor, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, this.getCpf());
            preparedStatement.setString(2, this.getNome());
            preparedStatement.setDate(3, this.getDataNascimento());
            preparedStatement.setString(4, this.getRg());
            preparedStatement.setString(5, this.getOrgaoEmissor());
            preparedStatement.setString(6, this.getEmail());
            preparedStatement.setString(7, this.getTelefone());
            preparedStatement.setBoolean(8, this.getWhats());
            preparedStatement.setString(9, this.getLogradouro());
            preparedStatement.setString(10, this.getNumero());
            preparedStatement.setString(11, this.getBairro());
            preparedStatement.setString(12, this.getCidade());
            preparedStatement.setString(13, this.getEstado());
            preparedStatement.setString(14, this.getCep());

            preparedStatement.execute();
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

            preparedStatement = conexao.prepareStatement("UPDATE `clientes` "
                    + "SET nome = ?, data_nascimento = ?, rg = ?, orgao_emissor = ?, email = ?, telefone = ?, whats = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? "
                    + "WHERE id = ?");

            preparedStatement.setString(1, this.getNome());
            preparedStatement.setDate(2, this.getDataNascimento());
            preparedStatement.setString(3, this.getRg());
            preparedStatement.setString(4, this.getOrgaoEmissor());
            preparedStatement.setString(5, this.getEmail());
            preparedStatement.setString(6, this.getTelefone());
            preparedStatement.setBoolean(7, this.getWhats());
            preparedStatement.setString(8, this.getLogradouro());
            preparedStatement.setString(9, this.getNumero());
            preparedStatement.setString(10, this.getBairro());
            preparedStatement.setString(11, this.getCidade());
            preparedStatement.setString(12, this.getEstado());
            preparedStatement.setString(13, this.getCep());
            preparedStatement.setInt(14, this.getId());

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

    public static Cliente[] Listar(String search) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList();

        try {
            conexao = new Conexao().getConexao();
            preparedStatement = conexao.prepareStatement("select id, nome, data_nascimento, cpf, rg, orgao_emissor, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep from clientes WHERE nome LIKE CONCAT( '%',?,'%')");

            preparedStatement.setString(1, search);

            rs = preparedStatement.executeQuery();

            System.out.println("AAAA");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                Cliente client = new Cliente(
                        rs.getInt("id"), 
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento"),
                        rs.getString("rg"),
                        rs.getString("orgao_emissor"), 
                        rs.getString("email"), 
                        rs.getString("telefone"), 
                        Boolean.parseBoolean(rs.getString("whats")), 
                        rs.getString("logradouro"), 
                        rs.getString("numero"), 
                        rs.getString("bairro"), 
                        rs.getString("cidade"), 
                        rs.getString("estado"), 
                        rs.getString("cep")
                );
                System.out.println(client);
                lista.add(client);
            }

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
                e.printStackTrace();
                throw e;
            }
        }

        return lista.toArray(new Cliente[0]);

    }

    public static boolean Deletar(String[] ids) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("DELETE FROM clientes WHERE id IN (");
            for (int quantidade = ids.length - 1; quantidade > 0; quantidade--) {
                sqlBuilder.append("?,");
            }
            sqlBuilder.append("?)");

            conexao = new Conexao().getConexao();
            preparedStatement = conexao.prepareStatement(sqlBuilder.toString());

            for (int indice = 0; indice < ids.length; indice++) {
                preparedStatement.setInt(indice + 1, Integer.parseInt(ids[indice]));
            }

            System.out.println(preparedStatement.toString());

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
