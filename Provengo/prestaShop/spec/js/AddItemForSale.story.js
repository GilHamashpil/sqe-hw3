/* @provengo summon selenium */


const OLD_DISCOUNT = "20"
const NEW_DISCOUNT = "10"


/**
 * This story opens a new browser window, goes to prestaShop, and add an item for sale.
 */
story('User adds item that is on sale to cart and continue to checkout', function () {
    let sessionUser = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
    sessionUser.userAddsItemForSaleToCart(sessionUser)
    sessionUser.UserContinueToCheckoutWithSaleItem(sessionUser)

})


/**
 * This story opens a new browser window, goes to prestaShop as an admin and change the discount od an item.
 */
 story('admin changed the discount', function () {
    let sessionAdmin= new SeleniumSession().start('https://demo.prestashop.com/#/en/back')
    sessionAdmin.adminChangedTheDiscount(sessionAdmin)
})


/**
 * This story opens a new browser window, goes to prestaShop and check if the discount changed as it should be.
 */
// story('check discount after change', function () {
//
//     on(Any('EndOfAction').and({eventName:"adminChangedTheDiscount" }),function(){
//         let session = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
//         session.assertDiscount(session,{description: NEW_DISCOUNT})
//     })
//     interrupt(Any('EndOfAction').and({eventName:"adminChangedTheDiscount" }), function (){
//         let session = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
//         session.assertDiscount(session,{description: OLD_DISCOUNT})
//     })
//
// })




