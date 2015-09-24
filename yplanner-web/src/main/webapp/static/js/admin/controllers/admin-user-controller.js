var app = angular.module("yplanner");

app.controller("AdminUserController", function($scope, $location, AdminUser) {
	$scope.user = {};
	$scope.users = {};
	$scope.checkLoginMsg = $scope.msg['yplanner.admin.users.login.check'];
	$scope.currentPage = 1;
	$scope.totalItems = -1;
	$scope.saveUser = function() {
		var userToSend = $scope.user;
		userToSend.password = CryptoJS.MD5(userToSend.password).toString();
		AdminUser.addUser(userToSend).success(function(data) {
			$location.path("/admin");
			$scope.showAlert($scope.alertFromReturnMessage(data));
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
	$scope.getPassword = function() {
		AdminUser.generatePassword().success(function(data) {
			$scope.user.password = data.password;
		});
	}
});