package steps;

import io.cucumber.java.en.*;
import pages.tc_002Page;

import org.junit.Assert;

public class tc_002Steps {

    private tc_002Page page;

    @Given("El usuario ha iniciado sesión y navega al módulo de Reports")
    public void elUsuarioHaIniciadoSesionYNavegaAlModuloDeReports() {
        page = new tc_002Page();
        page.navigateToReportsModule();
    }

    @When("El usuario exporta el archivo Excel")
    public void elUsuarioExportaElArchivoExcel() {
        page.exportExcelFile();
    }

    @Then("El archivo Excel se genera correctamente")
    public void elArchivoExcelSeGeneraCorrectamente() {
        Assert.assertTrue(page.isExcelFileGenerated());
    }

    @And("La columna 'Estado Código' se encuentra inmediatamente a la derecha de la columna 'i'")
    public void laColumnaEstadoCodigoSeEncuentraALaDerechaDeLaColumnaI() {
        Assert.assertTrue(page.isEstadoCodigoColumnInCorrectPosition());
    }

    @And("El nombre de la columna es exactamente 'Estado Código'")
    public void elNombreDeLaColumnaEsExactamenteEstadoCodigo() {
        Assert.assertEquals("Estado Código", page.getEstadoCodigoColumnName());
    }
}