// @Provengo summon selenium

/**
 *  The ComposeQuery event defines the selenium actions for writing the query that was given in the parameter e.
 */
// defineEvent(SeleniumSession,'ClickItem', function(user,e){
//   user.switchFrame("/html/body/div/div[2]/div/iframe")
//   user.scrollToBottom(null)
//   user.sleep(8000)
//   user.click("/html/body/main/section/div/div/div/section/section/section[1]/div/div[2]/article/div/div[2]/h3/a")
//   user.sleep(2000)
//   user.click("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
// })

defineEvent(SeleniumSession, 'SignUp', function(user, e){
  user.sleep(8000)
  user.switchFrame("/html/body/div/div[2]/div/iframe")
  user.click("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a")
  user.click("/html/body/main/section/div/div/div/section/div/div/a")
  user.click("/html/body/main/section/div/div/div/section/div/section/form/div/div[1]/div[1]/label[1]/span/input")
  user.writeText("/html/body/main/section/div/div/div/section/div/section/form/div/div[2]/div[1]/input" , "Gil", true)
  user.writeText("/html/body/main/section/div/div/div/section/div/section/form/div/div[3]/div[1]/input" , "Mich", true)
  user.writeText("//*[@id=\"field-email\"]" , "gil@gmail.com", true)
  user.writeText("//*[@id=\"field-password\"]" , "*Am4mneXjt", true)
  user.writeText("/html/body/main/section/div/div/div/section/div/section/form/div/div[6]/div[1]/input" , "01/06/1996", true)
  user.click("/html/body/main/section/div/div/div/section/div/section/form/div/div[9]/div[1]/span/label/input")
  user.click("/html/body/main/section/div/div/div/section/div/section/form/footer/button")
})
defineEvent(SeleniumSession, 'addsToWish', function(user, e){
  user.click("//*[@id=\"content\"]/section[1]/div/div[6]/article/div/div[1]/a")
  user.click("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/button")
  user.click("//*[@id=\"footer\"]/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li/p")
})
defineEvent(SeleniumSession,'ChangeQuantity', function(sessionAdmin, e){
  sessionAdmin.switchFrame("/html/body/div/div[2]/div/iframe")
  sessionAdmin.sleep(8000)
  sessionAdmin.click("/html/body/div/div/div/div[3]/div/div[1]/form/div[3]/button") //click on log in button
  sessionAdmin.click("/html/body/nav/div/ul/li[4]/a/span")        // click on catalog
  sessionAdmin.click("//*[@id=\"subtab-AdminStockManagement\"]/a")
  sessionAdmin.scrollToBottom(null)
  sessionAdmin.writeText("/html/body/div[2]/div/div/div[6]/section/div[2]/table/tbody/tr[26]/td[9]/form/div/input" , "-300", true)
  sessionAdmin.moveToElement("//*[@id=\"app\"]/div[6]/section/div[2]/table/tbody/tr[26]/td[9]/form/button")
  sessionAdmin.click("/html/body/div[2]/div/div/div[6]/section/div[2]/table/tbody/tr[26]/td[9]/form/button")
})
/html/body/main/section/div/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[1]

//
//
// defineEvent(SeleniumSession, "ComposeQuery", function(session, e) {
//   bp.log.info(e)
//   session.writeText("//input[@name='q']", e.text)
// })
//
// /**
//  * The StartSearch event defines the selenium action for clicking the search button.
//  */
// defineEvent(SeleniumSession, "StartSearch", function(session, e) {
//   session.click("//input[@name='btnK']")
// })
// /**
//  * The FeelLucky event defines the selenium action for clicking the "I'm feeling lucky button".
//  */
// defineEvent(SeleniumSession, "FeelLucky", function(session, e) {
//   session.click("//input[@name='btnI']") 
// })