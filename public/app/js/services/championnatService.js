define(['./module'], function (cvServices) {
'use strict';
	cvServices.factory('ChampionnatService', ['$q','$http','AuthService',
		 function($q,$http,AuthService) {	
		
			var championnats = {
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
				liste : {}				
			}
			
			var rechercheLocal = function(id) {
				var promiseStart = $q.when('start');
				var championnat = null;
				var promiseGetChampionnat = promiseStart.then(function (value) {	
					var i=0;
					while(i < championnats.liste.length && 
							championnats.liste[i].id != id) {
						i++;
					}
					if (i < championnats.liste.length) {
						championnat = championnats.liste[i];
					}
					return {data: {championnat:championnat}};
				});
				return promiseGetChampionnat;
			}
			
			var rechercheServeur = function(id) {
				var promiseStart = $q.when('start');
				var promiseGetChampionnat = promiseStart.then(function (value) {
	 			    return $http.get('/championnat?id='+id).
 			        success(function(data, status) {
 			            return data.championnat;
 			        });    	 					
				});
				return promiseGetChampionnat;
			}
			
			var rechercherChampionnat = function(id) {				
				var promiseGetChampionnat = null;
				//recherche dans la liste existante
				if (championnats.liste.length > 0) {
					promiseGetChampionnat = rechercheLocal(id);
				}
				//interroge le serveur
				else {
					promiseGetChampionnat = rechercheServeur(id);							
				}
			
				var promiseRecherche = promiseGetChampionnat.then(function(data){
					return data;
				}); 
				return promiseRecherche;
			}
			
      		/* Mets a jour la liste des championnats */
      		var updateList = function() {
      			if (AuthService.isConnected()) {
    				var promiseStart = $q.when('start');
    				
    	 			var promiseGetChampionnats = promiseStart.then(function (value) {  
    	 					var page = championnats.page;
        	 			    return $http.get('/championnats?p='+page.page+'&s='+page.sort+'&o='+page.order+'&filtreNom='+page.filterNom+'&filtrePays='+page.filterPays).
    	 			        success(function(data, status) {
    	 			            championnats.liste = data.championnats;
    	 			            championnats.page.nombre = data.nombre;
    	 	      				calculNbPages();
    	 	      				calculElementsPages();
    	 			        });    	 					
    	 			});						
				}
				else {
					championnats.liste.length = 0;
					return null;
				}				      			      			
      		}		
			
			/* calcule le nombre de pages */
			var calculNbPages = function() {
				var total = championnats.page.nombre;
   				var nbElementParPage = championnats.page.nbElementParPage;
   				championnats.page.nbPage = total > 0 ? Math.ceil(total/nbElementParPage) : 0;
			}
			
			/* met à jour les éléments d'affichage: 
			   premier élément et dernier élément */
			var calculElementsPages = function() {
				championnats.page.elementDebutPage = championnats.page.page + 1;
				championnats.page.elementFinPage = championnats.page.page + championnats.liste.length;				
			}
						
			return  {
				majList: function() {
					updateList();					
				},
				
				getChampionnat: function(id) {
					return rechercherChampionnat(id);
				},
				
				getChampionnats: function() {
					return championnats;
				},
			
				sort: function(sort) {
					championnats.page.sort = sort;
	      			if (championnats.page.order == 'asc') {
	      				championnats.page.order = 'desc';
	      			}
	      			else {
	      				championnats.page.order = 'asc';
	      			}
				},

				searchNom: function(search) {
					championnats.page.filterNom = search;
					championnats.page.page = 0;
				},

				searchPays: function(search) {
					championnats.page.filterPays = search;
					championnats.page.page = 0;
				},

				pageUp: function() {
	      			if (championnats.page.page < championnats.page.nbPage-1) {
	      				championnats.page.page++;	
	      			}					
				},

				pageDown: function() {
	      			if (championnats.page.page > 0) {
	      				championnats.page.page--;	
	      			}					
				},
				
				creer: function(championnat) {
					
				},
				
				supprimer: function(championnat) {
					
				}
				
		    }
    }]); 
});