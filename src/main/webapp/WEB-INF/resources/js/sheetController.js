/**
 * Created by Teemu on 16/01/2017.
 */

angular.module('stockApp', [])
    .controller('stockCtrl', function($scope, $http) {
        $scope.sitedate = [];

        $http.get("/stockreport/rest/stocklist/retrievelocation").success(function (name) {

            var param = encodeURIComponent(name);
            $http.get("/stockreport/rest/stocklist/stocklistBySite?name=" + param).success(function(data) {
                $scope.streetName = name;
                $scope.sitedate = data;
                $scope.site = data;
            });

            $scope.increaseGood = function(uniquesite) {
                uniquesite.conditionGood++;
            };

            $scope.decreaseGood = function(uniquesite) {
                if(uniquesite.conditionGood > 0) {
                    uniquesite.conditionGood--;
                }
            };

            $scope.increaseFaulty = function(uniquesite) {
                uniquesite.conditionFaulty++;
            };

            $scope.decreaseFaulty = function(uniquesite) {
                if(uniquesite.conditionFaulty > 0) {
                    uniquesite.conditionFaulty--
                }
            };

            $scope.update = function(uniquesite) {
                $http.put( "/stockreport/rest/stocklist/stockpost", angular.toJson(uniquesite)
                ).success(function () {
                    $http.get("/stockreport/rest/stocklist/stocklistBySite?name=" + param).success(function(data) {
                        $scope.site = data;
                    });
                });
            };
        });


    });