Feature: User Login Validation
@ehsan
  Scenario: Attempt to log in with an empty username
    #Given the user is on the login page
    When the user enters an empty username and a password
    And the user clicks the login button
    Then the system should display an error message "Username cannot be empty"
@ehsan1
  Scenario: Attempt to log in with an empty password
   #Given the user is on the login page
    When the user enters a username and an empty password
    And the user clicks the login button
  Then the system should display error message "Password is Empty"

  @ehsan2
  Scenario: Attempt to log in with incorrect credentials
    #Given the user is on the login page
    When the user enters an invalid username and password
    And the user clicks the login button
    Then an error message "Invalid credentials"

    @ehsan3
    Scenario: Attempt to log in with valid credentials
      #Given the user is on the login page
      When the user enters a valid username and valid password
      And the user clicks the login button
      Then the user should be logged in successfully
