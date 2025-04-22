package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.tc_010Page;

import static org.junit.Assert.assertTrue;

public class tc_010Steps {

    tc_010Page page = new tc_010Page();

    @Given("el usuario ha exportado los datos a Excel")
    public void el_usuario_ha_exportado_los_datos_a_Excel() {
        page.exportDataToExcel();
    }

    @When("el usuario revisa la estructura del archivo")
    public void el_usuario_revisa_la_estructura_del_archivo() {
        page.reviewExcelStructure();
    }

    @Then("se confirma la presencia, ubicación y nombres correctos de todas las columnas modificadas y nuevas según la documentación")
    public void se_confirma_la_presencia_ubicacion_y_nombres_correctos_de_todas_las_columnas_modificadas_y_nuevas_según_la_documentación() {
        assertTrue(page.isExcelStructureCorrect());
    }

    @Given("múltiples escenarios de datos para exportación")
    public void multiples_escenarios_de_datos_para_exportacion() {
        page.prepareMultipleDataScenarios();
    }

    @When("el usuario ejecuta las pruebas de exportación")
    public void el_usuario_ejecuta_las_pruebas_de_exportación() {
        page.executeExportTests();
    }

    @Then("cada escenario muestra los datos y cálculos de forma coherente y sin errores")
    public void cada_escenario_muestra_los_datos_y_calculos_de_forma_coherente_y_sin_errores() {
        assertTrue(page.isDataConsistentAcrossScenarios());
    }
}