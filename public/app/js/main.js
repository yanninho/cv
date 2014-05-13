/**
* configure RequireJS
* prefer named modules to long paths, especially for version mgt
* or 3rd party libraries
*/
require.config({

    paths: {
        'angular': '../lib/angular/angular.min',
        'ngRoute': '../lib/angular/angular-route.min',
        'ngAnimate': '../lib/angular/angular-animate.min',
        'ngResource': '../lib/angular/angular-resource.min',
        'ngCookies': '../lib/angular/angular-cookies.min',        
        'domReady': '../lib/requirejs-domready/domReady',
        'highlight': '../lib/highlight/highlight.pack',
        'angular-highlight': '../lib/highlight/angular-highlightjs.min',
        'ngSanitize': '../lib/angular/angular-sanitize.min'
//        'googlemaps': '../lib/angular-google-maps.min',
//        'underscore': '../lib/underscore-min'
   },

    /**
* for libs that either do not support AMD out of the box, or
* require some fine tuning to dependency mgt'
*/
    shim: {
        'angular': {
        	exports : 'angular'
        },
        'ngRoute': ['angular'],
        'ngAnimate': ['angular'],
        'ngResource':  ['angular'],
        'ngCookies': ['angular'],
        'ngSanitize': ['angular'],
        'angular-highlight': ['angular']
    },
    priority: ['angular'],
    deps: [
        './bootstrap'
    ]
});