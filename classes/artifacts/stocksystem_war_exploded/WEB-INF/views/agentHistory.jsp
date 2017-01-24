<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h2>Order History</h2>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Item</th>
            <th>Quantity</th>
            <th>Date Ordered</th>
            <th>Date Delivered</th>
        </tr>
        </thead>
        <c:forEach items="${agentHistoryList}" var="agentHistory">
            <tr>
                <td>${agentHistory.product.prodName}</td>
                <td>${agentHistory.orderQuantity}</td>
                <td>${agentHistory.currentTime}</td>
                <td>${agentHistory.modifiedTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

