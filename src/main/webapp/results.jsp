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
          <h1>Results</h1>
          <hr>

          <div class="box">
            <p><%=request.getAttribute("message")%></p>
            <% if (request.getAttribute("error") == null) { %>
            <a class="btn btn-secondary" href="<%=System.getProperty("BASE_URL")%>/list?m=<%=request.getParameter("m")%>">Back</a>
            <% } else { %>
            <a class="btn btn-secondary" href="javascript:history.back();">Back</a>
            <% } %>
          </div>

        </div>
      </main>

      <!-- Market Menu -->
      <%@ include file="partials/buy.jsp" %>

    </div>
  </div>
</div>
<%@ include file="partials/footer.jsp" %>