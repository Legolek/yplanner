var app = angular.module("yplanner");

app.controller("AdminUserController", function($scope, AdminUser) {
	$scope.user = {};
	$scope.users = {};
	$scope.saveUser = function() {
		alert($scope.user.login);
	}
	AdminUser.all().success(function(data) {
		$scope.users = data;
	});
});