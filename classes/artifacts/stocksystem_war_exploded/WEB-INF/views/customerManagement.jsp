<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Customer management page</h1>

        <p class="lead">Customer management page</p>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
        <a href="<c:url value="/register" /> "><button type="button" class="btn btn-success">New user</button></a>
    </c:if>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Site</th>
            <th>enabled</th>
            <th>Modify</th>
            <th>Remove</th>
        </tr>
        </thead>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.customerName}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerPhone}</td>
                <td>${customer.SAdd.streetName}</td>
                <td>${customer.enabled}</td>
                <td><a href="<spring:url value="/admin/customer/modifyCustomer/${customer.customerId}" />"
                ><button type="button" class="btn btn-warning">Modify</button></a></td>
                <td><a href="<spring:url value="/admin/customer/removeCustomer/${customer.customerId}" />"
                ><button type="button" class="btn btn-danger">Remove</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

