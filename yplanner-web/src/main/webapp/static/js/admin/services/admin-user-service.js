var app = angular.module("yplanner");

app.factory("AdminUser", function AdminUserFacory($http) {
	return {
		all: function() {
			return $http({method: 'GET', url: 'admin/users'});
		},
		addUser: function(user) {
			
		}
	};
});