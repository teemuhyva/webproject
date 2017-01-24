<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Create weekly and monthly stock report and order / view stock available</h1>
        <p>Create stock reports quickly and without using excel files. Also you can request stock for site and review stock currently available</p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-6">
            <h2>View and order stock</h2>
            <p>View and order stock here</p>
            <p><a class="btn btn-default" href="<c:url value="/product/productCategory"/> " role="button">Order&raquo;</a></p>
        </div>
        <div class="col-md-6">
            <h2>My Stock</h2>
            <p>Not sure what you got on inventory, review from here</p>
            <p>
                <c:if test="${pageContext.request.userPrincipal.name != 'admin'}" >
                    <a class="btn btn-default" role="button" href="<c:url value="/stockxml/viewStockByUserLocation" />">View</a>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == 'admin'}" >
                    <a class="btn btn-default" role="button" href="<c:url value="/admin/siteList" />">View</a>
                </c:if>
            </p>
        </div>
        <div class="col-md-6">
            <h2>Weekly Report</h2>
            <p>Create weekly report from your stock</p>
            <p><a class="btn btn-default" href="#" role="button">Create</a></p>
        </div>
        <div class="col-md-6">
            <h2>Monthly Report</h2>
            <p>Create montly stock here</p>
            <p><a class="btn btn-default" href="#" role="button">Create</a></p>
        </div>
    </div>

<%@include file="template/footer.jsp"%>