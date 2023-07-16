package com.roastbier.roastbier.domain;

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

    public Usuario(String nome, LocalDate dataNascimento, String email, String telefone, Boolean whats, String usuario, String senha) {
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
}
