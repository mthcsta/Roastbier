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
            <p>Everything was saved in the data base!</p>
            <button class="btn-insert" onclick="window.location.href = 'search.html';">Back to search page</button>
          </div>

        </div>
      </main>

      <!-- Market Menu -->
      <%@ include file="partials/buy.jsp" %>

    </div>
  </div>
</div>
<%@ include file="partials/footer.jsp" %>