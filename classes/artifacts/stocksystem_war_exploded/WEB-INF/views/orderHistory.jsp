<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Order History by Engineer</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Agent</th>
            <th>Email</th>
            <th>Site</th>
            <th>View Order</th>
        </tr>
        </thead>
        <c:forEach items="${orderHistoryList}" var="history" >
            <tr>
                <td>${history.customer.customerName}</td>
                <td>${history.customer.customerEmail}</td>
                <td>${history.sAddress.streetName}</td>
                <td><a href="<spring:url value="/admin/orderHistory/agentHistory/${history.customer.customerId}" />"
                ><button type="button" class="btn btn-info">View</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>