<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="contaner-wrapper">
  <div class="contaner">
    <section>
      <div class="jumbotron">
        <div class="contaner">
          <h1>Invalid cart</h1>
        </div>
      </div>
    </section>
    <section class="container">
      <p>
        <a href="<spring:url value="/product/viewStock" /> " class="btn btn-default">products</a>
      </p>
    </section>
  </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
