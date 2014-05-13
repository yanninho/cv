define(['./module'], function (cvControllers) {
     'use strict';
		cvControllers.controller('parcoursCtrl', ['$scope', '$routeParams', 'FormationsService', 'EmploisService',
		  function($scope, $routeParams, FormationsService, EmploisService) {
			
			$scope.nivDisplayExperience = 3;

			var formationResult = FormationsService.getFormation();						
			formationResult.then(function(data){
				$scope.formations = data.formation;
			});	

			var emploisResult = EmploisService.getEmplois();						
			emploisResult.then(function(data){
				$scope.emplois = data.emplois;
			});		
	}]);
});