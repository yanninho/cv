define(['./module'], function (cvServices) {
'use strict';
	cvServices.factory('ActualitesService', ['$resource',
	 function($resource){
	   return $resource('actualites', {}, {
		   query: {method:'GET', isArray: true}
	   });
	 }]);     
});