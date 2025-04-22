package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.TC_006Page;

public class TC_006Steps {
    TC_006Page tc_006Page = new TC_006Page();

    @Given("^El usuario ha exportado el archivo Excel$")
    public void usuarioHaExportadoExcel() {
        tc_006Page.exportarExcel();
    }

    @When("^El usuario verifica las columnas 'IVA 0%', 'IVA exento', y 'IVA retenido'$")
    public void usuarioVerificaColumnas() {
        tc_006Page.verificarColumnas();
    }

    @Then("^Las columnas deben existir y estar en el orden especificado$")
    public void columnasExistenYOrdenCorrecto() {
        boolean resultado = tc_006Page.columnasExistenYEstanOrdenadas();
        Assert.assertTrue("Las columnas no están en el orden especificado o no existen.", resultado);
    }

    @Then("^Cada columna debe tener el formato esperado para montos$")
    public void columnasConFormatoCorrecto() {
        boolean formatoCorrecto = tc_006Page.verificarFormatoColumnas();
        Assert.assertTrue("El formato de las columnas no es el esperado.", formatoCorrecto);
    }
}