(function() {
    var app = angular.module("SWJApp", ["ngRoute"]);

    app.config(function($routeProvider){

        $routeProvider
            .when("/home", {
                templateUrl: "/home.html",
                controller: "HomeController"
            })
            .when("/question/:questionid", {
                templateUrl: "/question.html",
                controller: "QuestionController"
            })
            .when("/ask", {
                templateUrl: "/ask.html",
                controller: "AskController"
            })
            .when("/login", {
                templateUrl: "/login.html",
                controller: "LoginController"
            })
            .otherwise({redirectTo: "/home"});
    });
}());