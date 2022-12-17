Feature: Dashboard functionality

  @sprint2 @regression
  Scenario: Verify dashboard
    #Given user navigates to hrms application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    Then user verify dashboard page
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

