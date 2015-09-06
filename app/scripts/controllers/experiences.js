'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:ExperiencesCtrl
 * @description
 * # ExperiencesCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('ExperiencesCtrl', function ($scope, happyRestService, URLS) {
  	$scope.loading = true;
  	var easyConfig = happyRestService.getEasyConfig();
  	easyConfig.url = URLS.urlBackend + '/v1/cv';
  	easyConfig.fields.push('experience');
    var promiseGet = happyRestService.easyCall(easyConfig);
    promiseGet.then(function(result) {
    	$scope.loading = false;
    	$scope.experiences = result.data[0].experience;
    });
  });
