var app = angular.module("yplanner");

app.service("UserService", ['$http', function($http) {
	var loggedUser = {};
	return {
		getLoggedUser : function() {
			$http({method: 'GET', url: 'userloggedin'}).success(function(data) {
				angular.copy(data, loggedUser);
			});
		},
		loggedUser : loggedUser
	}
}]);