<form id="myForm" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <!--"required" foram removidos dos elementos html para poder haver teste da validação por javascript-->

    <div>
        <input type="text" id="id" name="id" hidden>
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
        <label for="clienteId">Client ID:</label>
        <input type="number" id="clienteId" name="clienteId" maxlength="15" required>
    </div>
</form>
<script src="src/scripts/register/order.js" language="javascript" type="text/javascript"></script>