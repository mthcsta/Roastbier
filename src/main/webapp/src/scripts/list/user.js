$(document).ready(function() {
    
    $("#table_search").dataTable({
        columns: [
            {
                title: 'Selecionar',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="delete[]" class="select_row" value="${row.cpf}" />`;
                },
                width: 50,
            },
            { title: 'CPF', data: 'cpf' },
            { title: 'Name', data: 'nome' },
            { title: 'Birthday', data: 'nome' },
            { title: 'Email', data: 'email' },
            { title: 'Telephone', data: 'telefone' },
            {
                title: 'Has Whatsapp?',
                render: function(data, type, row) {
                    return row.whats ? 'Yes' : 'No'
                },
                data: 'whats'
            },
            { title: 'Username', data: 'usuario' },
        ],
        processing: true,
        serverSide: true,
        ajax: url_path("/ajax/list?m=users"),

    });

    $("#btn-delete").on("click", function() {

        $(".select_row").serializeArray();

    });

});