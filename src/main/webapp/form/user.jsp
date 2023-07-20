<%@ page import="com.roastbier.roastbier.models.Usuario"%>

<%
    Usuario usuario = new Usuario();

    if(request.getParameter("id") != null){
        usuario.setCpf(request.getParameter("id"));
        usuario.selecionarPorId();
    }
%>
<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=user" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <input type="hidden" name="isUpdate" value="<%=request.getAttribute("update")%>">
    <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="15" value="<%=usuario.getCpf()%>" <%=((boolean) request.getAttribute("update")) ? "readonly" : "" %> required>
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
        <label for="telefone">Phone Number:</label>
        <input type="text" id="telefone" name="telefone" maxlength="16" value="<%=usuario.getTelefone()%>">
    </div>
    <br>
    <div>
        <label for="whats">WhatsApp:</label>
        <input type="checkbox" id="whats" name="whats" value="1" <%=usuario.getWhats() ? "checked" : ""%>>
    </div>
    <br>
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" maxlength="15" value="<%=usuario.getUsuario()%>" required>
    </div>
    <br>
    <div>
        <label for="senha"><%=((boolean) request.getAttribute("update")) ? "New Password" : "Password" %>:</label>
        <input type="password" id="senha" name="senha" maxlength="255" <%=((boolean) request.getAttribute("update")) ? "" : "required" %>>
    </div>
    <br>
    <input type="submit" value="<%=((boolean) request.getAttribute("update")) ? "Update" : "Insert" %>" class="btn btn-primary">
    <input type="button" onclick="history.back()" class="btn btn-primary" value="Cancel">
</form>
<script defer src="src/scripts/register/user.js" language="javascript" type="text/javascript"></script>