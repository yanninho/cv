define(['./module'], function (cvServices) {
     'use strict';
     cvServices.factory('ConnaissancesService', ['$resource',
         function($resource){
			  return $resource('connaissances', {}, {
			     query: {method:'GET', isArray:true}
			  });
        }]);     
});