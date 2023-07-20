 <!-- Sidebar Menu -->
 <aside class="col-12 col-md-2 py-2 sidebar-left">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <%
                if (request.getSession().getAttribute("cpf") != null) {
            %>
            <li class="nav-item">
                <div class="p-1">Welcome, <%=request.getSession().getAttribute("nome")%></div>
            </li>
            <% } %>

            <li class="nav-item">
                <a class="nav-link active" href="<%=System.getProperty("BASE_URL")%>/">
                    <i class="fa-solid fa-beer-mug-empty pe-3"></i>
                    Home
                </a>
            </li>            
            <%
                if (request.getSession().getAttribute("cpf") == null) {
            %>
            <li class="nav-item">
                <a class="nav-link bg-success" href="<%=System.getProperty("BASE_URL")%>/login">
                    <i class="fa fa-sign-in pe-3" aria-hidden="true"></i>
                    Sign In
                </a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/list?m=user">
                    <i class="fa-solid fa-user pe-3"></i>
                    Users
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/list?m=client">
                    <i class="fa-solid fa-people-group pe-3"></i>
                    Clients
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/list?m=product">
                    <i class="fa-solid fa-wheat-awn pe-3"></i>
                    Products
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/list?m=order">
                    <i class="fa-solid fa-truck pe-3"></i>
                    Orders
                </a>
            </li>                
            <li class="nav-item">
                <a class="nav-link bg-danger" href="<%=System.getProperty("BASE_URL")%>/logout">
                    <i class="fa fa-sign-in pe-3" aria-hidden="true"></i>
                    Logout
                </a>
            </li>
            <% } %>

        </ul>
    </div>
</aside>