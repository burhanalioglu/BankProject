Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given User is on the login page
    And User enters valid credentials

  Scenario: Savings account redirect
    When User clicks on "Savings" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown should have "Savings" selected

  Scenario: Brokerage account redirect
    When User clicks on "Brokerage" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown should have "Brokerage" selected

  Scenario: Checking account redirect
    When User clicks on "Checking" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown should have "Checking" selected

  Scenario: Credit Card account redirect
    When User clicks on "Credit Card" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown should have "Credit Card" selected

  Scenario: Loan account redirect
    When User clicks on "Loan" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown should have "Loan" selected