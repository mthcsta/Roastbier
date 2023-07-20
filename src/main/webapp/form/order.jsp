<%@ page import="com.roastbier.roastbier.models.Produto" %>
<%@ page import="com.roastbier.roastbier.models.Cliente" %>
<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=order" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <div>
        <input type="hidden" id="id" name="id">
    </div>
    <div>
        <label for="dataEmissao">Issue Date:</label>
        <input type="text" id="dataEmissao" name="dataEmissao" placeholder="dd/mm/yyyy" required>
    </div>
    <br>
    <div>
        <label for="dataEntrega">Delivery Date:</label>
        <input type="text" id="dataEntrega" name="dataEntrega" placeholder="dd/mm/yyyy" required>
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
            <%
                for(Cliente cliente : Cliente.Listar())
                { %>
                    <option value="<%=cliente.getId()%>"><%=cliente.getNome()%></option>
                <% }
            %>
        </select>
    </div>
    <br>
    <div>
        <label for="produtoId">Product</label>
        <table>
            <thead>
                <th>Select</th>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
            </thead>
            <tbody>
            <%
                for(Produto produto : Produto.Listar())
                { %>
                    <tr>
                        <td><input type="checkbox" class="produtoId" name="produtoId[]" value="<%=produto.getId()%>"></td>
                        <td><%=produto.getNome()%></td>
                        <td><%=produto.getPreco()%></td>
                        <td>
                            <input type="number" id="quantidade-<%=produto.getId()%>" name="quantidade[]" maxlength="3000" disabled>
                            <input type="hidden" id="preco-<%=produto.getPrecoUnitario()%>" name="preco[]" maxlength="3000" disabled>
                            <input type="hidden" id="unidade-<%=produto.getUnidadeString()%>" name="unidade[]" maxlength="3000" disabled>
                        </td>
                    </tr>
                <% }
            %>
                
            </tbody>
            
        </table>
    </div>
    <input type="submit" value="insert" class="btn btn-primary">
</form>
<script src="src/scripts/register/order.js" language="javascript" type="text/javascript"></script>