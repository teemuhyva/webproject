<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<scrip>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


    <!-- Angular js -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" ></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

    <script src="<c:url value="/resources/js/main.js" /> "></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Stock tool</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/home"/> ">Home</a></li>
                <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <li><a href="<c:url value="/admin/siteList"/>">Sites</a></li>
                    <li><a href="<c:url value="/admin/orders"/>">Orders</a></li>
                    <li><a href="<c:url value="/admin/orderHistory"/>">Order history</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>
                        <li><a href="<c:url value="/customer/cart/myOrder" />">My Order</a></li>
                        <li><a href="<c:url value="/customer/cart/myHistory" />">My History</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="<c:url value="/admin"/>">Admin</a></li>
                    </c:if>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="<c:url value="/login" /> ">Login</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>