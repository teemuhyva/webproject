<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
  <div class="page-header">
    <h1>Shipping details</h1>

    <p>Fill shipping details</p>
  </div>

  <form:form commandName="order" class="form-horizontal">

  <h3>Shipping address</h3>

  <div class="form-group">
    <label for="streetname">Street name</label>
    <form:input path="cart.customer.sAdd.streetName" id="streetname" class="form-control" />
  </div>
  <div class="form-group">
    <label for="building">Building number</label>
    <form:input path="cart.customer.sAdd.building" id="building" class="form-control" />
  </div>
  <div class="form-group">
    <label for="city">City</label>
    <form:input path="cart.customer.sAdd.city" id="city" class="form-control" />
  </div>
  <div class="form-group">
    <label for="country">Country</label>
    <form:input path="cart.customer.sAdd.country" id="country" class="form-control" />
  </div>
  <div class="form-group">
    <label for="zipCode">Zip code</label>
    <form:input path="cart.customer.sAdd.zipCode" id="zipCode" class="form-control" />
  </div>

  <input type="hidden" name="_flowExecutionKey" />

  <br><br>
  <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
  <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />
  <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

  </form:form>
