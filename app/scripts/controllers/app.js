'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:AppCtrl
 * @description
 * # AppCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('AppCtrl', function ($scope, $location) {
  	$scope.slideDir = 'slide-left';
    $scope.menu = 0;
    $scope.menuMax =  3;
    $scope.routes = [
      '/',
      '#/competences',
      '#/experiences',
      '#/formation'
    ];
 	
    $scope.getSlideDir = function() {
    	return $scope.slideDir;
    }

    $scope.menuToLeft = function() {
      if ($scope.menu === $scope.menuMax) {
        $scope.menu = 0;
      } 
      else {
        $scope.menu++;
      }
      $scope.slideDir = 'slide-left';
      $location.url($scope.routes[$scope.menu]);
    };

    $scope.menuAccueil = function() {
      $scope.menu = 0;
      $scope.slideDir = 'slide-left';
      $location.url($scope.routes[$scope.menu]);
    }  		
  });
