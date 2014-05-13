define([ './module' ], function(cvControllers) {
	'use strict';
	cvControllers.controller('planCtrl', [ '$scope', 'FormationsService', 'EmploisService',
			function($scope, FormationsService, EmploisService) {
				EmploisService.getEmplois().then(function(data) {
					$scope.emplois = data.emplois;
				});
				FormationsService.getFormation().then(function(data){
					$scope.formations = data.formation;
				});
			}]);
});