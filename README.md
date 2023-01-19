# Assignment 3: Software Quality Engineering
This is a repository for assignment 3 of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called PrestaShop (https://demo.prestashop.com/#/en/front).

PrestaShop is a store where you can buy products and send them to a desired address exactly the same concept as eBay or AliExpress.

## Installation
You have two links:
admins environment : (https://demo.prestashop.com/#/en/front)
customer's environment : (https://demo.prestashop.com/#/en/back)

## What we tested

We tested the Sale module and WishList module . We chose to test the following user stories: 

*User story:* A customer adds a new item for sale to the shopping cart

*Preconditions:* The admin change the discount of this product

*Expected outcome:* When the customer wants to continue to checkout the discount changed property

*User story:* A customer adds a new item to the wishlist

*Preconditions:* The admin change the quantity of this product to 0

*Expected outcome:* when costumer comeback to wishlist - there is a massage "Product out of sale"


## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a BDD testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

