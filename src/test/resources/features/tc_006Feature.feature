Feature: Validar inclusión de columnas para IVA

  Scenario: Verificar la inclusión y formato de columnas de IVA en Excel exportado
    Given El usuario ha exportado el archivo Excel
    When El usuario verifica las columnas 'IVA 0%', 'IVA exento', y 'IVA retenido'
    Then Las columnas deben existir y estar en el orden especificado
    And Cada columna debe tener el formato esperado para montos