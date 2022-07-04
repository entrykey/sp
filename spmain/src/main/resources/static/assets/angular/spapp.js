var spApp = angular.module("spApp", ["ngRoute"]);

spApp.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

spApp.directive('fileModel', [ '$parse', function($parse) {
    return {
        restrict : 'A',
        link : function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function() {
                scope.$apply(function() {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
} ]);

spApp.directive('locationDir', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) { 
                    var transformedInput = text.replace(/[^0-9]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

spApp.config(function($routeProvider,$locationProvider) {
	$routeProvider
		.when('/', {
			templateUrl: '/productList', 
			controller: 'ProductListController' 
		})
		.when('/sadd', {
			templateUrl: '/shopAdd',
			controller: 'ShopAddController'
		})
		.when('/padd', {
			templateUrl: '/productAdd',
			controller: 'ProductAddController'
		})
		.when('/plist', {
			templateUrl: '/productList',
			controller: 'ProductListController'
		})
		.when('/slist', {
			templateUrl: '/productList',
			controller: 'SecondController'
		})
		.otherwise({
			redirectTo: '/plist'
		});
	$locationProvider.hashPrefix('');
	
});

spApp.controller('ShopAddController', function($scope,$http) {	
	$scope.sopData={};
	$scope.pageTitle="Add Shop";
	$scope.shopName="";
	$scope.latitude="";
	$scope.longitude="";
	$scope.address="";
	$scope.city="";
	$scope.pin="";
	$scope.resp="";
	
	
	$scope.alertStatus=false;
	$scope.alertmsg="";
	
	$scope.saveShop=function(){
		var sopData = {  
				  shopName:$scope.shopName,
				  latitude:$scope.latitude,  
				  longitude:$scope.longitude,  
				  address:$scope.address,  
				  city:$scope.city,  
				  pincode:$scope.pin  
		   }; 
		  $http({
			    method : "POST",
			      url : "spshop/saveShop",
			      data:sopData
			  }).then(function mySuccess(response) {
			    $scope.resp = response.data;
			    setAlert(response);
			  }, function myError(response) {
			    $scope.resp = response.data;
			    setAlert(response);
			  });
	};
	
	function setAlert(msg){
		$scope.alertStatus=true;
		$scope.alertmsg=msg;
	}
	
});

spApp.controller('ProductListController', function($scope,$http,$location) {
	
	console.log($location);
	$scope.imgurl=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/sporder/pimage/";
	$scope.pageListTitle="List Product";
	$scope.resp="";
	$scope.alertStatus=false;
	$scope.alertmsg="";
	
	  $http({
		    method : "POST",
		      url : "spprod/getAllProduct",
		  }).then(function mySuccess(response) {
		    $scope.resp = response.data.data;
		  }, function myError(response) {
		    $scope.resp = response.data.data;
		  });
	  
	  $scope.deleteProduct = function(pid) {
		  var sopData = {  
					shopId:pid,	
		   };
		  
		  $http({
			    method : "POST",
			      url : "spprod/deleteProduct",
			      data:sopData
			  }).then(function mySuccess(response) {
			    $(".hidels"+pid).hide("slow");
			    $scope.deletes = response.data;
			    setAlert(response);
			  }, function myError(response) {
			    $scope.deletes = response.data;
			    setAlert(response);
			  });
	    };
	    
	  $scope.editProduct = function(pid) {
		  var sopData = {  
					shopId:pid,	
		   };
		  $("#basicModal").show();
		  
	    };
	    
	  
});

spApp.controller('ProductAddController', function($scope,$http) {
	
	$scope.pageTitle="Add Product";
	$scope.pageListTitle="List Product";
	$scope.resp="";
	$scope.shopeList="";
	$scope.shopeSelected="";
	
	$scope.shopId="";
	$scope.unitId="";
	$scope.productName="";
	$scope.barcode="";
	$scope.mrp=""; 
	$scope.cgst=""; 
	$scope.sgst=""; 
	$scope.offerPrice="";
	$scope.pimage=""; 
	
	$scope.alertStatus=false;
	$scope.alertmsg="";
	$scope.respunit="";
	
	  $http({
		    method : "POST",
		      url : "spprod/getAllUnit",
		  }).then(function mySuccess(response) {	
		    $scope.respunit = response.data.data;
		  }, function myError(response) {
		    $scope.respunit = response.data.data;
		  });
	
	  $http({
		    method : "POST",
		      url : "spshop/getlocations",
		  }).then(function mySuccess(response) {
		    $scope.shopeList = response.data.data;
		  }, function myError(response) {
		    $scope.shopeList = response.data.data;
		  });
	  
	  $scope.saveProduct=function(){
		  var fd = new FormData();
		  	if($scope.file!=undefined)
		  fd.append('productImage', $scope.file);
		  fd.append('shopId', $scope.shopId);
		  fd.append('unitId', $scope.unitId);
		  fd.append('productName', $scope.productName);
		  fd.append('barcode', $scope.barcode);
		  fd.append('mrp', $scope.mrp);
		  fd.append('cgst', $scope.cgst);		  
		  fd.append('sgst', $scope.sgst);
		  fd.append('offerPrice', $scope.offerPrice);

		  if($scope.barcode.length==13){
			  $http({
				    method : "POST",
				      url : "spprod/saveProduct",
				      headers : {'Content-Type' :undefined},
				      data:fd
				  }).then(function mySuccess(response) {
					$('.resetbtn').trigger('click');
				    $scope.resp = response.data;
				    setAlert(response);
				  }, function myError(response) {
				    $scope.resp = response.data;
				    setAlert(response);
				  });
		  }else{
			  alert("Please Enter 13 digit barcode displayed on the product");
		  }
		  
	  };
	  
	  function setAlert(msg){
			$scope.alertStatus=true;
			$scope.alertmsg=msg;
		}
	  
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




