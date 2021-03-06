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
// Define the REST resource service, allowing us to interact with it as a high level service
angular.module('modelesService', ['ngResource'])
	.factory('Modeles', function($resource){
		return $resource('rest/modeles/');
	})
	.factory('Modele', function($resource){
		return $resource('rest/modeles/:nomModele', {nomModele: '@id'});
	}).factory('Categories', function($resource){
		return $resource('rest/categories/:nomCategorie', {nomCategorie: '@id'}); //,{'query':{method : 'GET'}}
	}).factory('Categorie', function($resource){
		return $resource('rest/admin/categorie/');
	}).factory('CategorieId', function($resource){
		return $resource('rest/admin/categorie/:nomCategorie', {nomCategorie: '@id'}, {
			delete:{method: 'DELETE', params: {nomCategorie: '@id'}}
		})
	}).factory('ModeleAdmin', function($resource){
		return $resource('rest/admin/modele/');
	}).factory('ModeleId', function($resource){
		return $resource('rest/admin/modele/:nomModele', {nomModele: '@id'}, {
			delete:{method: 'DELETE', params: {nomModele: '@id'}}
		})
	})/*.factory('ModeleAddCat', function($resource){
		return $resource('rest/admin/modele/:nomModele/:listCat', {nomModele: '@id',listCat :'@listCat'}, {
			update:{method: 'PUT', params: {nomModele: '@id',listCat :'@listCat'}}
		})
	})*/;