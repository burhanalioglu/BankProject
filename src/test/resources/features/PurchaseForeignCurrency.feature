Feature: Purchase Foreign Currency


  Scenario: Available currencies
    Given User logged in
    And User navigates to "Pay Bills"
    When User navigates to "Purchase Foreign Currency"
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |


  Scenario: Error message for not selecting currency
    Given User logged in
    And User navigates to "Pay Bills"
    And User navigates to "Purchase Foreign Currency"
      #without selecting a currency type
    When User tries to calculate cost
    Then Error message should be displayed


  Scenario: Error message for not entering value
    Given User logged in
    And User navigates to "Pay Bills"
    And User navigates to "Purchase Foreign Currency"
    And User selects "Japan (yen)" as currency
    #without entering a value
    When User tries to calculate cost
    Then Error message should be displayed
