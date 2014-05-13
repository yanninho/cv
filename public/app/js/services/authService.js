define(['./module'], function (cvServices) {
	'use strict';
		cvServices.factory('AuthService', ['$q','$http',
			function($q,$http) {
				
				var user = {
					username: null	
				}
				
				return {
					
					connexion: function(username, password) {							
							var promiseStart = $q.when('start');							
		    	 			var promiseConnexion = promiseStart.then(function (value) {    
		        	 			    return $http.get('/connexion?username='+username+'&password='+password).
		    	 			        success(function(data, status) {
		    	 			            user.username = data.username;    	 			            
		    	 			        });    	 					
		    	 			});		    	 			
		    	 			return promiseConnexion;		    	 			
					},
					
					deconnexion: function() {
							var promiseStart = $q.when('start');
		    	 			var promiseDeconnexion = promiseStart.then(function (value) {    
		        	 			    return $http.get('/deconnexion').
		    	 			        success(function(data, status) {
		    	 			            user.username = null;    	 			            
		    	 			        });    	 					
		    	 			});		    	 			
		    	 			return promiseDeconnexion;								
					},
					
					isConnected: function() {
						return user.username != null;
					},
					
					getUser: function() {
						return user;
					},
					
					getConnexion: function() {
						var promiseStart = $q.when('start');							
	    	 			var promiseConnexion = promiseStart.then(function (value) {    
	        	 			    return $http.get('/getConnexion').
	    	 			        success(function(data, status) {
	    	 			            user.username = data.username;    	 			            
	    	 			        });    	 					
	    	 			});		    	 			
	    	 			return promiseConnexion;	    	 
					}					
				}
		}]);     
	});