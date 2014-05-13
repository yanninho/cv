define(['./module'], function (cvControllers) {
     'use strict';
     cvControllers.controller('connaissancesCtrl', ['$scope', 'ConnaissancesService',
                function($scope, ConnaissancesService) {    	 
    	 			$scope.typeConnaissances = ConnaissancesService.query();              		
                }]);
 });