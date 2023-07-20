$(document).ready(function() {
    const datatable = $("#table_search").DataTable({
        columns: [
            {
                title: 'Selecionar',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="select[]" class="select_row" value="${row.cpf}" />`;
                },
                width: 30,
                orderable: false,
                class: "text-center"
            },
            { title: 'CPF', data: 'cpf' },
            { title: 'Name', data: 'nome' },
            { title: 'Birthday', data: 'dataNascimento' },
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
        columnDefs: [{ targets: 0, orderable: false}],
        order: [[ 2, 'asc' ]],
        data: [],
        searching: false,
        responsive: true,
        scrollCollapse: true,
        deferRender: true,
    });

    $("#table_search").on('fill-table', function (event, obj) {
        datatable.clear().rows.add(obj.data).draw(false);
    });

    $("#btn-filter").trigger('click');

});