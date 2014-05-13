define(['./module'], function (cvControllers) {
     'use strict';
		cvControllers.controller('websocketCtrl', ['$scope', 'WebsocketService',
		   function($scope, WebsocketService) {
			
			  /* démarre une nouvelle session websocket*/
			  $scope.nouvelleSession = function() {
				  WebsocketService.nouvelleSession();
			  }
			  
			  /* envoie au travers de la connexion websocket le texte */
			  $scope.talkChange = function() {
				  WebsocketService.sendText($scope.talk);
			  }		 	  	  
		  }]);
});