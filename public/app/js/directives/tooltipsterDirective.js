define(['./module'], function (cvDirectives) {
'use strict';
	cvDirectives.directive('tooltipsterDirective', function() {
	    return {
	        restrict: 'EACM',
	        link: function(scope, element, attrs) {
	            element.tooltipster();
	        }
	    };
	});
});