define(['./module'], function (cvServices) {
'use strict';
	cvServices.factory('ClubService', ['$q','$http', '$rootScope', 'ChampionnatService', 'AuthService',
		 function($q,$http,$rootScope,ChampionnatService, AuthService) {	
		    		
			var clubs = {
				page : {
						nbElementParPage: 10,
						nbPage:0,
						nombre:0,
						page:0,
						sort:'nom',
						order:'asc',
						filterNom:'',
						filterPays:'',
						elementDebutPage:0,
						elementFinPage:0
				},
				championnat : null,
				liste : {}				
			}
			
      		var updateList = function() {
				if (AuthService.isConnected() && 
						clubs.championnat != null) {
					var promiseStart = $q.when('start');
					
		 			var promiseGetClubs = promiseStart.then(function (value) {  
		 					var page = clubs.page;
	    	 			    return $http.get('/club?p='+page.page+'&s='+page.sort+'&o='+page.order+'&filtreNom='+page.filterNom+'&championnat='+clubs.championnat.id).
		 			        success(function(data, status) {
		 			            clubs.liste = data.clubs;
		 			            clubs.page.nombre = data.nombre;
		 	      				calculNbPages();
		 	      				calculElementsPages();
		 			        });    	 					
		 			});	  					
				}
				else {
					clubs.liste.length = 0;
					return null;
				}    			      			
      		}		
			
			/* calcule le nombre de pages */
			var calculNbPages = function() {
				var total = clubs.page.nombre;
   				var nbElementParPage = clubs.page.nbElementParPage;
   				clubs.page.nbPage = total > 0 ? Math.ceil(total/nbElementParPage) : 0;
			}
			
			/* met à jour les éléments d'affichage: 
			   premier élément et dernier élément */
			var calculElementsPages = function() {
				clubs.page.elementDebutPage = clubs.page.page + 1;
				clubs.page.elementFinPage = clubs.page.page + clubs.liste.length;				
			}
				
			var setChampionnat = function(id) {
				if (id != null) {
					ChampionnatService.getChampionnat(id).then(function(value){
						clubs.championnat = value.data.championnat;
						updateList();
					});
				}
				else {
					clubs.liste.length = 0;
				}
			}
			
			return  {	
				majList: function() {
					updateList();					
				},
				
				getClubs: function() {
					return clubs;
				},
			
				changeChampionnat: function(idChampionnat) {
					setChampionnat(idChampionnat);
				},
				
				sort: function(sort) {
					clubs.page.sort = sort;
	      			if (clubs.page.order == 'asc') {
	      				clubs.page.order = 'desc';
	      			}
	      			else {
	      				clubs.page.order = 'asc';
	      			}
				},

				searchNom: function(search) {
					clubs.page.filterNom = search;
					clubs.page.page = 0;
				},

				pageUp: function() {
	      			if (clubs.page.page < clubs.page.nbPage-1) {
	      				clubs.page.page++;	
	      			}					
				},

				pageDown: function() {
	      			if (clubs.page.page > 0) {
	      				clubs.page.page--;	
	      			}					
				},
				
				creer: function(championnat) {
					
				},
				
				supprimer: function(championnat) {
					
				}
				
		    }
    }]); 
});