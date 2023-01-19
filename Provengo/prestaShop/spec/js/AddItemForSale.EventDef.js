/* @Provengo summon selenium */



/**
 *  The UserAddsItemForSaleToCart event defines the selenium actions for User that add an item for sale to cart
 */
defineEvent(SeleniumSession, "UserAddsItemForSaleToCart", function (sessionUser,event) {
        bp.log.info(event);
        sessionUser.switchFrame("/html/body/div/div[2]/div/iframe")
        sessionUser.scrollToBottom(null)
        sessionUser.sleep(7000)
        sessionUser.click("/html/body/main/section/div/div/div/section/section/section[1]/div/div[2]/article/div/div[2]/h3/a")
        sessionUser.sleep(1000)
        sessionUser.click("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")


})

/**
 *  The UserContinueToCheckoutWithSaleItem event defines the selenium actions for User that continue to checkout
 */
defineEvent(SeleniumSession, "UserContinueToCheckoutWithSaleItem", function (sessionUser,event) {
        bp.log.info(event);
        sessionUser.sleep(1000);
        sessionUser.click("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")

})

/**
 *  The AdminChangedTheDiscount event defines the selenium actions for Admin change the discount of the item
 */
defineEvent(SeleniumSession, "AdminChangedTheDiscount", function (sessionAdmin,event) {
        bp.log.info(event);
        //Moving into the right frame
        sessionAdmin.switchFrame("/html/body/div/div[2]/div/iframe")
        //Admin log in into the system
        sessionAdmin.sleep(7000)
        sessionAdmin.click("/html/body/div/div/div/div[3]/div/div[1]/form/div[3]/button/span")

        //press on the Catalog button
        sessionAdmin.sleep(1000)
        sessionAdmin.click("/html/body/nav/div/ul/li[4]/a/span")

        //Get into the products and change the discount of "Hummingbird printed sweater" to 10%
        sessionAdmin.sleep(1000)
        sessionAdmin.click("/html/body/nav/div/ul/li[4]/ul/li[1]/a")
        //scrolls down and select the item from the table
        sessionAdmin.sleep(1000)
        sessionAdmin.scrollToBottom(null)
        sessionAdmin.click("/html/body/div[2]/div/div[3]/div/form/div/table/tbody/tr[18]/td[4]/a")
        //press the pricing area
        sessionAdmin.sleep(1000)
        sessionAdmin.click("/html/body/div[1]/div/form/div[3]/div[1]/ul/li[4]/a")
        // scroll down and change the discount

        sessionAdmin.scrollToBottom(null)
        sessionAdmin.sleep(1000)
        sessionAdmin.click("/html/body/div[1]/div/form/div[3]/div[2]/div[4]/div/div[4]/div[2]/div/table/tbody/tr/td[13]/a/i")
        sessionAdmin.scrollToBottom(null)
        sessionAdmin.sleep(2000)
        sessionAdmin.writeText("/html/body/div[1]/div/form/div[3]/div[2]/div[4]/div/div[5]/div/div/div/div[2]/div/div[5]/div[1]/fieldset/div/div/input", "10", true)




})

/**
 *  The assertDiscount event defines the selenium actions for assert that the discount was update property
 */

defineEvent(SeleniumSession, "assertDiscount", function (session,event) {
        //bp.log.info(event);
        //session.assertText("xpath",event.data.description,TextAssertions.modifiers.Contains);
})
