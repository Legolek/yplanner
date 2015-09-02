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
		MessagesService.loadMessages();
	});
})();