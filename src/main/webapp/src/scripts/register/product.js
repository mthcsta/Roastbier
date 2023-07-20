function validar() {

    var retorno = true;

    $("#erros li").remove();

    // input text "name" validation
    if ($("#nome").val() == "") {
        retorno = erroValidacao("Please fill the Name field", "#nome");
    } else {
        if ($("#nome").val().length > 100) {
            retorno = erroValidacao("The Name field must have the maximum of 100 caracters", "#nome");
        } else {
            $("#nome").css("background-color","");
        }
    }

    // validação de unidade
    if ($("#unidade").val() == ""){
        retorno = erroValidacao("Please fill unity field.", "#unidade");
    }else{
        $("#unidade").css("background-color","");
    }

    // validação email
    if($("#precoUnitario").val() ){
        retorno = erroValidacao("Invalid unity price", "#precoUnitario");
    }else{
        $("#precoUnitario").css("background-color",""); 
    }

    // Se a página foi validada com sucesso, muda para a página de success.

    if (!retorno) {
      alert("retorno false");
    }

    return retorno;
}