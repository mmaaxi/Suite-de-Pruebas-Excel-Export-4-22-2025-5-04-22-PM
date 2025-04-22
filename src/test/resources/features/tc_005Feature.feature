Feature: Validate renamed column 'Monto Acumulado Folio OPC'

  Scenario: Verify renamed column in exported Excel
    Given I export the Excel file from the application
    When I check the column names in the Excel file
    Then I should see the column named 'Monto Acumulado Folio OPC (2121)'
    And the column name should match the documentation exactly