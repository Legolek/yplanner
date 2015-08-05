var app = angular.module("index", ['ngRoute', 'ngResource'], function($locationProvider) {
	$locationProvider.html5Mode(true);
});

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

app.controller("LoginController", function($resource, $location, MessagesService) {
	this.login = null;
	this.password = null;
	this.error = $location.search().error;
	if (this.error) {
		$('#loginForm').css('height', '310px');
	}
	this.msg = MessagesService.messages;
	MessagesService.loadMessages();
});