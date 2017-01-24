<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>


<div class="container">
  <div class="page-header">
    <p>Here is available stock for selected category</p>
  </div>
  <table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
      <th>Category</th>
      <th>In Stock</th>
    </tr>
    </thead>
    <c:forEach items="${categories}" var="categories">
      <tr>

        <td>${categories.productCategory}</td>
        <td><a href="<spring:url value="/product/viewStock/${categories.productCategory}" />"
                ><span class="glyphicon glyphicon-circle-arrow-right"></span></a></td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@include file="template/footer.jsp"%>