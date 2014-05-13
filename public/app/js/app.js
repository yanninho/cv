define([ 'angular', 
         'ngRoute',
         'ngCookies',
         'ngResource',
         'ngAnimate',
         'ngSanitize',
         'angular-highlight',
         'highlight',
//         'googlemaps',
//         'underscore',
         './controllers/index', 
//         './directives/index',
		 './filters/index', 
		 './services/index'], 
  function(ng) {
		'use strict';
		return ng.module('app', [ 'cvServices', 'cvControllers', 'cvFilters',
			'ngRoute', 'ngCookies', 'ngResource', 'ngAnimate', 'ngSanitize','hljs']); //,'google-maps'
	}
);
