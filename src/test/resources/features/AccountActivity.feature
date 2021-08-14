Feature: Account Activity

  @wip
  Scenario: Page should have Zero –Account activity title
    Given User logged in
    When User navigates to "Account Activity"
    Then "Zero - Account Activity" page should be displayed
    And Account dropdown should have "Savings" selected
    And Account dropdown should have following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And User sees following columns in Transactions table
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
