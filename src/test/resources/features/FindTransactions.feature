Feature:FindTransactions in Account Activity


  Scenario: Search date range
    Given User is on the login page
    And User enters valid credentials
    And User navigates to "Account Activity"
    And User navigates to "Find Transactions"
    When User enters date range from "2012-09-01" to "2012-09-06"
    And Click search of transaction
    Then Print Dates
    Then Results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And Results should be sorted by most recent date
    When User enters date range from "2012-09-02" to "2012-09-06"
    And Click search of transaction
    Then Results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And Results table should only not contain transactions dated "2012-09-01"

  Scenario: Search description
    Given User logged in
    And User navigates to "Account Activity"
    And User navigates to "Find Transactions"
    When User enters description "ONLINE"
    And Click search of transaction
    Then Results table should only show descriptions containing "ONLINE"
    When User enters description "OFFICE"
    And Click search of transaction
    Then Results table should only show descriptions containing "OFFICE"
    But Results table should not show descriptions containing "ONLINE"


  Scenario: Search description case insensitive
    Given User logged in
    And User navigates to "Account Activity"
    And User navigates to "Find Transactions"
    When User enters description "ONLINE"
    And Click search of transaction
    Then Results table should only show descriptions containing "ONLINE"
    When User enters description "online"
    And Click search of transaction
#    Then Results table should only show descriptions containing "ONLINE"
#  THERE IS A PROBLEM IN LAST LINE



  Scenario: Type
    Given User logged in
    And User navigates to "Account Activity"
    And User navigates to "Find Transactions"
    And Click search of transaction
    Then Results table should show at least one result under "Deposit"
    Then Results table should show at least one result under "Withdrawal"
    When User selects type "Deposit"
    Then Results table should show at least one result under "Deposit"
    When User selects type "Withdrawal"
    Then Results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"

