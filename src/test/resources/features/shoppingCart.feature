Feature: Shopping cart

  Scenario: Add product to shopping cart
    Given I am on the page for a product
    When I add the product to the cart
    Then The cart contains the product
    
 Scenario: Remove product from shopping cart
    Given I have a product in the cart
    When I remove the product from the cart
    Then The cart does not contain the product
