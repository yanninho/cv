'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:ExperiencesCtrl
 * @description
 * # ExperiencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('ExperiencesCtrl', function ($scope, rest, URLS) {
    var promiseGet = rest.call({
    	method: 'GET',
    	url: URLS.urlBackend + '/v1/cv?fields=experience'
    });
    promiseGet.then(function(result) {
    	$scope.experiences = result.data[0].experience;
    });
  });
