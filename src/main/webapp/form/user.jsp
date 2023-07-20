<%@ page import="com.roastbier.roastbier.models.Usuario"%>

<%
    Usuario usuario = new Usuario();
    boolean update = false;

    if(request.getParameter("id") != null){
        usuario.setId(request.getParameter("id"));
        usuario.selecionarPorId();
        update = true;
    }
%>
<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=user" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <input type="hidden" name="isUpdate" value="<%=update%>">
    <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="11" value="<%=usuario.getCpf()%>" <%=(update) ? "readonly" : "" %> required>
    </div>
    <br>
    <div>
        <label for="nome">Name:</label>
        <input type="text" id="nome" name="nome" maxlength="100" value="<%=usuario.getNome()%>" required>
    </div>
    <br>
    <div>
        <label for="dataNascimento">Birth Date:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" value="<%=usuario.getDataNascimento()%>" placeholder="yyyy-mm-dd">
    </div>
    <br>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=usuario.getEmail()%>" required>
    </div>
    <br>
    <div>
        <label for="telefone">Phone:</label>
        <input type="text" id="telefone" name="telefone" maxlength="13" value="<%=usuario.getTelefone()%>">
    </div>
    <br>
    <div>
        <label for="whats">WhatsApp:</label>
        <input type="checkbox" id="whats" name="whats" value="1" value="<%=usuario.getWhats()%>">
    </div>
    <br>
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" maxlength="15" value="<%=usuario.getUsuario()%>" required>
    </div>
    <br>
    <div>
        <label for="senha">Password:</label>
        <input type="text" id="senha" name="senha" maxlength="255" required>
    </div>
    <br>
    <input type="submit" value="<%=(isUpdate) ? "Update" : "Insert" %>" class="btn btn-primary">
</form>
<script src="src/scripts/register/user.js" language="javascript" type="text/javascript"></script>