<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Order information</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Item</th>
            <th>Gategory</th>
            <th>Manufacturer</th>
            <th>Quantity</th>
            <th>Date Ordered</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${agentOrder}" var="agentOrder">
            <tr>
                <td>${agentOrder.product.prodName}</td>
                <td>${agentOrder.product.productCategory}</td>
                <td>${agentOrder.product.productManufacturer}</td>
                <td>${agentOrder.orderQuantity}</td>
                <td>${agentOrder.currentTime}</td>
                <td><a href="<spring:url value="/admin/orders/clearOrderById/${agentOrder.customerOrderId}" />"
                ><button type="button" class="btn btn-danger">Completed</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

