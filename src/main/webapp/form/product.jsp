<%@ page import="com.roastbier.roastbier.enums.UnidadeMedida" %>
<%@ page import="com.roastbier.roastbier.models.Produto"%>

<%
    Produto produto = new Produto();

    if(request.getParameter("id") != null){
        produto.setId(Integer.parseInt(request.getParameter("id")));
        produto.selecionarPorId();
    }
%>

<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=product" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <input type="hidden" name="isUpdate" value="<%=request.getAttribute("update")%>">
    <div>
        <input type="text" id="id" name="id" value="<%=produto.getId()%>" hidden>
    </div>
    <div>
        <label for="nome">Name:</label>
        <input type="text" id="nome" name="nome" maxlength="100" value="<%=produto.getNome()%>" required>
    </div>
    <br>
    <div>
        <label for="description">Description:</label>
        <input type="text" id="description" name="descricao" maxlength="255" value="<%=produto.getDescricao()%>">
    </div>
    <br>
    <div>
        <label for="unidade">Unity:</label>
        <br>
        <select id="unidade" name="unidade" maxlength="255" required>
            <% for (UnidadeMedida unidadeMedida : UnidadeMedida.values()) { %>
                <option value="<%=unidadeMedida.getAbreviacao()%>" <%=(produto.getUnidadeString().equals(unidadeMedida.getAbreviacao()) ? "selected" : "")%>><%=unidadeMedida.getUnidade()%></option>
            <% } %>
        </select>
    </div>
    <br>
    <div>
        <label for="precoUnitario">Unity Price:</label>
        <input type="number" name="precoUnitario" id="precoUnitario" value="<%=produto.getPrecoUnitario()%>" required>
    </div>
    <br>
    <input type="submit" value="<%=((boolean) request.getAttribute("update")) ? "Update" : "Insert" %>" class="btn btn-primary">
    <input type="button" onclick="history.back()" class="btn btn-primary" value="Cancel">
</form>
<script defer src="src/scripts/register/product.js" language="javascript" type="text/javascript"></script>