define(['./module'], function (cvControllers) {
     'use strict';
	cvControllers.controller('technosCtrl', function($scope, $route, $routeParams, $location){
		
		updateRoute();
		
		$scope.$on('$routeUpdate', function(next, current) { 
			updateRoute();
		});			
		
		function updateRoute() {
			$scope.routeParams = {};		
			if (angular.isUndefined($routeParams.rub)) {
				$scope.routeParams.rub = 'assets/app/partials/technos/main.html';
			} 
			else {
				$scope.routeParams.rub = 'assets/app/partials/technos/'+ $routeParams.rub + '.html';
			}
		}
		
		
	});
});