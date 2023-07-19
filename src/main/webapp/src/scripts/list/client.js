$(document).ready(function() {

    const datatable =  $("#table_search").dataTable({
        columns: [
            {
                title: 'Selecionar',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="delete[]" class="select_row" value="${row.cpf}" />`;
                },
                width: 50,
            },
            { title: 'ID', data: 'id' }, 
            { title: 'Name', data: 'nome' }, 
            { title: 'Birthday', data: 'dataNascimento' }, 
            { title: 'CPF', data: 'cpf' }, 
            { title: 'RG', data: 'rg' }, 
            { title: 'Orgão Emissor', data: 'orgaoEmissor' }, 
            { title: 'Email', data: 'email' }, 
            { title: 'Cellphone', data: 'telefone' }, 
            { title: 'Has Whatsapp?', data: 'whats' }, 
            { title: 'Public Place', data: 'logradouro' }, 
            { title: 'Number', data: 'numero' }, 
            { title: 'Neighborhood', data: 'bairro' }, 
            { title: 'City', data: 'cidade' }, 
            { title: 'State', data: 'estado' }, 
            { title: 'CEP', data: 'cep' }

        ],
        processing: true,
        serverSide: true,
        responsive: true,
        ajax: url_path("/ajax/list?m=client"),
    });

    console.log(datatable.DataTable());

});