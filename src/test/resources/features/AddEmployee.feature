Feature: Add Employee

Background:
  When user enters valid username and valid password
  And user clicks on login button
  When user clicks on PIM option
  And user clicks on add employee button
  @sprint3 @regression
  Scenario: Adding one employee

   # Given user navigates to hrms application
    And user enters first and last name
    And user clicks on save button
    Then employee added successfully

    @test1
    Scenario: Adding on employee using feature file
      And user enter "zalam" and "alla"
      And user clicks on save button
      Then employee added successfully


      @outline
      Scenario Outline: Adding multiple employees using feature file
        And user  enter "<fname>" and "<lname>" for adding multiple employees
        And user clicks on save button
        Then employee added successfully
        Examples:
          | fname | lname |
          | gulnam| sulnam|
          |rampal |chambel|
          | azam  |asel   |

        @datatable
        Scenario:  Adding multiple employees using data table
          When user adds multiple employees and verify they are added successfully
          |firstName|middleName|lastName|
          |Zara     |MS        |camile  |
          |birgul   |MS        |ozgin   |
          |alina    |MS        |bob     |

        @excel
        Scenario: user adds multiple employee from excel using excel file
          When user adds multiple employee from excel using "EmployeeData" and verify it
