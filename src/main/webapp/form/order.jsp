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
        <input type="date" id="dataEmissao" name="dataEmissao" value="<%=pedido.getDataEmissao()%>" placeholder="dd/mm/yyyy" required>
    </div>
    <br>
    <div>
        <label for="dataEntrega">Delivery Date:</label>
        <input type="date" id="dataEntrega" name="dataEntrega" value="<%=pedido.getDataEntrega()%>" placeholder="dd/mm/yyyy" required>
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
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
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
                        <td><input type="checkbox" class="produtoId" name="produtoId[]" value="<%=produto.getId()%>" <%=(produtoHasPedido.getQuantidade() > 0) ? "checked onclick=\"return false;\"" : ""%>></td>
                        <td><%=produto.getNome()%></td>
                        <td><%=produto.getPrecoUnitario()%></td>
                        <td>
                            <input type="number" class="produto-quantidade produtoData-<%=produto.getId()%>" data-produto-id="<%=produto.getId()%>" data-produto-preco="<%=produto.getPrecoUnitario()%>" name="quantidade[]" maxlength="3000" value="<%=produtoHasPedido.getQuantidade()%>" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "disabled"%> />
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="preco[]" value="<%=produto.getPrecoUnitario()%>" maxlength="3000" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "disabled"%> />
                            <input type="hidden" class="produtoData-<%=produto.getId()%>" name="unidade[]" maxlength="3000" value="<%=produto.getUnidade().getAbreviacao()%>" <%=(produtoHasPedido.getQuantidade() > 0) ? "" : "disabled"%> />
                        </td>
                        <td>
                            <output id="produtoTotal-<%=produto.getId()%>"></output>
                        </td>
                    </tr>
            <% } %>
            </tbody>
            <tfoot>
                <td colspan="4" class="text-end text-bold">Valor Total</td>
                <td colspan="1" class="text-bold">
                    <output id="pedidoTotal"></output>
                </td>
            </tfoot>
        </table>
    </div>
    <input type="submit" value="<%=((boolean) request.getAttribute("update")) ? "Update" : "Insert" %>" class="btn btn-primary">
    <input type="button" onclick="history.back()" class="btn btn-primary" value="Cancel">
</form>
<script defer src="src/scripts/register/order.js" language="javascript" type="text/javascript"></script>