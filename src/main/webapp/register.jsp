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
                    <h1>
                        <%=request.getParameter("form")%> Register
                    </h1>
                    <hr>
                    <div class="box">
                        <% switch (request.getParameter("form")) {
                                case "user":
                                    %><%@ include file="form/user.jsp" %><%
                                break;
                                case "client":
                                    %><%@ include file="form/client.jsp" %><%
                                break;
                                case "product":
                                    %><%@ include file="form/product.jsp" %><%
                                break;
                                case "order":
                                    %><%@ include file="form/order.jsp" %><%
                                break;
                                default:
                                    %><%@ include file="form/error.jsp" %><%
                                break;
                        }
                        %>
                    </div>
                </div>
            </main>

            <!-- Market Menu -->
            <%@ include file="partials/buy.jsp" %>

        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

<%@ include file="partials/footer.jsp" %>