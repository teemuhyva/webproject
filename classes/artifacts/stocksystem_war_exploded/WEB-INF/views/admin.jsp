<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

        <h3>
           <a href="<c:url value="/admin/productInventory" />">Product inventory</a>
        </h3>

        <p class="lead">Remove, add and modify products and details</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customer" />">Customer management</a>
        </h3>

        <p>View customer information</p>
    </div>


</div>

<%@include file="template/footer.jsp"%>




