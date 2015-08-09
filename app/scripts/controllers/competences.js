'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:CompetencesCtrl
 * @description
 * # CompetencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('CompetencesCtrl', function ($scope, rest, URLS) {
    var promiseGet = rest.call({
    	method: 'GET',
    	url: URLS.urlBackend + '/v1/cv?fields=skills'
    });
    promiseGet.then(function(result) {
    	$scope.skills = result.data[0].skills;
    });
  });
