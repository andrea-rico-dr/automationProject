Feature: Checkout

Scenario: Complete Checkout process
  Given that the user is registered and logged in
  And the user has products in the cart
  And the user is the shopping cart page
  When the user clicks on PROCEED TO CHECKOUT button
  And the users fills valid address, shipping and payment information
  And clicks on the PLACE ORDER button
  Then an order confirmation message is displayed