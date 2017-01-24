<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Order information</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Item</th>
            <th>Ordered for site</th>
            <th>Quantity</th>
            <th>Date Ordered</th>
        </tr>
        </thead>
        <c:forEach items="${myOrder}" var="myorder">
            <tr>
                <fmt:parseDate value="${myorder.currentTime}" pattern="yyyy-MM-dd HH:mm" var="current"/>
                <td>${myorder.product.prodName}</td>
                <td>${myorder.product.productManufacturer}</td>
                <td>${myorder.orderQuantity}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${current}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

