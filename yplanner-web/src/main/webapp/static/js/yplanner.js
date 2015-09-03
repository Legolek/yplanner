var app = angular.module("yplanner", [ "msg", "ngRoute" ]);

app.controller("MenuController", function($scope, $location) {
	$scope.isActive = function(view) {
		if (view === '/' && $location.path() === '') {
			return true;
		}
		return (view === $location.path());
	}
});

app.controller("UserController", function($scope, UserService) {
	$scope.loggedUser = UserService.loggedUser;
	UserService.getLoggedUser();
});