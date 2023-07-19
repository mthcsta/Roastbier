<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>RoastBier - Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">



    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="src/style/signin.css">

    <script>
        const BASE_URL = "<%=System.getProperty("BASE_URL")%>";
    </script>

</head>
<body class="text-center">

<main class="form-signin">
    <form method="post" id="form_login">
        <div class="bg-warning d-inline-block mb-4 p-3 border border-1 rounded" style="">
            <img class="" src="src/img/beericon.png" alt="" width="57" height="57">
        </div>

        <h1 class="h3 mb-3 fw-normal">Sign in</h1>

        <div class="alert alert-danger my-3 text-start d-none" id="form_login_message"></div>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" name="username" placeholder="Username">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" data-btn-loading="false" type="submit" id="form_button_submit">
            <div data-btn-content="normal">
                Connect
            </div>
            <div data-btn-content="loading">
                <span class="spinner-border spinner-border-sm me-3"></span>
                Connecting...
            </div>
        </button>

        <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
    </form>
</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/helpers.js"></script>
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/helpers.jquery.js"></script>
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/auth/login.js"></script>

</body>
</html>
