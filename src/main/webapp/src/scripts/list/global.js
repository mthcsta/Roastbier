$(document).ready(function() {

    $("#btn-insert").on("click", function() {
        window.location.href = $("#btn-update").attr("href") + '&id=' + $(".select_row:checked").val();
    });

    const updateUrl = $("#btn-update").attr("href");

    $("#btn-update").on("click", function(){
        if ($(".select_row:checked").length == 0) {
            alert('Você precisa selecionar um registro')
            return;
        }
        if ($(".select_row:checked").length > 1) {
            alert('Você só pode selecionar 1 registro')
            return;
        }

        window.location.href = $("#btn-update").attr("href") + '&id=' + $(".select_row:checked").val();
    });

    $("#btn-delete").on("click", function() {
        $(".select_row").serializeArray();
    });

    $("#btn-filter").on('click', function() {
        const filterValue = $("#filter-value").val();
        const filterModel = $(this).data("model");
        $.ajax({
            url: url_path("/ajax/list?m=" + filterModel),
            type: "GET",
            dataType:"json",
            data: { search: filterValue },
            success: function(data) {
                $("#table_search").trigger('fill-table', {data});
            }
        });
    });

});