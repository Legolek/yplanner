(function() {
	var app = angular.module("msg", ['ngRoute', 'ngResource']);
	
	app.service("MessagesService", function($resource) {
		var messages = {};
		return {
			loadMessages: function() {
				$resource('res/messages.js').get(function(data) {
					angular.copy(data, messages);
				});
			},
			messages: messages
		}
	});
	
	app.controller("MsgController", function(MessagesService) {
		this.get = MessagesService.messages;
		MessagesService.loadMessages();
	});
})();