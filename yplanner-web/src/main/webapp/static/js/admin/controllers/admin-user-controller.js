var app = angular.module("yplanner");

app.controller("AdminUserController", function($scope, AdminUser) {
	$scope.user = {};
	$scope.users = {};
	$scope.currentPage = 1;
	$scope.totalItems = -1;
	$scope.saveUser = function() {
		AdminUser.addUser($scope.user).success(function(data) {
			// $scope.$apply(function() { $location.path("/admin"); });
		});
	}
	AdminUser.count().success(function(data) {
		$scope.totalItems = data;
	});
	AdminUser.all($scope.currentPage - 1).success(function(data) {
		$scope.users = data;
	});
	$scope.changePage = function() {
		AdminUser.all($scope.currentPage - 1).success(function(data) {
			$scope.users = data;
		});
	}
});