$(document).ready(function(){
    $(".produtoId").on("click", function(){
        let id = $(this).val();
        $(`.produtoData-${id}`).attr("disabled", !$(this).is(":checked"));
    });

    function calculaPedidoTotal() {
        const produtos = [...$(".produtoId:checked")].map((produtoId) => produtoId.value);
        const pedidoTotal = produtos.map((produtoId) => {
            const info = $(`.produtoData-${produtoId}[name='quantidade[]']`);
            const produtoPreco = info.data('produto-preco');
            const quantidade = info.val();

            $("#produtoTotal-" + produtoId).html(new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3 }).format(quantidade * produtoPreco));

            return produtoPreco * quantidade
        }).reduce((acc, val) => acc + val, 0);

        $("#pedidoTotal").html(new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3 }).format(pedidoTotal))
    }

    $(document).on('keyup', ".produto-quantidade", calculaPedidoTotal);

    calculaPedidoTotal();
});

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