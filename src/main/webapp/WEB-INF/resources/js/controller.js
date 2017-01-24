/**
 * Created by Le on 1/11/2016.
 */

var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/stockreport/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/stockreport/rest/cart/'+$scope.cartId).success(
            $scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (pId) {
        $http.post('/stockreport/rest/cart/add/'+pId).success(function () {
            alert("Product successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function (pId) {
        $http.put('/stockreport/rest/cart/remove/'+pId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function() {
        var grandTotal = 0;

        for(var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalQuantity;
        }

        return grandTotal;
    };
});