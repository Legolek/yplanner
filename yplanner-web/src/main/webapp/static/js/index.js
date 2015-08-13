(function() {
	var app = angular.module("index", ['msg'], function($locationProvider) {
		$locationProvider.html5Mode(true);
	});
	
	app.controller("LoginController", function($location) {
		this.login = null;
		this.password = null;
		this.error = $location.search().error;
		if (this.error) {
			$('#loginForm').css('height', '310px');
		}
	});
})();