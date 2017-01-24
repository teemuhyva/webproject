<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp"%>

<div class="jumbotron">
    <div class="contaner">
        <h1>Stock</h1>

        <p>All the selected products in your order</p>
    </div>
</div>
<div class="contaner-wrapper">
    <div class="contaner">

        <section class="container" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear cart</a>
                    <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon">Check out</span></a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat = "item in cart.cartItems">
                        <td>{{item.product.prodName}}</td>
                        <td>{{item.quantity}}</td>
                        <td><a ng-click="removeFromCart(item.product.pId)"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove">Remove</span></button></a></td>
                    </tr>
                </table>
            <div>
                <a href="<spring:url value="/product/productCategory" /> " class="btn btn-default">Continue ordering</a>
            </div>

            </div>
        </section>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="template/footer.jsp"%>
