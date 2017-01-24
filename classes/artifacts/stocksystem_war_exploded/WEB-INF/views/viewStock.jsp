<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Click icon to see how many available items it has</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
            <tr class="bg-success">
                <th>Product</th>
                <th>Make</th>
                <th>Category</th>
                <th>More info</th>
            </tr>
        </thead>
        <c:forEach items="${categories}" var="categories">
            <tr>
                <td>${categories.prodName}</td>
                <td>${categories.productManufacturer}</td>
                <td>${categories.productCategory}</td>
                <td><a href="<spring:url value="/product/viewDetails/${categories.pId}" />"
                    ><span class="glyphicon glyphicon-circle-arrow-right"></span></a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

    <hr>

 <%@include file="template/footer.jsp"%>

