/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Define any routes for the app
// Note that this app is a single page app, and each partial is routed to using the URL fragment. For example, to select the 'home' route, the URL is http://localhost:8080/jboss-as-kitchensink-angularjs/#/home
angular.module('azbrocamo', ['ngRoute','modelesService','ngAnimate','ngAria','ngCookies','angular.filter','ngStorage']).config(
        [ '$httpProvider', '$routeProvider', function($httpProvider, $routeProvider) {
        	
        	
            /*
             * Use a HTTP interceptor to add a nonce to every request to prevent MSIE from caching responses.
             */
            $httpProvider.interceptors.push('ajaxNonceInterceptor');

            $routeProvider.
            // if URL fragment is /home, then load the home partial, with the
            // ModelesCtrl controller
            when('/home', {
                templateUrl : 'partials/home.html',
                controller : ModelesCtrl
            // Add a default route
            }).otherwise({
                redirectTo : '/home'
            }).when('/home/:nomCategorie',{
            	templateUrl : 'partials/home.html',
                controller : ModelesCtrl
            }).when('/description/:nomModele',{
            	templateUrl : 'partials/description.html',
                controller : DescriptionCtrl
            }).when('/login', {
            	templateUrl : 'partials/login.html',
            	controller : LoginCtrl
            }).when('/register', {
            	templateUrl : 'partials/register.html',
            	controller : RegisterCtrl
            }).when('/cart', {
            	templateUrl : 'partials/panier.html',
            	controller : PanierCtrl
            }).when('/admin/categorie', {
            	templateUrl : 'partials/adminCategorie.html',
            	controller : adminCategorieCtrl
            }).when('/admin/categorie/:nomCategorie', {
            	templateUrl : 'partials/adminCategorie.html',
            	controller : adminCategorieCtrl
            }).when('/admin/modele', {
            	templateUrl : 'partials/adminModele.html',
            	controller : adminModeleCtrl
            })/*.when('/admin/modele/:nomModele/:listCat', {
            	templateUrl : 'partials/adminModele.html',
            	controller : adminModeleCtrl
            })*/;
        } ])
    .factory('ajaxNonceInterceptor', function() {
        // This interceptor is equivalent to the behavior induced by $.ajaxSetup({cache:false});

        var param_start = /\?/;

        return {

            request : function(config) {
                if (config.method == 'GET') {
                    // Add a query parameter named '_' to the URL, with a value equal to the current timestamp
                    config.url += (param_start.test(config.url) ? "&" : "?") + '_=' + new Date().getTime();
                }
                return config;
            }
        }
    })
    .factory('AuthenticationService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
        var service = {};

        service.Login = function (username, password, callback) {

            /* Dummy authentication for testing, uses $timeout to simulate api call
             ----------------------------------------------*/
            $timeout(function(){
                var response = { success: (username === 'admin@azbrocamo.com' && password === 'admin')
                		|| (username === 'user@azbrocamo.com' && password === 'user')};
                if(!response.success) {
                    response.message = 'Nom d\'utilisateur ou mot de passe incorrect';
                }
                callback(response);
            }, 1000);


            /* TODO: Use this for real authentication
             ----------------------------------------------*/
            //$http.post('/api/authenticate', { username: username, password: password })
            //    .success(function (response) {
            //        callback(response);
            //    });

        };
 
        service.SetCredentials = function (username, password) {
            var authdata = Base64.encode(username + ':' + password);
 
            $rootScope.globals = {
                currentUser: {
                    username: username,
                    authdata: authdata
                }
            };
 
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
            $cookieStore.put('globals', $rootScope.globals);
        };
 
        service.ClearCredentials = function () {
            $rootScope.globals = {};
            $cookieStore.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic ';
        };
        
        service.GetUser = function(){
        	console.log($rootScope.globals.currentUser);
        	return $rootScope.globals.currentUser;
        }
 
        return service;
    }])
 
	.factory('Base64', function () {
	    /* jshint ignore:start */
	 
	    var keyStr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
	 
	    return {
	        encode: function (input) {
	            var output = "";
	            var chr1, chr2, chr3 = "";
	            var enc1, enc2, enc3, enc4 = "";
	            var i = 0;
	 
	            do {
	                chr1 = input.charCodeAt(i++);
	                chr2 = input.charCodeAt(i++);
	                chr3 = input.charCodeAt(i++);
	 
	                enc1 = chr1 >> 2;
	                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
	                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
	                enc4 = chr3 & 63;
	 
	                if (isNaN(chr2)) {
	                    enc3 = enc4 = 64;
	                } else if (isNaN(chr3)) {
	                    enc4 = 64;
	                }
	 
	                output = output +
	                    keyStr.charAt(enc1) +
	                    keyStr.charAt(enc2) +
	                    keyStr.charAt(enc3) +
	                    keyStr.charAt(enc4);
	                chr1 = chr2 = chr3 = "";
	                enc1 = enc2 = enc3 = enc4 = "";
	            } while (i < input.length);
	 
	            return output;
	        },
	 
	        decode: function (input) {
	            var output = "";
	            var chr1, chr2, chr3 = "";
	            var enc1, enc2, enc3, enc4 = "";
	            var i = 0;
	 
	            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
	            var base64test = /[^A-Za-z0-9\+\/\=]/g;
	            if (base64test.exec(input)) {
	                window.alert("There were invalid base64 characters in the input text.\n" +
	                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
	                    "Expect errors in decoding.");
	            }
	            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
	 
	            do {
	                enc1 = keyStr.indexOf(input.charAt(i++));
	                enc2 = keyStr.indexOf(input.charAt(i++));
	                enc3 = keyStr.indexOf(input.charAt(i++));
	                enc4 = keyStr.indexOf(input.charAt(i++));
	 
	                chr1 = (enc1 << 2) | (enc2 >> 4);
	                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
	                chr3 = ((enc3 & 3) << 6) | enc4;
	 
	                output = output + String.fromCharCode(chr1);
	 
	                if (enc3 != 64) {
	                    output = output + String.fromCharCode(chr2);
	                }
	                if (enc4 != 64) {
	                    output = output + String.fromCharCode(chr3);
	                }
	 
	                chr1 = chr2 = chr3 = "";
	                enc1 = enc2 = enc3 = enc4 = "";
	 
	            } while (i < input.length);
	 
	            return output;
	        }
	    };
	 
	    /* jshint ignore:end */
	})
	.controller('UserMenuCtrl', function($scope, $rootScope, AuthenticationService){
		/*$rootScope.watch('globals', function(newVal, oldVal){
			console.log($rootScope);
		})*/
	}).factory('sharedPropertiesService',function($http, $q){
		 var hashtable = {};

		    return {
		        setValue: function (key, value) {
		            hashtable[key] = value;
		        },
		        getValue: function (key) {
		            return hashtable[key];
		        }
		    }
	
	}).controller('getElementPanierCtrl',function($scope,sharedPropertiesService,$localStorage){
		$scope.panier= JSON.parse(localStorage.getItem('articles')) || [];
		$scope.getArticlePanier=function(nomModele,prix,taille,quantite,couleur){
			$scope.size=taille;
			sharedPropertiesService.setValue(1,$scope.size);
			$scope.color=couleur;
			sharedPropertiesService.setValue(2,$scope.color);
			$scope.quantity=quantite;
			sharedPropertiesService.setValue(3,$scope.quantity);
			$scope.nomModele=nomModele;
			sharedPropertiesService.setValue(4,$scope.nomModele);
			$scope.prix=prix;
			sharedPropertiesService.setValue(5,$scope.prix);
			
		}
		if(sharedPropertiesService.getValue(4) != null){
			$scope.newArticle={
					nomModele:sharedPropertiesService.getValue(4),
					prix:sharedPropertiesService.getValue(5),
					taille:sharedPropertiesService.getValue(1),
					quantite:sharedPropertiesService.getValue(3),
					couleur:sharedPropertiesService.getValue(2)
			};
			$scope.panier.push($scope.newArticle);
		}
		 localStorage.setItem('articles', JSON.stringify($scope.panier));
		$scope.removeItem=function(index){
			$scope.panier.splice(index,1);
			 localStorage.setItem('articles', JSON.stringify($scope.panier));
		}
		$scope.removeAllItems=function(){
			for(var i=$scope.panier.length-1;i>=0;i--){
				 if (!$scope.panier[i].value) {
				        $scope.panier.splice(i, 1);
				    }
			}
			localStorage.setItem('articles', JSON.stringify($scope.panier));
		}
		 $scope.total=function(){
			 var total=0;
		
			 angular.forEach($scope.panier,function(item){
				 
				 if(item != null){
					 if(item.prix != null && item.quantite != null) total += item.prix * item.quantite;
				 }
				
			 })
			 return total;
		 }
			/*$scope.panier.push({
				  nomModele:sharedPropertiesService.getValue(4),
					prix:sharedPropertiesService.getValue(5),
					taille:sharedPropertiesService.getValue(1),
					quantite:sharedPropertiesService.getValue(3),
					couleur:sharedPropertiesService.getValue(2)
		        });
			localStorage.setItem("articles",JSON.stringify($scope.panier.articles));
			$scope.panier.articles=JSON.parse(localStorage.getItem("articles"));
			console.log($scope.panier.articles);*/
		
		
		/*$scope.addPanier=function(nomModele,prix,taille,quantite,couleur){
			$scope.size=taille;
			sharedPropertiesService.setValue(1,$scope.size);
			$scope.color=couleur;
			sharedPropertiesService.setValue(2,$scope.color);
			$scope.quantity=quantite;
			sharedPropertiesService.setValue(3,$scope.quantity);
			$scope.nomModele=nomModele;
			sharedPropertiesService.setValue(4,$scope.nomModele);
			$scope.prix=prix;
			sharedPropertiesService.setValue(5,$scope.prix);
			console.log($scope.size);
			console.log($scope.color);
			console.log($scope.quantity);
			console.log($scope.nomModele);
			console.log($scope.prix);
		}
		$scope.panier={
			nomModele:sharedPropertiesService.getValue(4),
			prix:sharedPropertiesService.getValue(5),
			taille:sharedPropertiesService.getValue(1),
			quantite:sharedPropertiesService.getValue(3),
			couleur:sharedPropertiesService.getValue(2)
		
		};
		$scope.size=sharedPropertiesService.getValue(1);
		$scope.color=sharedPropertiesService.getValue(2);
		$scope.quantity=sharedPropertiesService.getValue(3);
		$scope.nomModele=sharedPropertiesService.getValue(4);
		$scope.prix=sharedPropertiesService.getValue(5);*/
	
	});