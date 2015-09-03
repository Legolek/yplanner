var app = angular.module("yplanner");

app.config(["$routeProvider", function($routeProvider) {
	$routeProvider.when("/admin", {
		templateUrl: "js/admin/admin.html"
	});
}]);