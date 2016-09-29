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



function ModelesCtrl($scope, $http, Modeles,$location,$routeParams,Categories) {

    // Define a refresh function, that updates the data from the REST service
    $scope.refresh = function() {
    	if($routeParams.nomCategorie != null){
    		$scope.nomCategorie =$routeParams.nomCategorie;
    		// $scope.modeles = Categories.get({nomCategorie:$routeParams.nomCategorie});//query({id:$scope.nomCategorie});
    		$scope.modeles = Categories.query({nomCategorie:$routeParams.nomCategorie});
    		console.log($scope.modeles);
    	}
    	else
    		{
    		$scope.modeles = Modeles.query();
    		}
        
    };

    // Define a clearMessages function that resets the values of the error and
    // success messages.
    $scope.clearMessages = function () {
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};
    };

    // Define a reset function, that clears the prototype newModele object, and
    // consequently, the form
    $scope.reset = function() {
        // Sets the form to it's pristine state
        if($scope.regForm) {
            $scope.regForm.$setPristine();
        }
        // Clear input fields. If $scope.newModele was set to an empty object {},
        // then invalid form values would not be reset.
        // By specifying all properties, input fields with invalid values are also reset.
      //  $scope.newModele = {nomModele: "", note: ""};

        // clear messages
        $scope.clearMessages();
    };

    // Call the refresh() function, to populate the list of Modeles
    $scope.refresh();

    // Initialize newModele here to prevent Angular from sending a request
    // without a proper Content-Type.
    $scope.reset();

    // Set the default orderBy to the name property
    if($routeParams.nomCategorie != null){$scope.orderBy = 'nomCategorie'} 
    else{$scope.orderBy = 'nomModele'};
    
}
function DescriptionCtrl($scope, $routeParams, Modele) {
	//$scope.dataR=angular.fromJson($scope.postObject.response);
	//$scope.test=dataR.data;

	$scope.nomModele = $routeParams.nomModele;
	$scope.modele=Modele.get({nomModele:$routeParams.nomModele});
	
	console.log($scope.modele);
	


	
}

function LoginCtrl($scope, $rootScope, $location, AuthenticationService){
	//RAZ creds
	$scope.clear = function(){
		AuthenticationService.ClearCredentials();
	}
	
	$scope.login = function () {
		$scope.clear();
		console.log("Username: "+$scope.username+" Password: "+$scope.password);
        $scope.dataLoading = true;
        AuthenticationService.Login($scope.username, $scope.password, function(response) {
            if(response.success) {
                AuthenticationService.SetCredentials($scope.username, $scope.password);
                $location.path('#/home');
            } else {
                $scope.error = response.message;
                $scope.dataLoading = false;
                console.log("Error logging in: "+$scope.error);
            }
        });
    };
    
    $scope.info = function(){
    	AuthenticationService.GetUser();
    }
	
}

function RegisterCtrl($scope){
	
}
function PanierCtrl($scope){
	$scope.panierPersist=function(taille,couleur,quantite){
		$scope.size=taille;
		$scope.color=couleur;
		$scope.quantity=quantite;
		console.log($scope.size);
		console.log($scope.color);
		console.log($scope.quantity);
	}
}
function adminCategorieCtrl($scope,Categorie,CategorieId){
	 $scope.reset = function() {
	            $scope.addCat.$setPristine();
	            $scope.newCategorie = {nomCategorie:""};
	 }
	 
	 
	 $scope.newCategorie = {nomCategorie:""};
	 
	 
	 $scope.categories=Categorie.query();
	 
	 
	 $scope.refresh=function(){
		 $scope.categories=Categorie.query();
	 }
	 
	 
	$scope.registerCategorie=function(){
		
		Categorie.save( $scope.newCategorie,function(data){
			$scope.refresh();
			$scope.reset();
		});
		
		
	}
	$scope.remove=function(nomCategorie){
		CategorieId.delete({nomCategorie:nomCategorie});
		 $scope.categories=Categorie.query();
		$scope.refresh();
	}
	
}
function adminModeleCtrl($scope,ModeleAdmin,ModeleId,Categorie,ModeleAddCat){
	 $scope.reset = function() {
	            $scope.addMod.$setPristine();
	            $scope.newModele = {nomModele:"",note:"0",prix:"",photo:"",description:""};
	 }
	 
	 
	 $scope.newModele = {nomModele:"",note:"0",prix:"",photo:"",description:""};
	 $scope.categories=Categorie.query();
	 
	 $scope.modeles=ModeleAdmin.query();
	 
	 
	 $scope.refresh=function(){
		 $scope.modeles=ModeleAdmin.query();
	 }
	 
	 
	$scope.registerModele=function(selectedCategories){
		
		ModeleAdmin.save( $scope.newModele,function(data){
			$scope.refresh();
			$scope.reset();
		});
		//ModeleAddCat.update($scope.newModele.nomModele,angular.fromJson(selectedCategories));
	}
	$scope.remove=function(nomModele){
		ModeleId.delete({nomModele:nomModele});
		 $scope.modeles=ModeleAdmin.query();
		$scope.refresh();
	}
	
}
