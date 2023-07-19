$(document).ready(function() {

    $("#table_search").dataTable({
        columns: [
            {
                title: 'Selecionar',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="selecionar[]" value="${row.cpf}" />`;
                },
                width: 50,
            },
            { title: 'Nome', data: 'nome' },
        ],
        processing: true,
        serverSide: true,
        ajax: {
            url: url_path("/listar?form=cliente"),
            dataSrc: ""
        }
    })

});