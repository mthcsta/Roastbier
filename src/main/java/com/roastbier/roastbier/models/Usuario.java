package com.roastbier.roastbier.models;

import com.roastbier.roastbier.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private Boolean whats;
    private String usuario;
    private String senha;

    public Usuario(String cpf, String nome, Date dataNascimento, String email, String telefone, Boolean whats, String usuario, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
        this.cpf = "";
        this.nome = "";
        this.dataNascimento = null;
        this.email = "";
        this.telefone = "";
        this.whats = false;
        this.usuario = "";
        this.senha = "";
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    public boolean hasUser(String cpf) throws SQLException {
        PreparedStatement preparedStatement = null;
    
        try {
            Connection conexao = Conexao.GetConexao();

            String sql = null;

            if (cpf == null) {
                sql = "SELECT Username FROM usuarios WHERE Username = ? OR email = ?";
            } else {
                sql = "SELECT Username FROM usuarios WHERE (Username = ? OR email = ?) AND cpf != ?";
            }

            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, this.getUsuario());
            preparedStatement.setString(2, this.getEmail());
            
            if (cpf != null) {
                preparedStatement.setString(3, this.getCpf());
            }
    
            ResultSet rs = preparedStatement.executeQuery();
    
            return rs.next();
    
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void novo() throws Exception {
        PreparedStatement preparedStatement = null;
    
        try {
            Connection conexao = Conexao.GetConexao();
    
            if (hasUser(null)) {
                throw new Exception("Username or Email already used!");
            }

            preparedStatement = conexao.prepareStatement("INSERT INTO `usuarios` "
                    + "(cpf, nome, data_nascimento, email, telefone, whats, Username, Senha)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, md5(?))");

            preparedStatement.setString(1, this.cpf);
            preparedStatement.setString(2, this.nome);
            preparedStatement.setDate(3, this.dataNascimento);
            preparedStatement.setString(4, this.email);
            preparedStatement.setString(5, this.telefone);
            preparedStatement.setBoolean(6, this.whats);
            preparedStatement.setString(7, this.usuario);
            preparedStatement.setString(8, this.senha);

            preparedStatement.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception("CPF already used!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void atualizar() throws Exception {
        PreparedStatement preparedStatement = null;

            try {
                Connection conexao = Conexao.GetConexao();

                if(hasUser(this.cpf)){
                    throw new Exception("Username or Email already used!");
                }

                if (this.senha == null || this.senha.equals("")) {
                    preparedStatement = conexao.prepareStatement("UPDATE `usuarios` "
                            + "SET nome = ?, data_nascimento = ?, email = ?, telefone = ?, whats = ?, Username = ?"
                            + "WHERE cpf = ?");

                    preparedStatement.setString(1, this.nome);
                    preparedStatement.setDate(2, this.dataNascimento);
                    preparedStatement.setString(3, this.email);
                    preparedStatement.setString(4, this.telefone);
                    preparedStatement.setBoolean(5, this.whats);
                    preparedStatement.setString(6, this.usuario);
                    preparedStatement.setString(7, this.cpf);
                } else {
                    preparedStatement = conexao.prepareStatement("UPDATE `usuarios` "
                            + "SET nome = ?, data_nascimento = ?, email = ?, telefone = ?, whats = ?, Username = ?, Senha = md5(?)"
                            + "WHERE cpf = ?");

                    preparedStatement.setString(1, this.nome);
                    preparedStatement.setDate(2, this.dataNascimento);
                    preparedStatement.setString(3, this.email);
                    preparedStatement.setString(4, this.telefone);
                    preparedStatement.setBoolean(5, this.whats);
                    preparedStatement.setString(6, this.usuario);
                    preparedStatement.setString(7, this.senha);
                    preparedStatement.setString(8, this.cpf);
                }

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    public static Usuario autenticar(String usuario, String senha) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            Connection conexao = Conexao.GetConexao();

            preparedStatement = conexao.prepareStatement("SELECT cpf, nome, data_nascimento, email, telefone, whats, Username, Senha FROM usuarios WHERE Username = ? AND Senha = md5(?)");

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                return null;
            }

            return new Usuario(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getBoolean("whats"),
                    rs.getString("Username"),
                    rs.getString("Senha")
            );
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
        //return null;
    }

    public static Usuario[] Listar(String search) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList();
        
        try {
            Connection conexao = Conexao.GetConexao();   
            preparedStatement = conexao.prepareStatement("select cpf, nome, data_nascimento, email, telefone, whats, Username, Senha from usuarios WHERE nome LIKE CONCAT( '%',?,'%')");

            preparedStatement.setString(1, search);
            
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Usuario user = new Usuario(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getBoolean("whats"),
                    rs.getString("Username"),
                    rs.getString("Senha")
                );
                lista.add(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        
        return lista.toArray(new Usuario[0]);
        
    }

    public void selecionarPorId() throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
            Connection conexao = Conexao.GetConexao();   
            preparedStatement = conexao.prepareStatement("select nome, data_nascimento, email, telefone, whats, Username, Senha from usuarios WHERE cpf = ?");

            preparedStatement.setString(1, this.getCpf());
            
            rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                    this.setNome(rs.getString("nome"));
                    this.setDataNascimento(rs.getDate("data_nascimento"));
                    this.setEmail(rs.getString("email"));
                    this.setTelefone(rs.getString("telefone"));
                    this.setWhats(rs.getBoolean("whats"));
                    this.setUsuario(rs.getString("Username"));
                    this.setSenha(rs.getString("Senha"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }  
    }

    public static boolean Deletar(String[] ids) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("DELETE FROM usuarios WHERE cpf IN (");
            for (int quantidade = ids.length - 1; quantidade > 0; quantidade--) {
                sqlBuilder.append("?,");
            }
            sqlBuilder.append("?)");

            Connection conexao = Conexao.GetConexao();
            preparedStatement = conexao.prepareStatement(sqlBuilder.toString());

            for (int indice = 0; indice < ids.length; indice++) {
                preparedStatement.setString(indice + 1, ids[indice]);
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
}
