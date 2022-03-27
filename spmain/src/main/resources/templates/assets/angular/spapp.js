var spApp = angular.module("spApp", ["ngRoute"]);
spApp.config(function($routeProvider) {
	$routeProvider
		.when('/view1', {
			templateUrl: 'view1.html',
			controller: 'FirstController'
		})
		.when('/view2', {
			templateUrl: 'view2.html',
			controller: 'SecondController'
		})
		.otherwise({
			redirectTo: '/view1'
		});
});

spApp.controller('FirstController', function($scope) {
	$scope.students = [
		{name: 'Mark Waugh', city:'New York'},
		{name: 'Steve Jonathan', city:'London'},
		{name: 'John Marcus', city:'Paris'}
	];

	$scope.message = "Click on the hyper link to view the students list.";
});


spApp.controller('SecondController', function($scope) {
	$scope.students = [
		{name: 'Mark Waugh', city:'New York'},
		{name: 'Steve Jonathan', city:'London'},
		{name: 'John Marcus', city:'Paris'}
	];

	$scope.message = "Click on the hyper link to view the students list.";
});