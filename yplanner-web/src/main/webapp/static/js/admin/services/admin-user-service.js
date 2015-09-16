var app = angular.module("yplanner");

app.factory("AdminUser", function AdminUserFacory($http) {
	return {
		all: function(page) {
			return $http({method: 'GET', url: 'admin/users/' + page});
		},
		addUser: function(user) {
			return $http({method: 'PUT', url: 'admin/new/user', data: user});
		},
		count: function() {
			return $http({method: 'GET', url: 'admin/count/users'});
		}
	};
});