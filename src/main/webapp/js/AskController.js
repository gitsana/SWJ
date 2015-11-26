(function () {
    'use strict';

    var app = angular.module("SWJApp");

    var AskController = function ($scope) {
        $scope.test = "Test works";
    };

    app.controller("AskController", AskController);

}());