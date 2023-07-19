<%@ page import="com.roastbier.roastbier.enums.UnidadeMedida" %>
<form id="myForm" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <!--"required" foram removidos dos elementos html para poder haver teste da validação por javascript-->

    <div>
        <input type="text" id="id" name="id" hidden>
    </div>
    <div>
        <label for="nome">Name:</label>
        <input type="text" id="nome" name="nome" maxlength="100" required>
    </div>
    <br>
    <div>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" maxlength="255">
    </div>
    <br>
    <div>
        <label for="unidade">Unity:</label>
        <br>
        <select id="unidade" name="unidade" maxlength="255" required>
            <% for (UnidadeMedida unidadeMedida : UnidadeMedida.values()) { %>
                <option value="<%=unidadeMedida.getAbreviacao()%>>"><%=unidadeMedida.getUnidade()%>></option>
            <% } %>
        </select>
    </div>
    <br>
    <div>
        <label for="precoUnitario">Unity Price:</label>
        <input type="number" name="precoUnitario" id="precoUnitario" required>
    </div>
</form>
<script src="src/scripts/register/product.js" language="javascript" type="text/javascript"></script>