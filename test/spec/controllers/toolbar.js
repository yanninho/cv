'use strict';

describe('Controller: ToolbarctrlCtrl', function () {

  // load the controller's module
  beforeEach(module('cvApp'));

  var ToolbarctrlCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ToolbarctrlCtrl = $controller('ToolbarctrlCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ToolbarctrlCtrl.awesomeThings.length).toBe(3);
  });
});
