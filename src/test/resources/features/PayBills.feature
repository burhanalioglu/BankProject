Feature: Pay Bills Page

  Scenario: User should be able to navigate to Pay Bills
    Given User logged in
    When User navigates to "Pay Bills"
    Then "Zero - Pay Bill" page should be displayed

  Scenario: User should be able to make payment
    Given User logged in
    And User navigates to "Pay Bills"
    When User selects "Bank of America" as Payee
    And User selects type "Loan" as Account Type
    And User enters "100" as Amount
    And User enters "12-12-2012" as Date
    And User enters "random description" as Description
    And User clicks on "Pay" button
    Then The payment was successfully submitted. message should be displayed

  @wip
  Scenario Outline: User should not be able to make payment without date or amount
    Given User logged in
    And User navigates to "Pay Bills"
    When User selects "Bank of America" as Payee
    And User selects type "Loan" as Account Type
    And User enters "<amount>" as Amount
    And User enters "<date>" as Date
    And User enters "random description" as Description
    And User clicks on "Pay" button
    Then Please fill out this field. message should be displayed on "<element>"
    Examples:
      | amount | date       | element |
      | 100    |            | date    |
      |        | 12-12-2012 | amount  |