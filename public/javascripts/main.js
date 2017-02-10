var mainApp= angular.module('mainApp', []);

mainApp.controller('mainCtrl', function($scope) {
	$scope.first = 1;
	$scope.second = 1;
	
	$scope.updateValue = function() {
		$scope.calculation = $scope.first + ' + ' + $scope.second +
			" = " + (+$scope.first + +$scope.second);
	};
	
	//--------------------------------------------------------------
	
	$scope.sidebarOpen = true;
	$scope.searchedChar = "---";
	
	$scope.searchForChar = function() {
		$scope.searchedChar = document.getElementById("char-search").value;
	};
});