@cartFeatures
Feature: Cart Functionality
Background:  
		Given user is at the homepage
    When User searches the product
    And User clicks on the product
    And User clicks add to cart button

  Scenario: User adds a product in cart successfully
   
    Then the product gets added to the cart successfully
    
    
  Scenario: User deletes a product from the cart successfully
  	Given User is at the cart page with a product
  	When User clicks on delete button
  	Then the product is removed from the cart successfully
