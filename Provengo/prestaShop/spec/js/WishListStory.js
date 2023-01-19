// @provengo summon selenium


story('user signs up, and adds item to wish list', function (session, e){
    let user = new SeleniumSession().start('https://demo.prestashop.com/#/en/front')
    user.signUp(user)
    user.addsToWish(user)

})

story('admin logs in and change stock item quantity to 0', function(session, e) {
    let admin = new SeleniumSession().start('https://demo.prestashop.com/#/en/back')
    admin.changeQuantity(admin)
})

