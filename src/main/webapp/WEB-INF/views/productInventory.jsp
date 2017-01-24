<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product admin page</h1>
        </div>
        <a href="<spring:url value="/admin/product/addProduct"/>" class="btn btn-primary"> Add product</a>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Category</th>
                <th>Item</th>
                <th>Manufacturer</th>
                <th>In Stock</th>
                <th>info/update/remove</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <c:choose>
                    <c:when  test="${product.unitCount < 10 && product.unitCount > 0}">
                        <tr style="background-color: #ffff00">
                            <td><img src="<c:url value="/resources/images/${product.pId}.png" />" alt="image" style="width: 60%"></td>
                            <td>${product.productCategory}</td>
                            <td>${product.prodName}</td>
                            <td>${product.productManufacturer}</td>
                            <td>${product.unitCount}</td>
                            <td><a href="<spring:url value="/product/viewDetails/${product.pId}" />"
                            ><span class="glyphicon glyphicon-circle-arrow-right"></span></a>
                                <a href="<spring:url value="/admin/product/deleteProduct/${product.pId}" />"
                                ><span class="glyphicon glyphicon-remove"></span></a>
                                <a href="<spring:url value="/admin/product/updateProduct/${product.pId}" />"
                                ><span class="glyphicon glyphicon-scissors"></span></a>
                            </td>
                        </tr>
                    </c:when>
                    <c:when  test="${product.unitCount < 0}">
                    <tr style="background-color: #f3ada5">
                        <td><img src="<c:url value="/resources/images/${product.pId}.png" />" alt="image" style="width: 60%"></td>
                        <td>${product.productCategory}</td>
                        <td>${product.prodName}</td>
                        <td>${product.productManufacturer}</td>
                        <td>${product.unitCount}</td>
                        <td><a href="<spring:url value="/product/viewDetails/${product.pId}" />"
                            ><span class="glyphicon glyphicon-circle-arrow-right"></span></a>
                            <a href="<spring:url value="/admin/product/deleteProduct/${product.pId}" />"
                            ><span class="glyphicon glyphicon-remove"></span></a>
                            <a href="<spring:url value="/admin/product/updateProduct/${product.pId}" />"
                            ><span class="glyphicon glyphicon-scissors"></span></a>
                        </td>
                    </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><img src="<c:url value="/resources/images/${product.pId}.png" />" alt="image" style="width: 60%"></td>
                            <td>${product.productCategory}</td>
                            <td>${product.prodName}</td>
                            <td>${product.productManufacturer}</td>
                            <td>${product.unitCount}</td>
                            <td><a href="<spring:url value="/product/viewDetails/${product.pId}" />"
                            ><span class="glyphicon glyphicon-circle-arrow-right"></span></a>
                                <a href="<spring:url value="/admin/product/deleteProduct/${product.pId}" />"
                                ><span class="glyphicon glyphicon-remove"></span></a>
                                <a href="<spring:url value="/admin/product/updateProduct/${product.pId}" />"
                                ><span class="glyphicon glyphicon-scissors"></span></a>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </table>

    </div>

</div>


<%@include file="template/footer.jsp"%>

