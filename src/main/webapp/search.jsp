<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="partials/header.jsp" %>
<div class="all-content-container">

    <!-- Top Menu -->
    <%@ include file="partials/menubar.jsp" %>

    <div class="container-fluid">
        <div class="row">

            <!-- Sidebar Menu -->
            <%@ include file="partials/sidebar.jsp" %>

            <!-- Main Content -->
            <main role="main" class="col-md-8 bg-roastbier-main">
                <div class="container">
                    <br>
                    <h1><img src="src/img/lupa.png" alt="Icon" class="icon">Seach</h1>
                    <hr>
                    <div class="box">

                        <div>
                            <div style="overflow: hidden;">
                                <label for="sigla" style="float: left; margin-right: 10px;">Filter: </label>
                                <a class="btnfilter" href="#" style="background-color: black; color: white; border: none; border-radius: 5px; padding: 10px 20px; float: right;">Filter</a>
                            </div>
                            <input type="text" name="Filter" id="filter" style="width: 50%;" placeholder="Type the filter">

                            <div>
                                <button class="btn-insert" onclick="window.location.href = 'register.html';">Insert</button>
                                <button class="btn-update" onclick="window.location.href = 'register.html';">Update</button>
                                <button class="btn-delete">Delete</button>
                            </div>

                            <table style="margin-top: 20px;">
                                <thead>
                                <tr>
                                    <th>Seleção</th>
                                    <th>Coluna 1</th>
                                    <th>Coluna 2</th>
                                    <th>Coluna 3</th>
                                    <th>Coluna 4</th>
                                    <th>Coluna 5</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><input type="checkbox" style="margin-left: 5px;"></td>
                                    <td>Valor 1</td>
                                    <td>Valor 2</td>
                                    <td>Valor 3</td>
                                    <td>Valor 4</td>
                                    <td>Valor 5</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" style="margin-left: 5px;"></td>
                                    <td>Valor 1</td>
                                    <td>Valor 2</td>
                                    <td>Valor 3</td>
                                    <td>Valor 4</td>
                                    <td>Valor 5</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" style="margin-left: 5px;"></td>
                                    <td>Valor 1</td>
                                    <td>Valor 2</td>
                                    <td>Valor 3</td>
                                    <td>Valor 4</td>
                                    <td>Valor 5</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" style="margin-left: 5px;"></td>
                                    <td>Valor 1</td>
                                    <td>Valor 2</td>
                                    <td>Valor 3</td>
                                    <td>Valor 4</td>
                                    <td>Valor 5</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div>
            </main>

            <!-- Market Menu -->
            <%@ include file="partials/buy.jsp" %>

        </div>
    </div>
</div>
<%@ include file="partials/footer.jsp" %>