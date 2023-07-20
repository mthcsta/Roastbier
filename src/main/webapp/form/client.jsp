<%@ page import="com.roastbier.roastbier.models.Cliente" %>

<%
    Cliente client = new Cliente();
    if(request.getParameter("id") != null){
        client.setId(Integer.parseInt(request.getParameter("id")));
        client.selecionarPorId();
    }
%>

<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=client" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <input type="hidden" name="isUpdate" value="<%=request.getAttribute("update")%>">
    <div>
        <input type="text" name="id" id="id" value="<%=client.getId()%>" hidden>
    </div>
    <div>
        <label for="nome">Name:</label>
        <input type="text" id="nome" name="nome" maxlength="100" value="<%=client.getNome()%>" required>
    </div>
    <br>
    <div>
        <label for="dataNascimento">Birth Date:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" placeholder="yyyy-mm-dd" value="<%=client.getDataNascimento()%>">
    </div>
    <br>
    <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="15" value="<%=client.getCpf()%>" required>
    </div>
    <br>
    <div>
        <label for="rg">RG:</label>
        <input type="text" id="rg" name="rg" maxlength="15" value="<%=client.getRg()%>" required>
    </div>
    <br>
    <div>
        <label for="orgaoEmissor">Issuing Agency:</label>
        <input type="text" id="orgaoEmissor" name="orgaoEmissor" maxlength="20" value="<%=client.getOrgaoEmissor()%>">
    </div>
    <br>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=client.getEmail()%>" required>
    </div>
    <br>
    <div>
        <label for="telefone">Phone Number:</label>
        <br>
        <input type="text" id="telefone" name="telefone" maxlength="16" value="<%=client.getTelefone()%>">
    </div>
    <br>
    <div>
        <label for="whats">WhatsApp:</label>
        <input type="checkbox" id="whats" name="whats" value="1" <%=client.getWhats() ? "checked" : ""%>>
    </div>
    <br>
    <div>
        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" maxlength="8" value="<%=client.getCep()%>" onblur="viaCep()">
    </div>
    <br>
    <div>
        <label for="logradouro">Public Place:</label>
        <input type="text" id="logradouro" name="logradouro" maxlength="200" value="<%=client.getLogradouro()%>">
    </div>
    <br>
    <div>
        <label for="numero">Number:</label>
        <input type="number" id="numero" name="numero" maxlength="20" value="<%=client.getNumero()%>">
    </div>
    <br>
    <div>
        <label for="bairro">Neighborhood:</label>
        <input type="text" id="bairro" name="bairro" maxlength="100" value="<%=client.getBairro()%>">
    </div>
    <br>
    <div>
        <label for="cidade">City:</label>
        <input type="text" id="cidade" name="cidade" maxlength="100" value="<%=client.getCidade()%>">
    </div>
    <br>
    <div>
        <label for="estado">State:</label>
        <input type="text" id="estado" name="estado" maxlength="2" value="<%=client.getEstado()%>">
    </div>
    <br>
    <input type="submit" value="<%=((boolean) request.getAttribute("update")) ? "Update" : "Insert" %>" class="btn btn-primary">
    <input type="button" onclick="history.back()" class="btn btn-primary" value="Cancel">
</form>
<script defer src="src/scripts/register/client.js" language="javascript" type="text/javascript"></script>