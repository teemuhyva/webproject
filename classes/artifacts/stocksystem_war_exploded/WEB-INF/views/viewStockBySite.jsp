<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>


<div class="container"  ng-app="stockApp" ng-controller="stockCtrl">
  <div class="page-header">
    <h3>Stock: {{streetName}}</h3>
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
        <th>Last modified</th>
        <th>Action</th>
      </tr>
    </thead>
      <tr>
    <tr ng-repeat="uniquesite in site">
      <td>{{uniquesite.product.prodName}}</td>
      <td>{{uniquesite.productCount}}</td>
      <td>
        <input type="button" value="+" ng-click="increaseGood(uniquesite)"/>
        {{uniquesite.conditionGood}}
        <input type="button" value="-" ng-click="decreaseGood(uniquesite)"/>
      <td>
        <input type="button" value="+" ng-click="increaseFaulty(uniquesite)"/>
        {{uniquesite.conditionFaulty}}
        <input type="button" value="-" ng-click="decreaseFaulty(uniquesite)"/>
      </td>
      <td>{{uniquesite.modifiedTime | date: 'dd-MM-yyyy HH:mm:ss'}}</td>
      <td><input type="button" value="save" ng-click="update(uniquesite)"/></td>
    </tr>
  </table>


</div>

<script src="<c:url value="/resources/js/sheetController.js" />"></script>