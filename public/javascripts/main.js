var mainApp= angular.module('mainApp', []);

mainApp.controller('mainCtrl', function($scope) {
	/* Character Header Variables */
	$scope.charName = "Character Name";
	$scope.player ="Player Name";
	$scope.race = "Race";
	$scope.classList = ["Class lvl # /", "Class lvl #"];
	$scope.align = "Alignment";
	
	/* Description Variables */
	$scope.gender = "(gender)";
	$scope.age = 20;
	$scope.height = "(weight)";
	$scope.hair = "(hair)";
	$scope.eyes = "(eyes)";
	$scope.homeland = "(homeland)";
	$scope.deity = "(deity)";

	/* Ability Score Variables */
	$scope.str = 10;
	$scope.dex = 10;
	$scope.con = 10;
	$scope.inte = 10;
	$scope.wis = 10;
	$scope.cha = 10;
	
	$scope.strMod = Math.floor($scope.str / 2) - 5;
	$scope.dexMod = Math.floor($scope.dex / 2) - 5;
	$scope.conMod = Math.floor($scope.con / 2) - 5;
	$scope.inteMod = Math.floor($scope.inte / 2) - 5;
	$scope.wisMod = Math.floor($scope.wis / 2) - 5;
	$scope.chaMod = Math.floor($scope.cha / 2) - 5;
	
	/* Page Control Variables*/
	$scope.dot = "\u2022"
	$scope.sidebarOpen = true;
	$scope.searchedChar = "---";
	
	/* Page Control Functions */
	$scope.searchForChar = function() {
		$scope.searchedChar = document.getElementById("char-searchbox").value;
	};
});