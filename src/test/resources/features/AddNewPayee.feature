Feature: Add New Payee Under Pay Bills


  Scenario: Add A New Payee
    Given User logged in
    And User navigates to "Pay Bills"
    And User navigates to "Add New Payee"
    When User creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Samest, Anytown, USA, 10001          |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed