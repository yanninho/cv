define(['./module'], function (cvControllers) {
     'use strict';
		cvControllers.controller('authenticateCtrl', ['$rootScope', '$scope', 'AuthService',
		  function($rootScope, $scope, AuthService) {				

				$scope.connexion = function() {
					var user = $scope.user;
					if (angular.isUndefined(user)) {
						$scope.erreurs = "Veuillez remplir les champs";
					}
					else {
						var connexionPromise = AuthService.connexion(user.username, user.password); 
						connexionPromise.then(function(data){
							$rootScope.userconnected = AuthService.getUser();
						});								
					}				
				}
				
				$scope.deconnexion = function() {
					var deconnexionPromise = AuthService.deconnexion(); 
					deconnexionPromise.then(function(data){
						$rootScope.userconnected = null;
					});					
				}	
				
				AuthService.getConnexion().then(function(data){
					if (angular.isUndefined($rootScope.userconnected)) {
						$rootScope.userconnected = AuthService.getUser();
					}					
				});				
		  }]);
});