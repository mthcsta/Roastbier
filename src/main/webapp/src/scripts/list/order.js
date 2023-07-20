$(document).ready(function() {
    const datatable = $("#table_search").DataTable({
        columns: [
            {
                title: 'Select',
                render: function(data, type, row) {
                    return `<input type="checkbox" name="select[]" class="select_row" value="${row.numero}" />`;
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
            {   
                title: 'Action',
                className: 'dt-control',
                orderable: false,
                data: null,
                defaultContent: ''
            },
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

    $("#table_search").on('click', 'td.dt-control', function (e) {
        let tr = e.target.closest('tr');
        let row = datatable.row(tr);
     
        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
        }
    });
});
function formatTr(productData) {
    return `
    <tr>
        <td>${productData.produto.nome}</td>
        <td>${new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2, maximumFractionDigits: 3 }).format(productData.precoUnitario)}</td>
        <td>${productData.quantidade}</td>
    </tr>
    `
}
function format(data) {
    const tr = data.produtoHasPedidos.map(formatTr).join("");
    return (
        `
        <table class="table table-bordered">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Value</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            ${tr}
        </tbody>
        </table>
        `
    );
}

