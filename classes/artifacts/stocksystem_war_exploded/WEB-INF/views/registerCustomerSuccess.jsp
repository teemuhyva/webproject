<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp"%>

<div class="contaner-wrapper">
  <div class="contaner">
    <section>
      <div class="jumbotron">
        <div class="contaner">
          <h1>Stock</h1>

          <p>Customer registered successfully</p>
        </div>
      </div>
    </section>
    <section class="container">
      <p>
        <a href="<spring:url value="/admin/customer" /> " class="btn btn-default">login</a>
      </p>
    </section>
  </div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="template/footer.jsp"%>
