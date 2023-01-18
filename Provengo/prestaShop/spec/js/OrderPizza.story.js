/* @provengo summon selenium */

/**
 * In this story a customer adds item on sale to his shopping cart, and the admin changes the discount percentage.
 */
story('User adds item to cart, admin drops stock to 0', function () {
  let s = new SeleniumSession().start('https://google.com')
  s.composeQuery({ text: 'Pizza' })
  s.startSearch()
})

/**
 * In this story a user adds item to cart, admin drops item stock to 0 .
 */
story('user adds item to cart, admin drops item stock to 0', function () {
  // the "with" statement makes it redundant to write "s." before each call to a defined event (like the story above)
  with (new SeleniumSession().start('https://google.com')) {
    composeQuery({ text: 'Pizza' })
    feelLucky()
  }
})