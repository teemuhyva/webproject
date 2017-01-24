<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>My Order History</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Item</th>
            <th>Ordered for site</th>
            <th>Quantity</th>
            <th>Date Ordered</th>
            <th>Date Closed</th>
        </tr>
        </thead>
        <c:forEach items="${myhistory}" var="myhistory">
            <tr>
                <fmt:parseDate value="${myhistory.currentTime}" pattern="yyyy-MM-dd HH:mm" var="current"/>
                <fmt:parseDate value="${myhistory.modifiedTime}" pattern="yyyy-MM-dd HH:mm" var="modified"/>
                <td>${myhistory.product.prodName}</td>
                <td>${myhistory.site.siteName}</td>
                <td>${myhistory.orderQuantity}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${current}" /></td>
                <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${modified}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

