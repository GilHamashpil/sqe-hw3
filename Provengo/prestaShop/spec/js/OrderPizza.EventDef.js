// @Provengo summon selenium

/**
 *  The ComposeQuery event defines the selenium actions for writing the query that was given in the parameter e.
 */
defineEvent(SeleniumSession,'ClickItem', function(session,e){
  session.switchFrame("/html/body/div/div[2]/div/iframe")
  sessionUser.scrollToBottom(null)
  sessionUser.sleep(8000)
  sessionUser.click("/html/body/main/section/div/div/div/section/section/section[1]/div/div[2]/article/div/div[2]/h3/a")
  sessionUser.sleep(2000)
  sessionUser.click("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
})
defineEvent(SeleniumSession,'ChangeQuantity', function(sessionAdmin, e){
  sessionAdmin.switchFrame("/html/body/div/div[2]/div/iframe")
  sessionAdmin.sleep(9000)
  sessionAdmin.click("/html/body/div/div/div/div[3]/div/div[1]/form/div[3]/button") //click on log in button
  sessionAdmin.sleep(5000)
  sessionAdmin.click("/html/body/nav/div/ul/li[4]/a/span")        // click on catalog
  sessionAdmin.sleep(2000)
  sessionAdmin.click("//*[@id=\"subtab-AdminStockManagement\"]/a")
})


defineEvent(SeleniumSession, "ComposeQuery", function(session, e) {
  bp.log.info(e)
  session.writeText("//input[@name='q']", e.text)
})

/**
 * The StartSearch event defines the selenium action for clicking the search button.
 */
defineEvent(SeleniumSession, "StartSearch", function(session, e) {
  session
  session.click("//input[@name='btnK']")

})
/**
 * The FeelLucky event defines the selenium action for clicking the "I'm feeling lucky button".
 */
defineEvent(SeleniumSession, "FeelLucky", function(session, e) {
  session.click("//input[@name='btnI']")
})