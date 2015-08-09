'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:ExperiencesCtrl
 * @description
 * # ExperiencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('ExperiencesCtrl', function ($scope, rest) {
    var promiseGet = rest.call({
    	method: 'GET',
    	url: 'http://localhost:9001/v1/cv?fields=experience'
    });
    promiseGet.then(function(result) {
    	$scope.experiences = result.data[0].experience;
    });
  });
