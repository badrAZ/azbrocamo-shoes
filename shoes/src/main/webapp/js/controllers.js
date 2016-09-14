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
function ModelesCtrl($scope, $http, Modeles) {

    // Define a refresh function, that updates the data from the REST service
    $scope.refresh = function() {
        $scope.modeles = Modeles.query();
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
        $scope.newModele = {nomModele: "", note: ""};

        // clear messages
        $scope.clearMessages();
    };

    // Define a register function, which adds the Modele using the REST service,
    // and displays any error messages
    $scope.register = function() {
        $scope.clearMessages();

        Modeles.save($scope.newModele, function(data) {

            // Update the list of Modeles
            $scope.refresh();

            // Clear the form
            $scope.reset();

            // mark success on the registration form
            $scope.successMessages = [ 'Modele Registered' ];
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown  server error' ];
            }
        });

    };

    // Call the refresh() function, to populate the list of Modeles
    $scope.refresh();

    // Initialize newModele here to prevent Angular from sending a request
    // without a proper Content-Type.
    $scope.reset();

    // Set the default orderBy to the name property
    $scope.orderBy = 'nomModele';
}
function descriptionCtrl($scope, $http, Modeles) {
		
}

