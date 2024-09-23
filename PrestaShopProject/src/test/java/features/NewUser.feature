Feature: User Registration

  Scenario: New users can register successfully

    Given that the user is in the Registration page
    When the users fills the form with valid information
    And clicks on the Save button
    Then the user is redirected to the home page
    And the user is logged in

