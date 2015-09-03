var app = angular.module("yplanner");

app.controller("AdminUserController", function($scope, AdminUser) {
	$scope.users = {};
	AdminUser.all().success(function(data) {
		$scope.users = data;
	});
});