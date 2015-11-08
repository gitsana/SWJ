(function() {

    // STEP 1 - create the module with a name
    var app = angular.module("SWJ_home", []);

    var MainController = function($scope, $http) {
        $scope.title = "SawalJawab";

        var onError = function(reason) {
            $scope.error = "Error getting the data";
        };

        var onGetQuestions = function(response) {
            $scope.questions = response.data;
        };

        $http.get("/rest/question/all")
            .then(onGetQuestions, onError);
    };

    // STEP 2 - register the controllers in the module
    app.controller("MainController", MainController);

    // STEP 3 - [put ng-app="SWJ_home" into HTML page]

}());