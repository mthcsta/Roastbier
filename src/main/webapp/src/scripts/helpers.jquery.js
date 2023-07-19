$(document).ready(function(){

    $("[data-btn-loading]").on('loading', function() {
        $(this).attr("data-btn-loading", "true").attr("disabled", "true");
    }).on('loaded', function() {
        $(this).attr("data-btn-loading", "false").removeAttr("disabled");
    });

});