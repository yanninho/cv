define(['./module'], function (cvServices) {
     'use strict';
     cvServices.factory('EmploisService', ['$q', '$http',
	 function($q, $http) {
    	 	var url ="/emplois";
    	     	
    	 	var emplois = {};
    	 	
    	 	return {
    	 		getEmplois: function() {
    	 			var promiseStart = $q.when('start');
    	 			
    	 			var promiseGetEmplois = promiseStart.then(function (value) {    
    	 				if (angular.isUndefined(emplois.length) || emplois.length == 0) {
        	 			    return $http.get(url).
    	 			        success(function(data, status) {
    	 			            emplois = data;    	 			            
    	 			        });    	 					
    	 				}
    	 			});
    	 			
    	 			var promiseEnd = promiseGetEmplois.then(function(value) {
    	 				return {emplois: emplois};
    	 			});    	 			
    	 			
    	 			return promiseEnd;
    	 		}    	 		
    	 	}    	 		     
	}]);     
});