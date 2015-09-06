'use strict';

/**
 * @ngdoc overview
 * @name cvApp
 * @description
 * # cvApp
 *
 * Main module of the application.
 */
angular
  .module('cvApp', [
    'ngAnimate',
    'ngAria',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngMaterial',
    'happyRestClient'
  ])
  .config(function ($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/competences', {
        templateUrl: 'views/competences.html',
        controller: 'CompetencesCtrl',
        controllerAs: 'competences'
      })
      .when('/experiences', {
        templateUrl: 'views/experiences.html',
        controller: 'ExperiencesCtrl',
        controllerAs: 'experiences'
      })
      .when('/formation', {
        templateUrl: 'views/formation.html',
        controller: 'FormationCtrl',
        controllerAs: 'formation'
      })
      .otherwise({
        redirectTo: '/'
      });
      $locationProvider.html5Mode(true);
  })
  .config(function($mdThemingProvider) {
    $mdThemingProvider.theme('blue');
  });
