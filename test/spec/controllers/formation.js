'use strict';

describe('Controller: FormationCtrl', function () {

  // load the controller's module
  beforeEach(module('cvApp'));

  var FormationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FormationCtrl = $controller('FormationCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FormationCtrl.awesomeThings.length).toBe(3);
  });
});
