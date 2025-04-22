import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import pages.tc_007Page;

public class tc_007Steps {

    WebDriver driver;
    tc_007Page pagoPage;

    @Given("^El usuario está en la sección de Pago$")
    public void elUsuarioEstaEnLaSeccionDePago() throws Throwable {
        pagoPage = new tc_007Page(driver);
        // Navigate to payment section
    }

    @When("^Localiza la celda de 'Monto Acumulado Folio OPC \\(2121\\)'$")
    public void localizaCeldaMontoAcumuladoFolioOPC() throws Throwable {
        assertTrue("La celda no se encuentra en el lugar correcto para el movimiento de pago", 
                   pagoPage.isMontoAcumuladoCellPresent());
    }

    @Then("^La celda se encuentra en el lugar correcto para el movimiento de pago$")
    public void laCeldaSeEncuentraEnElLugarCorrecto() throws Throwable {
        // Assertion done in "When" step
    }

    @When("^Verifica que la fórmula =Z4\\+AD5\\+AE5\\+AH5\\+AC5\\+AB5\\+AM5 se aplique correctamente$")
    public void verificaFormulaAplicadaCorrectamente() throws Throwable {
        assertTrue("La fórmula no incluye todos los montos requeridos correctamente",
                   pagoPage.isFormulaAppliedCorrectly());
    }

    @Then("^La suma incluye todos los montos requeridos correctamente$")
    public void laSumaIncluyeTodosLosMontosCorrectamente() throws Throwable {
        // Assertion done in "When" step
    }
}