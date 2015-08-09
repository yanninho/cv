'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:CompetencesCtrl
 * @description
 * # CompetencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('CompetencesCtrl', function ($scope, rest) {
    var promiseGet = rest.call({
    	method: 'GET',
    	url: 'http://localhost:9001/v1/cv?fields=skills'
    });
    promiseGet.then(function(result) {
    	$scope.skills = result.data[0].skills;
    });
  });
