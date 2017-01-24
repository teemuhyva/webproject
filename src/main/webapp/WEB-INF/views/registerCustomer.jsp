<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container">
  <div class="page-header">
    <h1>Register</h1>

    <p>Please fill your details below for registration</p>
  </div>

  <form:form action="${pageContext.request.contextPath}/register" method="post"
             commandName="customer">

  <h3>Basic information</h3>

  <div class="form-group">
    <label for="name">Name</label><form:errors path="customerName" cssStyle="color: #ff0000" />
    <form:input path="customerName" id="name" class="form-control" />
  </div>
  <div class="form-group">
    <label for="email">Email</label><span style="color: #ff0000">${emailMsg}</span><form:errors path="customerEmail" cssStyle="color: #ff0000" />
    <form:input path="customerEmail" id="email" class="form-control" />
  </div>
  <div class="form-group">
    <label for="phone">Phone</label>
    <form:input path="customerPhone" id="phone" class="form-control" />
  </div>
  <div class="form-group">
    <label for="username">Username</label><span style="color: #ff0000">${usernameMsg}</span><form:errors path="username" cssStyle="color: #ff0000" />
    <form:input path="Username" id="username" class="form-control" />
  </div>
  <div class="form-group">
    <label for="password">Password</label><form:errors path="password" cssStyle="color: #ff0000" />
    <form:input path="password" id="password" type="password" class="form-control" />
  </div>

  <h3>Shipping address</h3>

  <div class="form-group">
      <label for="streetname">Street name</label>
      <form:select path="sAdd.streetName"  class="form-control">
        <form:option id="streetname" value="" />
        <form:option id="streetname" value="Dawson's Street" />
        <form:option id="streetname" value="New century House" />
        <form:option id="streetname" value="Baggot Plaza" />
        <form:option id="streetname" value="Mespil Road" />
      </form:select>
    </div>
    <div class="form-group">
      <label for="building">Building number</label>
      <form:select path="sAdd.building" class="form-control">
        <form:option id="building" value="" />
        <form:option id="building" value="9 - 12" />
        <form:option id="building" value="1" />
        <form:option id="building" value="2" />
        <form:option id="building" value="3" />
      </form:select>
    </div>
    <div class="form-group">
      <label for="city">City</label>
      <form:select path="sAdd.city" class="form-control">
        <form:option id="city" value="" />
        <form:option id="city" value="Dublin" />
      </form:select>
    </div>
    <div class="form-group">
      <label for="country">Country</label>
      <form:select path="sAdd.country" class="form-control">
        <form:option id="country" value="" />
        <form:option id="country" value="Ireland" />
      </form:select>
    </div>
    <div class="form-group">
      <label for="zipCode">Zip code</label>
      <form:select path="sAdd.zipCode" id="zipCode" class="form-control">
        <form:option id="zipcode" value="" />
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
