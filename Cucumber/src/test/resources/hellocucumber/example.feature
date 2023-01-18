Feature: A set of scenarios for testing the PrestaShop

  Scenario: User adds item to shopping cart, admin sets item to be out of stock
    Given User is on the catalog
    When User adds item to cart
    And Admin set item stock to 0
    And User continue to checkout
    Then Message displayed item out of stock!

#*********************** work
  Scenario: User adds item that is on sale to cart, admin changed the discount
    Given User is on the catalog
    When User adds item for sale to cart
    And Admin changed the discount of the item
    And User continue to checkout with sale item
    Then Price and discount changed in the checkout window
#*********************** work

#  user adds item to cart:
#  clicks on the item , adds to shopping cart with quantity, etc..., returns to catalog
#
#  admin sets stock:
#  admin init,admin login, catalogue -> stock -> find product -> change stock amount to 0
#
#  user returns to shopping cart:
#  click shopping cart.
#
#  messege displayed:

