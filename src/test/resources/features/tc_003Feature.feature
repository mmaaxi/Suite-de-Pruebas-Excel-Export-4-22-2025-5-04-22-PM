Feature: Validar actualización de la columna 'estado'

  Scenario: Verificar que la columna 'estado' esté correctamente actualizada
    Given que el Excel exportado está abierto
    When ubico la columna 'estado'
    Then la columna 'estado' se muestra en la ubicación correcta

    And comparo los valores y formato de la columna con la hoja 'Descripción de Campos' Fila 12 – ID 11
    Then los valores y formato correspondientes están correctamente actualizados