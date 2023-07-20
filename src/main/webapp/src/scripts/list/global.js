$(document).ready(function() {

    $("#btn-insert").on("click", function() {
        window.location.href = $("#btn-update").attr("href");
    });

    $("#btn-update").on("click", function(){
        if ($(".select_row:checked").length == 0) {
            alert('You need to select a record')
            return;
        }
        if ($(".select_row:checked").length > 1) {
            alert('You can only select one record')
            return;
        }

        window.location.href = $("#btn-update").attr("href") + '&id=' + $(".select_row:checked").val();
    });

    $("#btn-delete").on("click", function() {
        const selectedRows = $(".select_row").serializeArray();
        const url = new URLSearchParams(window.location.search);

        if (selectedRows.length == 0) {
            alert('You need to select at least one record');
            return;
        }

        if (!confirm("Are you sure you want to delete selected records?")) {
            return;
        }

        selectedRows.forEach((selectedRow) => {
            url.append('delete[]', selectedRow.value);
        })
        redirect('/delete?' + url.toString());
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