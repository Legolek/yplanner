var app = angular.module("yplanner", [ "msg", "ngRoute", "ui.bootstrap"]);

app.controller("MenuController", function($scope, $location) {
	$scope.isActive = function(view, submenu) {
		if (view === '/' && $location.path() === '') {
			return true;
		}
		if (!submenu) {
			var splitArr = $location.path().split("/");
			return (view === "/" + splitArr[1]);
		} else {
			return view === $location.path();
		}
	}
});

app.controller("UserController", function($scope, UserService) {
	$scope.loggedUser = UserService.loggedUser;
	UserService.getLoggedUser();
});