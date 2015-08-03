var app = angular.module("index", []);

app.controller("LoginController", function() {
	this.login = null;
	this.password = null;
	this.submitLogin = function() {
		alert(this.login + " " + this.password);
	};
});