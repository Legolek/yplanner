(function() {
	var app = angular.module("index", ['msg'], function($locationProvider) {
		$locationProvider.html5Mode(true);
	});
	
	app.controller("LoginController", function($location, $scope) {
		$scope.login = null;
		$scope.password = null;
		$scope.passwordText = null;
		$scope.error = $location.search().error;
		$scope.beforeSubmit = function() {
			$scope.password = CryptoJS.MD5($scope.passwordText).toString();
			$scope.passwordText = null;
		};
		if ($scope.error) {
			$('#loginForm').css('height', '310px');
		}
	});
})();