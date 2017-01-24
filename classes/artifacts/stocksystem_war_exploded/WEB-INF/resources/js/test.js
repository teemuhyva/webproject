/**
 * Created by Matty on 15/01/2017.
 */

/*
angular.module('myTestApp', [])
    .controller('myTestCtrl', function($scope) {

        $scope.this.testGood = {
            good: '',
            bad: ''
        };

        $scope.this.completed = function() {
            console.log("value now is ", this.good + " " + this.bad);
        }

    });

 */

var app = angular.module('myTestApp', []);
app.controller('myTestCtrl', function($scope) {
   $scope.name = "Teemu"
    $scope.changeName = function() {
        $scope.name = "Saara";
    }
});