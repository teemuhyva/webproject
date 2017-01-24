<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>All orders from Deskside engineers</h1>
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
        <c:forEach items="${customerOrderList}" var="customerOrderList" >
            <tr>
                <td>${customerOrderList.customer.customerName}</td>
                <td>${customerOrderList.customer.customerEmail}</td>
                <td>${customerOrderList.sAddress.streetName}</td>
                <td><a href="<spring:url value="/admin/orders/agentOrder/${customerOrderList.customer.customerId}" />"
                        ><button type="button" class="btn btn-info">View</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

