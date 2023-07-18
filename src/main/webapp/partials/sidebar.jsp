 <!-- Sidebar Menu -->
 <aside class="col-12 col-md-2 py-2 sidebar-left">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="index.jsp">
                    <img src="src/img/beericon.png" alt="Icon" class="icon">
                    Home
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="search.jsp">
                    <!--
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    -->
                    <i class="fa-solid fa-magnifying-glass icon" alt="Icon"></i>
                    Users
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Register">
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    Clients
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    Products
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    Orders
                </a>
            </li>
            <%
                if (request.getSession().getAttribute("cpf") == null) {
            %>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/login">
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    Sign In
                </a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <a class="nav-link" href="<%=System.getProperty("BASE_URL")%>/logout">
                    <img src="src/img/whitelupa.png" alt="Icon" class="icon">
                    Logout
                </a>
            </li>
            <% } %>

        </ul>
    </div>
</aside>