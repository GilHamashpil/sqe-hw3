// @provengo summon selenium

/**
 * In this story a customer adds item on sale to his shopping cart, and the admin changes the discount percentage.
 *   Scenario: User adds item that is on sale to cart, admin changed the discount
 *     Given User is on the catalog
 *     When User adds item for sale to cart
 *     And Admin changed the discount of the item
 *     And User continue to checkout with sale item
 *     Then Price and discount changed in the checkout window
 */
// story('User adds item to cart, admin drops stock to 0', function () {
//   let s = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
//   s.clickItem()
//   // s.composeQuery({ text: 'Pizza' })
//   // s.startSearch()
// })

/**
 * In this story a user adds item to wish list with quantity x, admin drops item stock to be < x  .
 *   Scenario: User adds item to shopping cart, admin sets item to be out of stock
 *     Given User is on the catalog
 *     When User adds item to cart
 *     And Admin set item stock to 0
 *     And User continue to checkout
 *     Then Message displayed item out of stock!
 */

story('user signs up, and adds item to wish list', function (session, e){
  let user = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
  user.signUp(user)
  user.addsToWish(user)

})

story('admin logs in and change stock item quantity to 0', function(session, e) {
  let admin = new SeleniumSession().start('https://demo.prestashop.com/#/en/back')
  admin.changeQuantity(admin)
})

  // let admin = new SeleniumSession.start('https://demo.prestashop.com/#/en/back')
  // let user = new SeleniumSession.start('https://demo.prestashop.com/#/en/front')
  // user.addsItemToCart()    // TODO need to implement
  // the "with" statement makes it redundant to write "s." before each call to a defined event (like the story above)
  // composeQuery({ text: 'Pizza' })
  // feelLucky()
// })