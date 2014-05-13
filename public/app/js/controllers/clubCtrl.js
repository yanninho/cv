define(['./module'], function (cvControllers) {
     'use strict';
     cvControllers.controller('clubCtrl', ['$rootScope', '$scope', '$routeParams', 'ClubService',
             function($rootScope, $scope, $routeParams, ClubService) {
    	 
    	 		$scope.clubs = ClubService.getClubs();
    	 
		 		$scope.$on('$routeUpdate', function(next, current) { 		 				           		
		 			updateParams(current);			
				});	
				
		 		function updateParams() {
		 			ClubService.changeChampionnat(null);
	    	 		if (!angular.isUndefined($routeParams.championnatId)) {	
	    	 			if (!angular.isUndefined($routeParams.sort)) {
	    	 				ClubService.sort($routeParams.sort);
	    	 			}
	    	 			if (!angular.isUndefined($routeParams.order)) {
	    	 				ClubService.order($routeParams.order);
	    	 			}
	    	 			if (!angular.isUndefined($routeParams.filter)) {
	    	 				ClubService.filter($routeParams.filter);
	    	 			}	
	    	 			ClubService.changeChampionnat($routeParams.championnatId);
	    	 		}
		 		}		 		
    	 		
		 		updateParams();
		 		
          		$rootScope.$watch('userconnected', function () {
          			ClubService.majList();
          		}, true);    	 		
    	 		
          		/* trie */
          		$scope.sort = function(sort) {
          			ClubService.sort(sort);
          			ClubService.majList();
          		};
          		
          		/* filtre la liste grace aux champs texte */
          		$scope.searchNom = function() {
          			ClubService.searchNom($scope.searchboxNom);
          			ClubService.majList();
          		};
          		
          		/* page suivante */
          		$scope.pageUp = function() {
          			ClubService.pageUp();
          			ClubService.majList();
          		}; 
          		/* page precedente */
          		$scope.pageDown = function() {
          			ClubService.pageDown();
          			ClubService.majList();
          		}; 
          		
          		/* creer un championnat */
          		$scope.creer = function(club) {
          			//TODO
          		}
          		
          		/* supprimer un championnat */
          		$scope.supprimer = function(club) {
          			//TODO		
          		}
          		
          		
      }]);     
});