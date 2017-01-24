<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>


<div class="container"  ng-app="testApp" ng-controller="myCtrl">
    <div class="page-header">
        <h2>Stock:</h2>
    </div>
    <div>
        <button id="click" class="btn btn-success">Update</button>
        <a href="<c:url value="/stockxml/createXml" />"
        ><button type="button" class="btn btn-success">Create report</button></a>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Product</th>
            <th>Units on Stock</th>
            <th>Good</th>
            <th>Faulty</th>
            <th>Action</th>
        </tr>
        </thead>
        <tr ng-repeat="s in site">
            <td>{{s.product.prodName}}</td>
            <td>{{s.productCount}}</td>
            <td>{{s.conditionGood}}</td>
            <td>{{s.conditionFaulty}}</td>
            <td><input type="button" value="save" ng-click="update()"/></td>
        </tr>
    </table>


</div>

<script src="<c:url value="/resources/js/sheetController.js" />"></script>