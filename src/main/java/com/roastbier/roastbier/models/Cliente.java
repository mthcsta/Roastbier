package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class Cliente {
    private int id = -1;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String rg;
    private String orgao_emissor;
    private String email;
    private String telefone;
    private Boolean whats;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Cliente(String cpf, String nome, LocalDate dataNascimento, String rg, String orgao_emissor,
            String email, String telefone, Boolean whats, String logradouro, String numero, String bairro,
            String cidade, String estado, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.orgao_emissor = orgao_emissor;
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

    public Cliente(int id, String cpf, String nome, LocalDate dataNascimento, String rg, String orgao_emissor,
    String email, String telefone, Boolean whats, String logradouro, String numero, String bairro,
    String cidade, String estado, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.orgao_emissor = orgao_emissor;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public String getOrgao_emissor() {
        return orgao_emissor;
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

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setOrgao_emissor(String orgao_emissor) {
        this.orgao_emissor = orgao_emissor;
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

    public void salvar() {
        if (this.id == -1) {
            novo();
            return;
        }
        atualizar();
    }

    public void novo() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new Conexao().getConexao();

            preparedStatement = conexao.prepareStatement("INSERT INTO `clientes` "
                    + "(cpf, nome, data_nascimento, rg, orgao_emissor, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, this.getCpf());
            preparedStatement.setString(2, this.getNome());
            preparedStatement.setDate(3, Date.valueOf(this.getDataNascimento()));
            preparedStatement.setString(4, this.getRg());
            preparedStatement.setString(5, this.getOrgao_emissor());
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

            preparedStatement = conexao.prepareStatement("UPDATE `clientes` "
                    + "SET nome = ?, data_nascimento = ?, rg = ?, orgao_emissor = ?, email = ?, telefone = ?, whats = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? "
                    + "WHERE id = ?");

            preparedStatement.setString(1, this.getNome());
            preparedStatement.setDate(2, Date.valueOf(this.getDataNascimento()));
            preparedStatement.setString(3, this.getRg());
            preparedStatement.setString(4, this.getOrgao_emissor());
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
