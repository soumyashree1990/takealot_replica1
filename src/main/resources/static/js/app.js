'use strict';
var MyApp = angular.module('MyStore', []).
config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/home', {
        templateUrl: 'WEB-INF/views/home.html',
        controller: MyController
    }).
    when('/products', {
        templateUrl: 'WEB-INF/views/products.html',
        controller: MyController
    }).
    when('/cart', {
        templateUrl: 'WEB-INF/views/cart.html',
        controller: MyController
    }).
    when('/login', {
        templateUrl: 'WEB-INF/views/login.html',
        controller: MyController
    }).
    otherwise({
        redirectTo: '/home'
    });
}]);

// we have created a store and shopping cart using data service
MyApp.factory("MyService", function () {
    var myStore = new store(); // it creates a store
    var myCart = new shoppingCart("MyStore");  // it creates a shopping cart

    // enable PayPal checkout with parameter that identifies the merchant
    myCart.addCheckoutParameters("PayPal", "abc@gmail.com");

    // return data object with store and cart
    return {
        store: StoreCart,
        cart: myCart
    };
});