var app = angular.module("yplanner");

app.config(["$routeProvider", function($routeProvider) {
	$routeProvider.when("/admin", {
		templateUrl: "js/admin/admin.html",
		controller: "AdminUserController",
		controllerAs: "AdminUserCtrl"
	}).when("/admin/user/add", {
		templateUrl: "js/admin/add_user.html",
		controller: "AdminUserController",
		controllerAs: "AdminUserCtrl"
	});
}]);