'use strict';

describe('Service: viewSlideIndex', function () {

  // load the service's module
  beforeEach(module('cvApp'));

  // instantiate service
  var viewSlideIndex;
  beforeEach(inject(function (_viewSlideIndex_) {
    viewSlideIndex = _viewSlideIndex_;
  }));

  it('should do something', function () {
    expect(!!viewSlideIndex).toBe(true);
  });

});
