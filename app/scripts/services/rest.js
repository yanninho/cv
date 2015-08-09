'use strict';

/**
 * @ngdoc service
 * @name cvApp.rest
 * @description
 * # rest
 * Factory in the cvApp.
 */
angular.module('cvApp')
  .factory('rest', function ($q, $http) {
      var promiseStart = $q.when('start');

      var httpSuccess = function(data, status, headers, config) {
        return data;
      };

      var httpError = function(data, status, headers, config) {
        return $q.reject();        
      };

      // verifie l'objet config avec url et method
      var verifyConfig = function(config) {
        var message = ', attendu : config { url, method } voir https://docs.angularjs.org/api/ng/service/$http';
        if (angular.isUndefined(config)) {
          console.log('objet config pour un appel Rest : [undefined]' + message);
        }
        if (angular.isUndefined(config.url)) {
           console.log('url dans config pour un appel Rest : [undefined]' + message);
        }
        if (angular.isUndefined(config.method)) {
          console.log('method dans config pour un appel Rest : [undefined]' + message);
        }
      };

      //construit une configuration pour le service $http
      var makeConfig = function(config) {

        return {
          url : config.url,
          method : config.method,
          data : config.data || '',
          params : config.params || undefined         
        };
      };

      return {
        call: function(config) {   
          verifyConfig(config);  
          var makedConfig = makeConfig(config);            
          var promiseAppel = promiseStart.then(function () {
            return $http(makedConfig).
              success(httpSuccess).
              error(httpError);
          });
          return promiseAppel;
        }
    };    
  });
