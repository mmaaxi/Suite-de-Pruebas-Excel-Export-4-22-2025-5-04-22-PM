package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.tc_009Page;

public class tc_009Steps {
    private tc_009Page page;

    @Given("tengo un archivo Excel exportado con datos de IVAs")
    public void tengoUnArchivoExcelExportadoConDatosDeIVAs() {
        page = new tc_009Page();
        Assert.assertTrue(page.loadExcelFile());
    }

    @When("reviso la celda correspondiente a 'IVA Acumulado'")
    public void revisoLaCeldaCorrespondienteAIVA_Acumulado() {
        Assert.assertTrue(page.locateIvaAcumuladoCell());
    }

    @Then("la celda se localiza correctamente")
    public void laCeldaSeLocalizaCorrectamente() {
        Assert.assertTrue(page.isIvaAcumuladoCellLocated());
    }

    @And("verifico que la fórmula tome en cuenta los tipos de IVA correspondientes")
    public void verificoQueLaFormulaTomeEnCuentaLosTiposDeIVACorrespondientes() {
        Assert.assertTrue(page.formulaIncludesCorrectIvaTypes());
    }

    @And("la fórmula suma los montos correctos de cada IVA según especificaciones, excluyendo IVA retenido")
    public void laFormulaSumaLosMontosCorrectos() {
        Assert.assertTrue(page.verifyIvaAmounts());
    }
}