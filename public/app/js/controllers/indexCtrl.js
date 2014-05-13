define([ './module' ], function(cvControllers) {
	'use strict';
	cvControllers.controller('indexCtrl', [
			'$scope',
			'$timeout',
			'InfosGeneralesService',
			'ActualitesService',
			function($scope, $timeout, InfosGeneralesService, ActualitesService) {
				
				$scope.informationsGenerales = InfosGeneralesService.query();
				$scope.actualites = ActualitesService.query();

				function changeDiapo() {
					switch ($scope.diapospres) {
					case "1":
						$scope.diapospres = "2";
						break;
					case "2":
						$scope.diapospres = "3";
						break;
					case "3":
						$scope.diapospres = "4";
						break;
					case "4":
						$scope.diapospres = "5";
						break;
					default:
						$scope.diapospres = "1";
					}
					$timeout(changeDiapo, 7000);
				}
				$timeout(changeDiapo, 3000);		
				
			} ]);
});