$(document).ready(function() {

    $("#form_login").on('submit', function(event) {
        event.preventDefault();
        event.stopPropagation();


        $.ajax({
            url: url_path('/login'),
            dataType: 'json',
            type: 'POST',
            data: $(this).serialize(),
            success: function(data) {
                if (data.success == 1) {
                    redirect('/');
                }

                $("#form_login_message").removeClass("d-none").html(data.message);
            }
        });

    });

});