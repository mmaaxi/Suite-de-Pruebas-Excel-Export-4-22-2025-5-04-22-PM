Feature: Validar actualización de fórmula en el Movimiento de 'Pago'

  Scenario: Verificar celda de Monto Acumulado Folio OPC y fórmula correcta en movimiento de pago
    Given El usuario está en la sección de Pago
    When Localiza la celda de 'Monto Acumulado Folio OPC (2121)'
    Then La celda se encuentra en el lugar correcto para el movimiento de pago
    When Verifica que la fórmula =Z4+AD5+AE5+AH5+AC5+AB5+AM5 se aplique correctamente
    Then La suma incluye todos los montos requeridos correctamente