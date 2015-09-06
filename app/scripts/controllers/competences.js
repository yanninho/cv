'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:CompetencesCtrl
 * @description
 * # CompetencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('CompetencesCtrl', function ($scope, happyRestService, URLS) {
  	$scope.loading = true;
  	var easyConfig = happyRestService.getEasyConfig();
  	easyConfig.url = URLS.urlBackend + '/v1/cv';
  	easyConfig.fields.push('skills');
  	var promiseGet = happyRestService.easyCall(easyConfig);
    promiseGet.then(function(result) {
    	$scope.loading = false;
    	$scope.skills = result.data[0].skills;
    });
  });
