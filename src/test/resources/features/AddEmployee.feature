Feature: Add Employee To HRMS
  Background:
    When the user enters a valid username and valid password
    And the user clicks the login button
    Then the user should be logged in successfully
    When user clicks on PIM option
    When user clicks on add employee option



@rashid
  Scenario: Adding employee without providing a employee ID
    When user enters employees using data table and save them
      | firstName | middleName | lastName |
      |eh         |ra          |mu        |

@rashid1
Scenario: Adding ID
  When user enters employee id and save it
    | firstName | middleName | lastName |employeeID|
    |eh         |ra          |mu        |110360A  |

  @rashid2
  Scenario: Incomplete employee information
    When user enters incomplete information and see error message

      | firstName | middleName | lastName |employeeID|
      |eh         |ra          |mu        |62395369  |

