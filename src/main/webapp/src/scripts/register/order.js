function validar() {

    var retorno = true;

    $("#erros li").remove();

    // validação de datas
    if ($("#dataEmissao").val() == ""){
        retorno = erroValidacao("Please fill the Date Emission field.", "#dataEmissao");
    }else{
        $("#dataEmissao").css("background-color","");
    }

    if ($("#dataEntrega").val() == ""){
        retorno = erroValidacao("Please fill the Date Delivery field.", "#dataEntrega");
    }else{
        $("#dataEntrega").css("background-color","");
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