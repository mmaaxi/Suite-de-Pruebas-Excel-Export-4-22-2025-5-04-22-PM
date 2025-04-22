package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.tc_003Page;
import org.junit.Assert;

public class tc_003Steps {

    tc_003Page page = new tc_003Page();

    @Given("que el Excel exportado está abierto")
    public void abrirExcelExportado() {
        page.abrirExcel();
    }

    @When("ubico la columna 'estado'")
    public void ubicarColumnaEstado() {
        boolean isLocated = page.verificarUbicacionColumnaEstado();
        Assert.assertTrue("La columna 'estado' no se encuentra en la ubicación correcta.", isLocated);
    }

    @Then("la columna 'estado' se muestra en la ubicación correcta")
    public void verificarUbicacionCorrecta() {
        // Expected to be validated in previous step
    }

    @When("comparo los valores y formato de la columna con la hoja 'Descripción de Campos' Fila 12 – ID 11")
    public void compararValoresYFormato() {
        boolean isUpdated = page.compararValoresYFormato();
        Assert.assertTrue("Los valores y formato no están correctamente actualizados.", isUpdated);
    }

    @Then("los valores y formato correspondientes están correctamente actualizados")
    public void verificarValoresYFormatoCorrectos() {
        // Expected to be validated in previous step
    }
}