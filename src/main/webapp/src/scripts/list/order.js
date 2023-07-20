$(document).ready(function() {
    const datatable = $("#table_search").DataTable({
        columns: [
            {
                title: 'Select',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="select[]" class="select_row" value="${row.cpf}" />`;
                },
                width: 30,
                orderable: false,
                class: "text-center"
            },
            { title: 'Order Number', data: 'numero' },
            { title: 'Issue Date', data: 'dataEmissao' },
            { title: 'Delivery Date', data: 'dataEntrega' },
            {
                title: 'Freight Value',
                render: function(data, type, row) {
                    return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3 }).format(data);
                },
                data: 'valorFrete'
            },
            {
                title: 'Total Value',
                render: function(data, type, row) {
                    return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3 }).format(data);
                },
                data: 'precoTotal'
            },
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