$(document).ready(function() {
    const datatable = $("#table_search").DataTable({
        columns: [
            {
                title: 'Selecionar',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="select[]" class="select_row" value="${row.id}" />`;
                },
                width: 30,
                orderable: false,
                class: "text-center"
            },
            { title: 'Name', data: 'nome' },
            { title: 'Unity', data: 'unidade' },
            { title: 'Unitary Price', data: 'precoUnitario' },
            { title: 'Description', data: 'descricao' },
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