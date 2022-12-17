Feature: Login functionality

@sprint1 @regression
  Scenario: Valid admin login
    #Given user navigates to hrms application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in

  @regression @tc11002
  Scenario: Valid ess login
    #Given user navigates to hrms application
    When user enters ess username and ess password
    And user clicks on login button
    Then user is successfully logged in

    @regression @tc11003
   Scenario: Invalid admin login
     #Given user navigates to hrms application
     When user enters invalid username and password
     And user clicks on login button
     Then error message is displayed

      @tc11005
   Scenario Outline:
     When User enters different "<usernam>" and "<password>" and verify the "<error>" for it
     Examples:
       | usernam | password | error |
       | admin   | cristiano|Invalid credentials|
       | ronaldo | Hum@nhrm123| Invalid credentials|
       |         | Hum@nhrm123|Username cannot be empty|
       |admin    |          | Password cannot be empty |