$(document).ready(function() {

    // Popula a caixa de seleção de estados
    $.getJSON("https://servicodados.ibge.gov.br/api/v1/localidades/estados", function(data) {
      var options = "<option value='none'>Selecione um estado</option>";
      var regions = {};
    
      // Agrupa os estados por região
      $.each(data, function(index, estado) {
        var region = estado.regiao.nome;
        if (!regions[region]) {
          regions[region] = [];
        }
        regions[region].push(estado);
      });
    
      // Ordena os estados por nome
      $.each(regions, function(region, estados) {
        estados.sort(function(a, b) {
          return a.nome.localeCompare(b.nome);
        });
      });
    
      // Popula as opções da caixa de seleção de estados por região em ordem alfabética
      $.each(regions, function(region, estados) {
        options += "<optgroup label='" + region + "'>";
        $.each(estados, function(index, estado) {
          options += "<option value='" + estado.sigla + "'>" + estado.nome + "</option>";
        });
        options += "</optgroup>";
      });
    
      $("#estado").html(options);
  });

  // Aplica as máscaras de CPF e data
  $('#cpf').on('input', function() {
    var cpf = $(this).val();
    if (cpf.length === 15) {
      $(this).mask('000.000.000-00', {reverse: false});
    } else {
      $(this).mask('000.000.000-009', {reverse: false});
    }
  });

  $('#dataNascimento').on('input', function() {
    var data = $(this).val();
    if (data.length === 10) {
      $(this).mask('0000-00-00', {reverse: false});
    } else {
      $(this).mask('0000-00-00?9', {reverse: false});
    }
  });

});

// Validação do formulário
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

    // validação de cpf
    var cpf = $("#cpf").val();
    if(!validarCPF(cpf)){
        retorno = erroValidacao("Invalid CPF", "#cpf")
    }else{
        $("#cpf").css("background-color","");
    }

    // validação de data
    if ($("#dataNascimento").val() == ""){
        retorno = erroValidacao("Please fill the Date field.", "#dataNascimento");
    }else{
        $("#dataNascimento").css("background-color","");
    }

    // validação de endereço
    if ($("#endereco").val() == "") {
      retorno = erroValidacao("Please fill the Address field.", "#endereco");
    } else {
        if ($("#endereco").val().length > 255) {
          retorno = erroValidacao("The Address field must have the maximum of 255 caracters", "#endereco");
        } else {
            $("#endereco").css("background-color","");
        }
    }

    // validação do estado
    var estadoSelecionado = $("#estado").val();

    if (!estadoSelecionado || estadoSelecionado === "" || estadoSelecionado == "none") {
        retorno = erroValidacao("Select the State", "#estado");
    }else{
        $("#estado").css("background-color","");
    }

    // validação de Genero
    var generoSelecionado = $("input[name='genero']:checked").val();
    var outroGenero = $("#outroGenero").val();

    if (!generoSelecionado) {
      $("#erros").append("<li>Please select a gender.</li>");
      retorno = false;
    } else if (generoSelecionado === "outro" && !outroGenero) {
      $("#erros").append("<li>Please enter a description for 'Other' gender.</li>");
      retorno = false;
    }

    // validação email
    var regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var email = $("#email").val();

    if(regexEmail.test(email)){
      $("#email").css("background-color","");
    }else{
      retorno = erroValidacao("Invalid E-mail", "#email");
    }

    // validação de preferencias
    var preferencias = $("input[name='preferencias']:checked");
    if (preferencias.length === 0) {
      retorno = false
      $("#erros").append("<li>Please select at least one preference.</li>");
    }

    // Se a página foi validada com sucesso, muda para a página de resultados.

    if (retorno) {
      $.ajax({
        url: "/user/register",
        type:"POST",
        data:$('form').serialize(),
        success : function(data) {
          console.log(data);
        }
      })

    }else{
      alert("retorno false");
    }

    return retorno;
    
}

// Validação do CPF
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

function erroValidacao(msg, element){
    $("#erros").append("<li>" + msg + "</li>");
    $(element).css("background-color","#FF0000");
    $(element).focus();
    return false;
}


