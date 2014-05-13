define(['./module'], function (cvServices) {
'use strict';
		cvServices.factory('InformationsService', ['$resource',
		   function($resource) {	
		 		return  $resource('informations', {},{
		    	query: {
		    		method:'GET',
		    		isArray:false
		    	}
		    });
		 }]);    
});