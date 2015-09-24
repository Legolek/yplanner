 (function() {
	var app = angular.module("msg", []);
	
	app.service("MessagesService", ['$http', function($http) {
		var messages = {};
		return {
			loadMessages: function() {
				$http({ method: 'GET', url: 'res/messages.js'}).success(function(data) {
					angular.copy(data, messages);
				});
			},
			messages: messages
		}
	}]);
	
	app.controller("MsgController", function($scope, MessagesService) {
		$scope.msg = MessagesService.messages;
		$scope.alerts = [];
		$scope.alertFromReturnMessage = function(data) {
			var alert = {};
			alert.type = data.success ? "success" : "danger";
			alert.message = $scope.msg[data.message];
			return alert;
		};
		$scope.showAlert = function(alert) {
			if ($scope.alerts.length > 0) {
				$scope.alerts = [];
			}
			$scope.alerts.push(alert);
		};
		$scope.closeAlert = function(index) {
			$scope.alerts.splice(index, 1);
		};
		$scope.msgFormat = function(message, params) {
			var m = $scope.msg[message];
			for (var i = 0; i < params.length; i++) {
				m = m.replace("{" + i + "}", params[i]);
			}
			return m;
		};
		MessagesService.loadMessages();
	});
})();