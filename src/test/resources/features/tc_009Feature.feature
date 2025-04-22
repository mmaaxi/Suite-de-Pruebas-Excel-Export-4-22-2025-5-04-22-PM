Feature: Validar modificación a la fórmula de 'IVA Acumulado'

  Scenario: Verificar fórmula de IVA Acumulado en el Excel exportado
    Given tengo un archivo Excel exportado con datos de IVAs
    When reviso la celda correspondiente a 'IVA Acumulado'
    Then la celda se localiza correctamente
    And verifico que la fórmula tome en cuenta los tipos de IVA correspondientes
    And la fórmula suma los montos correctos de cada IVA según especificaciones, excluyendo IVA retenido