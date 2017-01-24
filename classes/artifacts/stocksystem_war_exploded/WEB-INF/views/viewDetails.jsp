<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container" ng-app="cartApp">
    <div class="page-header">
        <h1>Product Details</h1>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${product.pId}.png" /> "  style="height: 300px; width: 300px" />
            </div>
            <div class="col-md-5">
                <h3>Product : ${product.prodName}</h3>
                <p>Manufacturer : ${product.productManufacturer}</p>
                <p>Details : ${product.productDetails}</p>
                <p>Available :
                    <c:choose>
                        <c:when test="${product.unitCount < 0}"><strong>awaiting more stock<strong></c:when>
                        <c:otherwise>${product.unitCount}</c:otherwise>
                    </c:choose>
                <br>

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="url" scope="page" value="/product/productCategory" />
                    </c:otherwise>
                </c:choose>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                    <a href="#" class="btn btn-warning" ng-click="addToCart('${product.pId}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order</a>
                    <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-circle-arrow-right"></span> View Cart</a>
                </p>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="template/footer.jsp"%>