<form id="myForm" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <div>
        <input type="text" id="id" hidden>
    </div>
    <div>
        <label for="nome">Name:</label>
        <input type="text" id="nome" name="nome" maxlength="100" required>
    </div>
    <br>
    <div>
        <label for="dataNascimento">Birth Date:</label>
        <input type="text" id="dataNascimento" name="dataNascimento" placeholder="dd/mm/yyyy">
    </div>
    <br>
    <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="11" required>
    </div>
    <br>
    <div>
        <label for="rg">RG:</label>
        <input type="text" id="rg" name="rg" maxlength="15" required>
    </div>
    <br>
    <div>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>
    </div>
    <br>
    <div>
        <label for="telefone">Phone:</label>
        <br>
        <textarea id="telefone" name="telefone" maxlength="13"></textarea>
    </div>
    <br>
    <div>
        <label for="whats">WhatsApp:</label>
        <input type="checkbox" id="whats" name="whats" value="1">
    </div>
    <br>
    <div>
        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" maxlength="8" onblur="viaCep()">
    </div>
    <br>
    <div>
        <label for="logradouro">Public Place:</label>
        <input type="text" id="logradouro" name="logradouro" maxlength="200">
    </div>
    <br>
    <div>
        <label for="numero">Number:</label>
        <input type="number" id="numero" name="numero" maxlength="20">
    </div>
    <br>
    <div>
        <label for="bairro">Neighborhood:</label>
        <input type="number" id="bairro" name="bairro" maxlength="100">
    </div>
    <br>
    <div>
        <label for="cidade">City:</label>
        <input type="number" id="cidade" name="cidade" maxlength="100">
    </div>
    <br>
    <div>
        <label for="estado">State:</label>
        <input type="number" id="estado" name="estado" maxlength="2">
    </div>
    <br>
</form>
<script src="src/scripts/register/client.js" language="javascript" type="text/javascript"></script>