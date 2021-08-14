Feature: Login Feature

  Scenario: Login With Valid Credentials
    Given User is on the login page
    When User enters valid credentials
    Then "Account Summary" page should be displayed


  Scenario Outline:Login With Invalid Credentials as: "<username>" "<password>"
    Given User is on the login page
    When User enters credentials as "<username>" and "<password>"
    Then "Log in" page should be displayed
    And "Login and/or password are wrong." message should be displayed
    Examples:
      | username | password |
      | Invalid  | Invalid  |
      | Invalid  | Valid    |
      | Valid    | Invalid  |
      |          | Valid    |
      | Valid    |          |
      |          |          |