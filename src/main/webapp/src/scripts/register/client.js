$(document).ready(function(){
  $('#dataNascimento').on('input', function() {
    var data = $(this).val();
    if (data.length === 10) {
      $(this).mask('0000-00-00', {reverse: false});
    } else {
      $(this).mask('0000-00-00?9', {reverse: false});
    }
  });

    $("#cpf").inputmask({ mask: "999.999.999-99", removeMaskOnSubmit: true });

    $("#telefone").inputmask({ mask: "(99) [9 ]9999-9999", removeMaskOnSubmit: true });

});

function viaCep(){
    var cepInput = document.getElementById('cep');
    var cepValue = cepInput.value.replace(/\D/g, '');

    var url = `https://viacep.com.br/ws/${cepValue}/json/`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (!data.erro) {
                document.getElementById('logradouro').value = data.logradouro;
                document.getElementById('bairro').value = data.bairro;
                document.getElementById('cidade').value = data.localidade;
                document.getElementById('estado').value = data.uf;
            } else {
                console.log('CEP not found!');
            }
        })
        .catch(error => {
          console.error('Error fetching data:', error);
          $("#erros").append("<li>Error fetching data from CEP service.</li>");
      });
    
}

function validar() {

    var retorno = true;

    $("#erros li").remove();

    // validação de nome
    if ($("#nome").val() == "") {
        retorno = erroValidacao("Please fill the Name field", "#nome");
    } else {
        if ($("#nome").val().length > 100) {
            retorno = erroValidacao("The Name field must have the maximum of 100 caracters", "#nome");
        } else {
            $("#nome").css("background-color","");
        }
    }

    // validação de data
    if ($("#dataNascimento").val() == ""){
        retorno = erroValidacao("Please fill the Date field.", "#dataNascimento");
    }else{
        $("#dataNascimento").css("background-color","");
    }

    // validação de cpf
    var cpf = $("#cpf").val();
    if(!validarCPF(cpf)){
        retorno = erroValidacao("Invalid CPF", "#cpf")
    }else{
        $("#cpf").css("background-color","");
    }

    // validação de rg
    if($("#rg").val() > 15 || $("#rg").val() == ""){
        retorno = erroValidacao("Invalid RG", "#rg")
    }else{
        $("#rg").css("background-color","");
    }

    // validação email
    var regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var email = $("#email").val();

    if(regexEmail.test(email)){
      $("#email").css("background-color","");
    }else{
      retorno = erroValidacao("Invalid E-mail", "#email");
    }

    // Se a página foi validada com sucesso, muda para a página de success.

    if (!retorno) {
      alert("retorno false");
    }

    return retorno;
}

function validarCPF(cpf) {
    cpf = cpf.replace(/\D/g, '');
  
    if (cpf.length !== 11) {
      return false;
    }
  
    if (/^(\d)\1+$/.test(cpf)) {
      return false;
    }
  
    let soma = 0;
    for (let i = 0; i < 9; i++) {
      soma += parseInt(cpf.charAt(i)) * (10 - i);
    }
    let resto = (soma * 10) % 11;
    let digitoVerificador1 = resto === 10 ? 0 : resto;
  
    soma = 0;
    for (let i = 0; i < 10; i++) {
      soma += parseInt(cpf.charAt(i)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    let digitoVerificador2 = resto === 10 ? 0 : resto;
  
    if (parseInt(cpf.charAt(9)) !== digitoVerificador1 || parseInt(cpf.charAt(10)) !== digitoVerificador2) {
      return false;
    }
    return true;
  }