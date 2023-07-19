$(document).ready(function() {

    $("#form_login").on('submit', async function(event) {
        event.preventDefault();
        event.stopPropagation();

        // Animação de Loading
        $("#form_button_submit").trigger('loading');
        await new Promise((resolve) => setTimeout(resolve, 500));

        $.ajax({
            url: url_path('/login'),
            dataType: 'json',
            type: 'POST',
            data: $(this).serialize(),
            success: function(data) {
                $("#form_button_submit").trigger('loaded');
                if (data.success == 1) {
                    redirect('/');
                    return;
                }
                $("#form_login_message").removeClass("d-none").html(data.message);
            }
        });

    });

});