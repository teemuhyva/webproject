<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="contaner-wrapper">
  <div class="contaner">
    <section>
      <div class="jumbotron">
        <div class="contaner">
          <h1 class="alert-danger">Checkout canceled</h1>

          <p>Your check out process is cancelled</p>
        </div>
      </div>
    </section>
    <section class="container">
      <p>
        <a href="<spring:url value="/product/productCategory" /> " class="btn btn-default">Products</a>
      </p>
    </section>
  </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
