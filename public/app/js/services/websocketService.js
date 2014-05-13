define(['./module'], function (cvServices) {
    'use strict';
		cvServices.factory('WebsocketService', ['$q','$http', '$location',
		  function($q, $http, $location) {
			
			  var WS = null;
			  var chatSocket = null;
			  var sessionID = null;
			  
			  return {				  
				  nouvelleSession : function() {
					  var promiseStart = $q.when('start');
	    	 			
					  var promiseGetNouvelleSession = promiseStart.then(function (value) {    
	    	 				if (angular.isUndefined(formation.length) || formation.length == 0) {
	        	 			    return $http.get('websocket').
	    	 			        success(function(data, status) {
	    	 			            sessionID = data; 
	    	 						WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
	    	 						chatSocket = new WS("ws://"+ $location.host() +":"+ $location.port() +"/chat?sessionID="+sessionID);  	    	 			            
	    	 			        });    	 					
	    	 				}
	    	 		  });
				  },				  
			      sendText : function(text) {
					  if (chatSocket != null) {
						  chatSocket.send(JSON.stringify({text: text})) 
					  }
			      }				  
			  }					
	}]);
});