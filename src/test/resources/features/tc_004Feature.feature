Feature: Validate the calculation of 'Monto acumulado Folio Reserva 5401'

  Scenario: Verify new accumulated amount column position and calculation
    Given I am on the reservation page
    When I locate the 'Monto acumulado Folio Reserva 5401' column
    Then The column should be positioned to the right of 'Monto (reserva)'
    When I enter previous accumulated amount and current reservation amount as test data
    Then The accumulated amount formula should correctly add the previous accumulated amount and the current reservation amount