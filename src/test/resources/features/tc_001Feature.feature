Feature: Validate correct construction of the New Key

  Scenario: Validate correct construction of the New Key in the exported Excel file
    Given I am on the 'Canned Reports > Module Claim > Claim Accounting Report' page
    When I export the Excel file
    Then the system loads the Excel export correctly

    When I open the exported Excel file
    Then I locate column C which should contain the new key

    When I verify the formula is applied correctly
    Then the key value is constructed correctly according to the formula