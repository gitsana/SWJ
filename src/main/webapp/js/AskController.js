(function () {
    'use strict';

    var app = angular.module("SWJApp");

    var AskController = function ($scope, $http, $location) {

        var onQuestionCreated = function(response) {
            window.alert("You have successfully created a new question! Response.data: " + response.data);
            $scope.askTextarea = "";
            var createdQuestion = response.data;
            $location.path("/question/" + createdQuestion.id);
            // TODO now go to that question page #/question/:id --> get ID of question from response, which is not getting now.
        };

        var onError = function(reason) {
            $scope.error = "Error fetching data. Reason status: " + reason.status + ": " + reason.statusText;
        };

        $scope.askQuestion = function() {
            var askedQuestion = $scope.askTextarea;
            window.alert("You are asking this question: " + askedQuestion);
            var createDate = new Date();
            var newQuestion = {"fkMemberId":3, "created":createDate, "questionText":askedQuestion,
                views:0, likes:0};
            var jsonNewQuestion = JSON.stringify(newQuestion);
            $http.post("/rest/question/createQuestion/", jsonNewQuestion)
                .then(onQuestionCreated, onError);
        };
    };

    app.controller("AskController", AskController);

}());