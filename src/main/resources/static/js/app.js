(function (){
	var app=angular.module('store',['store-products']);

	var gem =[{
	name:'Pearl',
	price:2.95,
	description: 'Some gems have hidden qualities',
	canPurchase: true,
	soldOut: false,
	specification: '',
	reviews: [{
	stars: 5,
	body:"I love this product!",
	author:"joe"
	},
	{
	stars: 1,
	body:"this product sucks",
	author: "tim"
	}
	]
	image : {
	full:'pearl.jpg',
	thumb: 'pearl.jpg'
	}

	}]
})