(function() {

    'use strict';
    var app = angular.module("SWJApp");

    var QuestionController = function($scope, $http, $routeParams) {

        $scope.enterAnswer = function() {
            var userAnswer = $scope.answerTextarea;
            window.alert("You are entering this answer:<br>" + userAnswer);
            var createDate = new Date();
            var newAnswer = {'fkQuestionId':questionId, 'fkMemberId':'1', 'created':createDate,
                'answerText':userAnswer, 'likes':'0'};
            var newAnswerJson = JSON.stringify(newAnswer);
            $http.post("/rest/answer/createAnswer/", newAnswerJson)
                .then(onAnswerCreated, onError);
        };

        var onAnswerCreated = function (response) {
            var responseAnswer = response.data;
            window.alert("You have successfully created a new answer, size is: " + responseAnswer.length);
            $scope.answerTextarea = "";
            $http.get("/rest/answer/question/" + questionId)
                .then(onAnswers, onError);
        };

        var onQuestion = function (response) {
            $scope.question = response.data;
        };

        var onAnswers = function(response) {
            $scope.answers = response.data;
            $scope.answersSize = response.data.length;
        };

        var onError = function(reason) {
            $scope.error = "Error fetching data. Reason status: " + reason.status + ": " + reason.statusText;
        };

        var questionId = $routeParams.questionid;

        $http.get("/rest/question/id/" + questionId)
            .then(onQuestion, onError);

        $http.get("/rest/answer/question/" + questionId)
            .then(onAnswers, onError);
    };

    app.controller("QuestionController", QuestionController);

}());