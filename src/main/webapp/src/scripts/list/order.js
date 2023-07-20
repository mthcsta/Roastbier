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
            { title: 'Numero', data: 'numero' },
            { title: 'Data Emissao', data: 'dataEmissao' },
            { title: 'Data Entrega', data: 'dataEntrega' },
            { title: 'Valor Frete', data: 'valorFrete' },
            { title: 'Client Name', data: 'cliente.nome' },
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