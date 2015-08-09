'use strict';

describe('Controller: ExperiencesCtrl', function () {

  // load the controller's module
  beforeEach(module('cvApp'));

  var ExperiencesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ExperiencesCtrl = $controller('ExperiencesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ExperiencesCtrl.awesomeThings.length).toBe(3);
  });
});
