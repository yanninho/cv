'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:FormationCtrl
 * @description
 * # FormationCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('FormationCtrl', function ($scope, rest) {
    var promiseGet = rest.call({
    	method: 'GET',
    	url: 'http://localhost:9001/v1/cv?fields=formation'
    });
    promiseGet.then(function(result) {
    	$scope.formation = result.data[0].formation;
    });
  });
