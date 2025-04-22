Feature: Validar inclusión y posición de la columna 'Estado Código' en el archivo Excel exportado desde el módulo de Reports

  Scenario: Comprobar la generación y estructura del archivo Excel
    Given El usuario ha iniciado sesión y navega al módulo de Reports
    When El usuario exporta el archivo Excel
    Then El archivo Excel se genera correctamente
    And La columna 'Estado Código' se encuentra inmediatamente a la derecha de la columna 'i'
    And El nombre de la columna es exactamente 'Estado Código'