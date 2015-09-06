'use strict';

/**
 * @ngdoc function
 * @name cvApp.controller:FormationCtrl
 * @description
 * # FormationCtrl
 * Controller of the cvApp
 */
angular.module('cvApp')
  .controller('FormationCtrl', function ($scope, happyRestService, URLS) {
  	var easyConfig = happyRestService.getEasyConfig();
  	easyConfig.url = URLS.urlBackend + '/v1/cv';
  	easyConfig.fields.push('formation');
    var promiseGet = happyRestService.easyCall(easyConfig);
    promiseGet.then(function(result) {
    	$scope.formation = result.data[0].formation;
    });
  });
