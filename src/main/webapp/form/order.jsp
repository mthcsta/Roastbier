<%@ page import="com.roastbier.roastbier.models.Produto" %>
<%@ page import="com.roastbier.roastbier.models.Cliente" %>
<%@ page import="com.roastbier.roastbier.models.Pedido" %>
<%@ page import="com.roastbier.roastbier.models.ProdutoHasPedido" %>

<%
    Pedido pedido = new Pedido();

    if(request.getParameter("id") != null){
        pedido.setNumero(Integer.parseInt(request.getParameter("id")));
        pedido.selecionarPorId();
    }
%>
<form id="myForm" method="POST" action="<%=System.getProperty("BASE_URL")%>/register?m=order" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <input type="hidden" name="isUpdate" value="<%=request.getAttribute("update")%>">
    <div>
        <input type="hidden" id="id" name="id" value="<%=pedido.getNumero()%>">
    </div>
    <div>
        <label for="dataEmissao">Issue Date:</label>
        <input type="date" id="dataEmissao" name="dataEmissao" placeholder="dd/mm/yyyy" value="<%=pedido.getDataEmissao()%>" required>
    </div>
    <br>
    <div>
        <label for="dataEntrega">Delivery Date:</label>
        <input type="date" id="dataEntrega" name="dataEntrega" placeholder="dd/mm/yyyy" value="<%=pedido.getDataEntrega()%>" required>
    </div>
    <br>
    <div>
        <label for="valorFrete">Freight Value:</label>
        <input type="number" id="valorFrete" name="valorFrete" maxlength="100" value="<%=pedido.getValorFrete()%>" required>
    </div>
    <br>
    <div>
        <label for="clienteId">Client:</label>
        <select name="clienteId" id="clienteId">
            <% for(Cliente cliente : Cliente.Listar("")) { %>
                <option value="<%=cliente.getId()%>" <%=(cliente.getId() == pedido.getClienteId()) ? "selected" : "" %>><%=cliente.getNome()%></option>
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
            <%
                for(Produto produto : Produto.Listar("")) {
                    ProdutoHasPedido produtoHasPedido = new ProdutoHasPedido();
                    produtoHasPedido.setProdutoId(produto.getId());
                    produtoHasPedido.setPedidoNumero(pedido.getNumero());
                    produtoHasPedido.selecionarPorIdENumero();
            %>
                    <tr>
                        <td><input type="checkbox" class="produtoId" name="produtoId[]" value="<%=produto.getId()%>"></td>
                        <td><%=produto.getNome()%></td>
                        <td><%=produto.getPrecoUnitario()%></td>
                        <td>
                            <input type="number" class="produtoData-<%=produto.getId()%>" name="quantidade[]" class="produtoData-<%=produto.getId()%>" maxlength="3000" value="<%=produtoHasPedido.getQuantidade()%>" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "Disabled"%>>
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="preco[]" class="produtoData-<%=produto.getId()%>" value="<%=produto.getPrecoUnitario()%>" maxlength="3000" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "Disabled"%>
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="unidade[]" maxlength="3000" value="<%=produto.getUnidade().getAbreviacao()%>" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "Disabled"%>
                        </td>
                    </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <input type="submit" value="<%=((boolean) request.getAttribute("update")) ? "Update" : "Insert" %>" class="btn btn-primary">
</form>
<script defer src="src/scripts/register/order.js" language="javascript" type="text/javascript"></script>