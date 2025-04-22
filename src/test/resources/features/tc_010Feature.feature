Feature: Validación estructural general del Excel exportado

  Scenario: Verificación de la estructura del Excel exportado
    Given el usuario ha exportado los datos a Excel
    When el usuario revisa la estructura del archivo
    Then se confirma la presencia, ubicación y nombres correctos de todas las columnas modificadas y nuevas según la documentación

  Scenario: Pruebas de exportación con distintos escenarios de datos
    Given múltiples escenarios de datos para exportación
    When el usuario ejecuta las pruebas de exportación
    Then cada escenario muestra los datos y cálculos de forma coherente y sin errores