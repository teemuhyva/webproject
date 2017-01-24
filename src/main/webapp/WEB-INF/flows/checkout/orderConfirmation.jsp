<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<jsp:useBean id="now" class="java.util.Date" />

<div class="container">
  <div class="page-header">
    <h1>Order</h1>

    <p>Order confirmation</p>
  </div>

  <div class="container">
    <div class="row">

    <form:form commandName="order" class="form-horizontal">

      <div class="well col-xs-10 col-sm10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

        <div class="text-center">
          <h1>Receipt</h1>
        </div>
        <div class="row">
          <div class="col-xs-6 col-sm-6 col-md-6">
            <address>
              <strong>Shipping address</strong><br>
                ${order.cart.customer.SAdd.streetName}
              <br>
                ${order.cart.customer.SAdd.building}
              <br>
                ${order.cart.customer.SAdd.city}
            </address>
          </div>
          <div class="col-xs-6 col-sm-6 col-md-6 text-right">
            <p>Shipping Date: <fmt:formatDate type="date" value="${now}"/></p>
          </div>
        </div>
        <div class="row">
          <table class="table table-hover">
            <thead>
              <tr>
                <td>Product</td>
                <td>#</td>
                <td class="text-center">Total</td>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="cartItem" items="${order.cart.cartItems}">
                <tr>
                  <td class="col-md-9"><em>${cartItem.product.prodName}</em></td>
                  <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                </tr>
              </c:forEach>
              <tr>
                <td></td>
                <td></td>
                <td class="text-right">
                  <h4><strong>grand total: </strong></h4>
                </td>
                <td class="text-center text-danger">
                  <h4><strong>${order.cart.grandTotal}</strong></h4>
                </td>
              </tr>
            </tbody>
          </table>
        </div>

      <input type="hidden" name="_flowExecutionKey" />

      <br><br>
      <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
      <input type="submit" value="Submit order" class="btn btn-default" name="_eventId_orderConfirmed" />
      <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </div>
      </form:form>
      </div>
    </div>
</div>