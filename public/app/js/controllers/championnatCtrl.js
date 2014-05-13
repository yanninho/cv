define(['./module'], function (cvControllers) {
     'use strict';
     cvControllers.controller('championnatCtrl', ['$scope', '$rootScope', '$routeParams', 'ChampionnatService',
        function($scope, $rootScope, $routeParams, ChampionnatService) {
    	 	
    	 	$scope.championnats = ChampionnatService.getChampionnats();

//	 		$scope.$on('$routeUpdate', function(next, current) { 		 				           		
//	 			updateParams();			
//			});	
//			
//	 		function updateParams() {
//	 			var routeSort = $routeParams.sort;
//	 			var routeOrder = $routeParams.order;
//	 			var routeFilterNom = $routeParams.filternom;			
//	 			var routeFilterPays = $routeParams.filterpays;			
//	 			var change = false;
//    	 		if (!angular.isUndefined(routeSort)) {
//    	 			ClubService.sort(routeSort);
//    	 		}
//    	 		if (!angular.isUndefined(routeOrder)) {
//    	 			ClubService.order(routeOrder);
//    	 			change = true;
//    	 		}
//    	 		if (!angular.isUndefined(routeFilterNom)) {
//        	 		ClubService.searchNom(routeFilterNom);
//        	 		change = true;
//        	 	}	           		 	
//    	 		if (!angular.isUndefined(routeFilterPays)) {
//        	 		ClubService.searchPays(routeFilterPays);
//        	 		change = true;
//        	 	}	 
//    	 		
//    	 		if (change) {
//    	 			ChampionnatService.majList();
//    	 		}
//	 		}		 		
	 		    	 	
      		$rootScope.$watch('userconnected', function () {
      			ChampionnatService.majList();
      		}, true);    	 	
    	 	
      		/* trie */
      		$scope.sort = function(sort) {
      			ChampionnatService.sort(sort);
      			ChampionnatService.majList();
      		};
      		
      		/* filtre la liste grace aux champs texte */
      		$scope.searchNom = function() {
      			ChampionnatService.searchNom($scope.searchboxNom);
      			ChampionnatService.majList();
      		};
      		
      		/* recherche */
      		$scope.searchPays = function() {
      			ChampionnatService.searchPays($scope.searchboxPays);
      			ChampionnatService.majList();
      		};
      		
      		/* page suivante */
      		$scope.pageUp = function() {
      			ChampionnatService.pageUp();
      			ChampionnatService.majList();
      		}; 
      		/* page precedente */
      		$scope.pageDown = function() {
      			ChampionnatService.pageDown();
      			ChampionnatService.majList();
      		}; 
      		
      		/* creer un championnat */
      		$scope.creer = function(championnat) {
      			//TODO
      		}
      		
      		/* supprimer un championnat */
      		$scope.supprimer = function(championnat) {
      			//TODO		
      		}		
     }]);     
});