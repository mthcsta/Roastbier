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
                    <h1 class="title">
                        <%=request.getParameter("form")%> <%=((boolean) request.getAttribute("update")) ? "Update" : "Register" %>
                    </h1>
                    <hr>
                    <div class="box">
                        <% switch (request.getParameter("form")) {
                            case "user":
                                %><jsp:include page="form/user.jsp" /><%
                                break;
                            case "client":
                                %><jsp:include page="form/client.jsp" /><%
                                break;
                            case "product":
                                %><jsp:include page="form/product.jsp" /><%
                                break;
                            case "order":
                                %><jsp:include page="form/order.jsp" /><%
                                break;
                            default:
                                %><jsp:include page="form/error.jsp" /><%
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
<script src="https://cdn.jsdelivr.net/npm/inputmask@5.0.8/dist/jquery.inputmask.min.js"></script>


<%@ include file="partials/footer.jsp" %>