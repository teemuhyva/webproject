<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container">
<div class="page-header">
    <h1>Modify user details</h1>
</div>

<form:form action="${pageContext.request.contextPath}/admin/customer/modifyCustomer" method="post"
           commandName="customer">
    <form:hidden path="customerId" value="${customer.customerId}" />
    <form:hidden path="password" value="${customer.password}"/>
    <h3>Update basic information</h3>

    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="customerName" id="name" class="form-control" value="${customer.customerName}" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input path="customerEmail" id="email" class="form-control" value="${customer.customerEmail}" />
    </div>
    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input path="customerPhone" id="phone" class="form-control" value="${customer.customerPhone}" />
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input path="Username" id="username" class="form-control" value="${customer.username}" />
    </div>

    <h3>Update address</h3>

    <div class="form-group">
        <label for="streetname">Street name</label>
        <form:select path="sAdd.streetName"  class="form-control">
            <form:option id="streetname" value="${customer.SAdd.streetName}" />
            <form:option id="streetname" value="Dawson's Street" />
            <form:option id="streetname" value="New century House" />
            <form:option id="streetname" value="Baggot Plaza" />
            <form:option id="streetname" value="Mespil Road" />
        </form:select>
    </div>
    <div class="form-group">
        <label for="building">Building number</label>
        <form:select path="sAdd.building" class="form-control">
            <form:option id="building" value="${customer.SAdd.building}" />
            <form:option id="building" value="9 - 12" />
            <form:option id="building" value="1" />
            <form:option id="building" value="2" />
            <form:option id="building" value="3" />
        </form:select>
    </div>
    <div class="form-group">
        <label for="city">City</label>
        <form:select path="sAdd.city" class="form-control">
            <form:option id="city" value="${customer.SAdd.city}" />
            <form:option id="city" value="Dublin" />
        </form:select>
    </div>
    <div class="form-group">
        <label for="country">Country</label>
        <form:select path="sAdd.country" class="form-control">
            <form:option id="country" value="${customer.SAdd.country}" />
            <form:option id="country" value="Ireland" />
        </form:select>
    </div>
    <div class="form-group">
        <label for="zipCode">Zip code</label>
        <form:select path="sAdd.zipCode" id="zipCode" class="form-control">
            <form:option id="zipcode" value="${customer.SAdd.zipCode}" />
            <form:option id="zipcode" value="1" />
            <form:option id="zipcode" value="2" />
            <form:option id="zipcode" value="3" />
            <form:option id="zipcode" value="4" />
        </form:select>
    </div>
    <br><br>
    <input type="submit" value="submit" class="btn btn-default">
    <a href="<c:url value="/admin/customer"/>" class="btn btn-default">Cancel</a>

</form:form>