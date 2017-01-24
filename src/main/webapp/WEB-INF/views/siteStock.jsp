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
      <td>Product Name</td>
      <td>Total count</td>
      <td>Good</td>
      <td>Faulty</td>
    </tr>
    </thead>
    <c:forEach items="${siteStock}" var="siteStock">
      <tr>
        <td>${siteStock.product.prodName}</td>
        <td>${siteStock.productCount}</td>
        <td>${siteStock.conditionGood}</td>
        <td>${siteStock.conditionFaulty}</td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@include file="template/footer.jsp"%>