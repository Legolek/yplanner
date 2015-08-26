(function() {
	var app = angular.module("usr", ['ngRoute', 'ngResource']);
	
	app.service("UserService", function($resource) {
		var loggedUser = {};
		return {
			getLoggedUser: function() {
				$resource('userloggedin').get(function(data) {
					angular.copy(data, loggedUser);
				});
			},
			loggedUser: loggedUser
		}
	});
	
	app.controller("UserController", function(UserService) {
		this.loggedUser = UserService.loggedUser;
		UserService.getLoggedUser();
	});
})();