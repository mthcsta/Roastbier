package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Boolean whats;
    private String usuario;
    private String senha;

    public Usuario(String cpf, String nome, LocalDate dataNascimento, String email, String telefone, Boolean whats, String usuario, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getWhats() {
        return whats;
    }

    public void setWhats(Boolean whats) {
        this.whats = whats;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void salvar() {
        if (this.cpf == null) {
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

            preparedStatement = conexao.prepareStatement("INSERT INTO `usuarios` "
                    + "(cpf, nome, data_nascimento, email, telefone, whats, Username, Senha)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, this.cpf);
            preparedStatement.setString(2, this.nome);
            preparedStatement.setDate(3, Date.valueOf(this.dataNascimento));
            preparedStatement.setString(4, this.email);
            preparedStatement.setString(5, this.telefone);
            preparedStatement.setBoolean(6, this.whats);
            preparedStatement.setString(7, this.usuario);
            preparedStatement.setString(8, this.senha);

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

            preparedStatement = conexao.prepareStatement("UPDATE `usuarios` "
                    + "SET nome = ?, data_nascimento = ?, email = ?, telefone = ?, whats = ?, Username = ?, Senha = ?"
                    + "WHERE cpf = ?");

            preparedStatement.setString(1, this.nome);
            preparedStatement.setDate(2, Date.valueOf(this.dataNascimento));
            preparedStatement.setString(3, this.email);
            preparedStatement.setString(4, this.telefone);
            preparedStatement.setBoolean(5, this.whats);
            preparedStatement.setString(6, this.usuario);
            preparedStatement.setString(7, this.senha);
            preparedStatement.setString(8, this.cpf);

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
