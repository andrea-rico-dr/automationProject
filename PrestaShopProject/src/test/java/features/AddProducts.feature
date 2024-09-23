Feature: Add Products

Scenario: Add products to shopping cart
  Given that the user is registered and logged in
  And that the user is in the product page
  When the user clicks on the ADD TO CART button
  Then the confirmation modal is displayed
  And the product is added to the shopping cart