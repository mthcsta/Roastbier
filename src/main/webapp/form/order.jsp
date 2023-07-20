<%@ page import="com.roastbier.roastbier.models.Produto" %>
<%@ page import="com.roastbier.roastbier.models.Cliente" %>
<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=order" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <div>
        <input type="hidden" id="id" name="id">
    </div>
    <div>
        <label for="dataEmissao">Issue Date:</label>
        <input type="date" id="dataEmissao" name="dataEmissao" placeholder="dd/mm/yyyy" required>
    </div>
    <br>
    <div>
        <label for="dataEntrega">Delivery Date:</label>
        <input type="date" id="dataEntrega" name="dataEntrega" placeholder="dd/mm/yyyy" required>
    </div>
    <br>
    <div>
        <label for="valorFrete">Freight Value:</label>
        <input type="number" id="valorFrete" name="valorFrete" maxlength="100" required>
    </div>
    <br>
    <div>
        <label for="clienteId">Client:</label>
        <select name="clienteId" id="clienteId">
            <% for(Cliente cliente : Cliente.Listar("")) { %>
                <option value="<%=cliente.getId()%>"><%=cliente.getNome()%></option>
            <% } %>
        </select>
    </div>
    <br>
    <div>
        <label for="produtoId">Product</label>
        <table class="table">
            <thead>
                <th>Select</th>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
            </thead>
            <tbody>
            <% for(Produto produto : Produto.Listar("")) { %>
                    <tr>
                        <td><input type="checkbox" class="produtoId" name="produtoId[]" value="<%=produto.getId()%>"></td>
                        <td><%=produto.getNome()%></td>
                        <td><%=produto.getPrecoUnitario()%></td>
                        <td>
                            <input type="number" class="produtoData-<%=produto.getId()%>" name="quantidade[]" class="produtoData-<%=produto.getId()%>" maxlength="3000" disabled>
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="preco[]" class="produtoData-<%=produto.getId()%>" value="<%=produto.getPrecoUnitario()%>" maxlength="3000" disabled>
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="unidade[]" maxlength="3000" value="<%=produto.getUnidade().getAbreviacao()%>" disabled>
                        </td>
                    </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <input type="submit" value="insert" class="btn btn-primary">
</form>
<script defer src="src/scripts/register/order.js" language="javascript" type="text/javascript"></script>