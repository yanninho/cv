/**
* Defines the main routes in the application.
* The routes you see here will be anchors '#/' unless specifically configured otherwise.
*/

define(['./app'], function (app) {
    'use strict';
    return app.config(['$routeProvider', function ($routeProvider) {    	
    	$routeProvider.when('/', {templateUrl: 'assets/app/partials/index.html', controller: 'indexCtrl'});
    	$routeProvider.when('/connaissances', {templateUrl: 'assets/app/partials/connaissances.html', controller: 'connaissancesCtrl'});
    	$routeProvider.when('/parcours', {templateUrl: 'assets/app/partials/parcours.html', controller: 'parcoursCtrl', reloadOnSearch : false});
    	$routeProvider.when('/technos', {templateUrl: 'assets/app/partials/technos.html', controller: 'technosCtrl', reloadOnSearch : false});
    	$routeProvider.when('/plan', {templateUrl: 'assets/app/partials/planDuSite.html', controller: 'planCtrl'});

    	$routeProvider.when('/interets', {templateUrl: 'assets/app/partials/interets.html', controller: 'interetsCtrl'});
    	$routeProvider.when('/websocket', {templateUrl: 'assets/app/partials/websocket.html', controller: 'websocketCtrl'});
    	$routeProvider.when('/championnatList', {templateUrl: 'assets/app/partials/database/championnatList.html', controller: 'championnatCtrl'});
    	$routeProvider.when('/clubList/:championnatId/:championnatNom', {templateUrl: 'assets/app/partials/database/clubList.html', controller: 'clubCtrl'});
    	$routeProvider.otherwise({redirectTo: '/'});    	
    }]);
});