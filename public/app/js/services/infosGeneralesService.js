define(['./module'], function (cvServices) {
     'use strict';
     cvServices.factory('InfosGeneralesService', ['$resource',
		function($resource){
		  return $resource('infosGenerales', {}, {
		    query: {method:'GET'}
		  });
}]);     
});