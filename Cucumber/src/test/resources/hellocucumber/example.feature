Feature: A set of scenarios for testing the Shopping Cart? module

  Scenario: User adds item to cart, admin drops stock to 0
    Given User is on the catalog
    When User adds item to cart
    And User returns to shopping
    And Admin set item stock to 0
    And user returns to shopping cart
    Then message displayed item out of stock!

  Scenario: Custumer adds item on sale to cart, admin changes discount percentage
    Given User is on the catalog
    When User adds discount item to cart
    And User returns to shopping
    And admin changes discount percentage
    And user returns to shopping cart
    Then message displayed price changed!
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

#  Scenario: User adds item on discount to cart, admin edit item discount percentage
#    Given User is on the catalog
#    When User adds item on discount to cart
#    And Admin changes discount
#    Then message displayed price changed!
