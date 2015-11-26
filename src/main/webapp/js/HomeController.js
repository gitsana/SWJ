(function() {

    'use strict';
    var app = angular.module("SWJApp");

    var HomeController = function($scope, $http) {
        $scope.title = "Top Questions on SawalJawab";

        var onError = function(reason) {
            $scope.error = "Error getting the data. Reason is: " + reason.status + ": " + reason.statusText;
        };

        var onGetQuestions = function(response) {
            $scope.questions = response.data;
        };

        $http.get("/rest/question/all")
            .then(onGetQuestions, onError);
    };

    app.controller("HomeController", HomeController);

}());