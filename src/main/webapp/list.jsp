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
                                <a href="<%=System.getProperty("BASE_URL")%>/register?form=<%=request.getParameter("m")%>" class="btn btn-delete">Insert</a>
                                <a href="<%=System.getProperty("BASE_URL")%>/register?form=<%=request.getParameter("m")%>" class="btn btn-delete">Update</a>
                                <button class="btn-delete" id="btn-delete">Delete</button>
                            </div>

                            <!-- Tabela DataTable-->
                            <table style="margin-top: 20px;" id="table_search">
                            
                            </table>
                        </div>
                    </div>
            </main>

            <!-- Market Menu -->
            <%@ include file="partials/buy.jsp" %>

        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/helpers.js"></script>
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/list/<%=request.getParameter("m")%>.js"></script>

<%@ include file="partials/footer.jsp" %>