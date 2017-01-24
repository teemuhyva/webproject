<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

      <div class="jumbotron">
        <div class="contaner">
          <h1>Thank you for ordering</h1>

          <p>Your order will be shipped soon</p>
        </div>
      </div>
    <section class="container">
      <p>
        <a href="<spring:url value="/home" /> " class="btn btn-default">OK</a>
      </p>
    </section>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
