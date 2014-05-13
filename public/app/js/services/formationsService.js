define(['./module'], function (cvServices) {
     'use strict';
     cvServices.factory('FormationsService', ['$q', '$http',
	 function($q, $http) {
    	 	var url ="/formations";
    	     	
    	 	var formation = {};
    	 	    	 	
    	 	return {
    	 		
    	 		getFormation: function() {
    	 			var promiseStart = $q.when('start');
    	 			
    	 			var promiseGetFormation = promiseStart.then(function (value) {    
    	 				if (angular.isUndefined(formation.length) || formation.length == 0) {
        	 			    return $http.get(url).
    	 			        success(function(data, status) {
    	 			            formation = data;    	 			            
    	 			        });    	 					
    	 				}
    	 			});
     	 			
    	 			var promiseEnd = promiseGetFormation.then(function(value) {
    	 				return {formation: formation};
    	 			});    	 			
    	 			
    	 			return promiseEnd;
    	 		}    	 		
    	 	}    	 		     
	}]);     
});