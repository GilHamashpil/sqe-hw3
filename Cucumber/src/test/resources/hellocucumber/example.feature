Feature: A set of scenarios for testing the PrestaShop


  Scenario: User adds item to shopping cart, admin sets item to be out of stock
    Given User is on the catalog
    When User adds item to wishlist
    And Admin set item stock to 0
    And User comeback to wishlist
    Then Message displayed item out of stock!

#*********************** work
  Scenario: User adds item that is on sale to cart, admin changed the discount
    Given User is on the catalog
    When User adds item for sale to cart
    And Admin changed the discount of the item
    And User continue to checkout with sale item
    Then Price and discount changed in the checkout window
#*********************** work



