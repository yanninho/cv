'use strict';

describe('Controller: CompetencesCtrl', function () {

  // load the controller's module
  beforeEach(module('cvApp'));

  var CompetencesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CompetencesCtrl = $controller('CompetencesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(CompetencesCtrl.awesomeThings.length).toBe(3);
  });
});
