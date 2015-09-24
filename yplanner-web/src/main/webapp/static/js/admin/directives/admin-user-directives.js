var app = angular.module("yplanner");

app.directive("userlogin", function($q, AdminUser) {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$asyncValidators.userlogin = function(modelValue, viewValue) {
				if (ctrl.$isEmpty(modelValue)) {
					return $q.when();
				}
				
				var def = $q.defer();
				AdminUser.checkUniqueLogin(modelValue).success(function(data) {
					scope.checkLoginMsg = scope.msg[data.message];
					if (data.success) {						
						def.resolve();
					} else {
						def.reject();
					}
				});
				return def.promise;
			};
		}
	};
});