Feature: Account Summary Page


  Scenario: Verify Page Title as Zero-Account summary
    Given User logged in
    When User navigates to "Account Summary"
    Then "Zero - Account Summary" page should be displayed

  Scenario: Account Summary Page should have following account types
    Given User logged in
    When User navigates to "Account Summary"
    Then User sees following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit accounts table should have following columns
    Given User logged in
    When User navigates to "Account Summary"
    Then User sees following columns in Credit Accounts table
      | Account     |
      | Credit Card |
      | Balance     |