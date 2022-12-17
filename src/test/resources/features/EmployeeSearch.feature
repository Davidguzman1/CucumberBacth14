Feature: US-321 Searching the employee
  Background:
    When user enters valid username and valid password
    And user clicks on login button
    When user clicks on PIM option
    And user clicks on employeeList option

  @sprint4
  Scenario: Search employee by id
    #Given user navigates to hrms application
    When user enters valid employee id
    And user clicks on search button
    Then user can see employee information is displayed

    @sprint4
    Scenario: Search employee by name
      #Given user navigates to hrms application
      #When user enters valid username and valid password
      #And user clicks on login button
      #When user clicks on PIM option
      #And user clicks on employeeList option
      When user enters valid employee name
      And user clicks on search button
      Then user can see employee information is displayed