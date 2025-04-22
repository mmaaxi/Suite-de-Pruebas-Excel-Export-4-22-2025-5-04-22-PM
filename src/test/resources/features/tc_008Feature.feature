Feature: Validate inclusion of new columns related to Pre Solicitud and Pago

  Scenario: Validate new columns and renamed column in exported Excel
    Given the user exports the report to Excel
    When the user reviews the presence of 'Folio Pre solicitud', 'Folio de Pago', and 'Status Pago Código' columns
    Then these columns should appear in their respective positions
    And the 'Status de Pago' column should be renamed to 'Descripción Status Pago'
    And it should not contain initial values