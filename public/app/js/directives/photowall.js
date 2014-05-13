'use strict';

angular.module('photowall-ng', [])
  .directive('photowall', function () {
		return {
			restrict: 'EACM',
			link: function(scope, element, attrs) {				
				var renderWall = function() {					
				  var opts = {};
				  if (!angular.isUndefined(attrs.optionsPhotowall)) {
		              opts = scope.$eval(attrs.optionsPhotowall);
		              if (!angular.isObject(opts)) {
		                return;
		              }
		          }
				  else {
					  return;
				  }
				  var id = null;
				  if (angular.isUndefined(attrs.id)) {
		              return;
				  }
				  
				  opts.el = "#"+attrs.id;				  
				  PhotoWall.init(opts);
			      $.ajax({
			          url: attrs.url,
			          dataType: 'jsonp',
			          success: function(data){
			              var photos = {}
			              if(!data.feed.entry) return;
			              for(var i in data.feed.entry) {
			                  var e     = data.feed.entry[i].media$group;
			                  var id    = data.feed.entry[i].gphoto$id.$t;
			                  
			                  var t1h   = e.media$thumbnail[2].height;
			                  var t1w   = e.media$thumbnail[2].width;
			                  var t1src = e.media$thumbnail[2].url
			                  
			                  var t2w   = Math.round(t1w * 1.5);
			                  var t2h   = Math.round(t1h * 1.5);

			                  var t2src = e.media$content[0].url+'/../../w'+t2w+'-h'+t2h+'/';
			                  
			                  var bsrc  = e.media$content[0].url;
			                  var bw    = e.media$content[0].width;
			                  var bh    = e.media$content[0].height;
			                  
			                  
			                  photos[id] = {id:id,img:bsrc,width:bw,height:bh,
			                                th:{src:t1src,width:t1w,height:t1h,
			                                    zoom_src:t2src,zoom_factor:1.5
			                                }
			                  };
			                  
			              }    
			              PhotoWall.load(photos);
			          }
			      });
				}
				renderWall();
			}
		}
  });