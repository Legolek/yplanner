var app = angular.module("yplanner", [ "msg", "ngRoute", "ui.bootstrap"]);

app.controller("MenuController", function($scope, $location) {
	$scope.isActive = function(view) {
		if (view === '/' && $location.path() === '') {
			return true;
		}
		var splitArr = $location.path().split("/");
		return (view === "/" + splitArr[1]);
	}
});

app.controller("UserController", function($scope, UserService) {
	$scope.loggedUser = UserService.loggedUser;
	UserService.getLoggedUser();
});