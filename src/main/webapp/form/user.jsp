<form id="myForm" onsubmit="return validar();">

    <ul id="erros" style="color: #FF0000;"></ul>

    <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="11" required>
    </div>
    <br>
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
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" maxlength="15" required>
    </div>
    <br>
    <div>
        <label for="senha">Password:</label>
        <input type="text" id="senha" name="senha" maxlength="255" required>
    </div>
    <br>
</form>
<script src="src/scripts/register/user.js" language="javascript" type="text/javascript"></script>