define(['./module'], function (cvControllers) {
     'use strict';
	cvControllers.controller('cssCtrl', function($scope, $rootScope){

		$scope.menu = "accueil";
			
		$scope.$on('$routeChangeSuccess', function(scope, current, previous) {
			$scope.displaymenu = null;
			if (current.originalPath == '/') {
				$rootScope.glyphicon = 'glyphicon-home';
				$scope.menu = "accueil";
			}
			if (current.originalPath == '/connaissances') {
				$rootScope.glyphicon = 'glyphicon-eye-open';
				$scope.menu = "connaissances";
			}
			if (current.originalPath == '/parcours') {
				$rootScope.glyphicon = 'glyphicon-lock';
				$scope.menu = "parcours";
			}
			if (current.originalPath == '/technos') {
				$rootScope.glyphicon = 'glyphicon-wrench';
				$scope.menu = "technos";
			}
			if (current.originalPath == '/plan') {
				$rootScope.glyphicon = 'glyphicon-map-marker';
				$scope.menu = "plan";
			}
				
		});	
				
		$rootScope.maincss = 'body-blue';
		
		$scope.clickmenu = function() {
			if ($scope.displaymenu == null) {
				$scope.displaymenu = 1;
			}
			else {
				$scope.displaymenu = null;
			}
		}		
	});
});