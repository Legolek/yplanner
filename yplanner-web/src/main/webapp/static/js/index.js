var app = angular.module("index", ['ngRoute', 'ngResource']);

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

app.controller("LoginController", function($resource, MessagesService) {
	this.login = null;
	this.password = null;
	this.submitLogin = function() {
		alert(this.login + " " + this.password);
	};
	
	this.msg = MessagesService.messages;
	MessagesService.loadMessages();
});