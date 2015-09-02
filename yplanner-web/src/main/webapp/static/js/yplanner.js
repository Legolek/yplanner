var app = angular.module("yplanner", [ 'msg' ]);

app.controller("MenuController", function($scope, $location) {
	$scope.isActive = function(view) {
		if (view === '/' && $location.path() === '') {
			return true;
		}
		return (view === $location.path());
	}
});