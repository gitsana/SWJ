(function(){
    'use strict';
    var app = angular.module("SWJApp");

    var LoginController = function($scope, $http) {

        $scope.loginClicked = function () {
            alert("You cliked on the login button");
            var BASE_URL = "https://www.googleapis.com/oauth2/v2/userinfo?";
            var CLIENT_ID = "766876522069-jicdp1rpm19ccf62g4jfiutao382alj5.apps.googleusercontent.com";
            var REDIRECT_URI = "http://localhost:8080/oauthcallback.html";
            var SCOPE = "https://www.googleapis.com/auth/userinfo.profile";
            var RESPONSE_TYPE = "token";

            gapi.auth.authorize({
                    client_id: '766876522069-jicdp1rpm19ccf62g4jfiutao382alj5.apps.googleusercontent.com',
                    scope: 'https://www.googleapis.com/auth/userinfo.profile'},
                handleAuthResultPopup);

            // got the token now
            function handleAuthResultPopup() {
                var token_object = gapi.auth.getToken();
                var access_token = token_object.access_token;
                var token_type = token_object.token_type;
                var expires_in = token_object.expires_in;
                alert("Access token: " + access_token + ", token_type: " + token_type + ", expires_in: " + expires_in);

                $http.post("http://localhost:8080/oauthcallback.html#access_token=" + access_token);
            };

            // use token to get user's info
        };
    };

    app.controller("LoginController", LoginController);
}());