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
                            <div class="d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center">
                                    <label for="sigla" style="float: left; margin-right: 10px;">Filter: </label>
                                    <input type="text" name="Filter" id="filter-value" class="form-control" placeholder="Type the filter">
                                </div>
                                <button class="btn btn-primary" id="btn-filter" data-model="<%=request.getParameter("m")%>">Filter</button>
                            </div>

                            <div>
                                <button href="<%=System.getProperty("BASE_URL")%>/register?form=<%=request.getParameter("m")%>" class="btn btn-success" id="btn-insert">Insert</button>
                                <button href="<%=System.getProperty("BASE_URL")%>/register?form=<%=request.getParameter("m")%>" class="btn btn-warning" id="btn-update">Update</button>
                                <button class="btn btn-danger" id="btn-delete">Delete</button>
                            </div>

                            <!-- Tabela DataTable-->
                            <div class="table-responsive mt-3">
                                <table id="table_search" class="display" cellspacing="0" width="100%"></table>
                            </div>

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
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/list/global.js"></script>
<script src="<%=System.getProperty("BASE_URL")%>/src/scripts/list/<%=request.getParameter("m")%>.js"></script>

<%@ include file="partials/footer.jsp" %>