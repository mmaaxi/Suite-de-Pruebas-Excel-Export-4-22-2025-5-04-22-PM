package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.tc_004Page;

public class tc_004Steps {

    WebDriver driver;
    tc_004Page page;

    @Given("I am on the reservation page")
    public void i_am_on_the_reservation_page() {
        page = new tc_004Page(driver);
        page.navigateToReservationPage();
    }

    @When("I locate the 'Monto acumulado Folio Reserva 5401' column")
    public void i_locate_the_monto_acumulado_column() {
        Assert.assertTrue(page.isMontoAcumuladoColumnPresent(), "Column not found!");
    }

    @Then("The column should be positioned to the right of 'Monto (reserva)'")
    public void column_should_be_positioned_correctly() {
        Assert.assertTrue(page.isColumnPositionCorrect(), "Column position is incorrect!");
    }

    @When("I enter previous accumulated amount and current reservation amount as test data")
    public void i_enter_test_data_for_monto() {
        page.enterTestDataForMonto();
    }

    @Then("The accumulated amount formula should correctly add the previous accumulated amount and the current reservation amount")
    public void formula_should_correctly_add_amounts() {
        Assert.assertTrue(page.isAccumulatedAmountCalculationCorrect(), "The amount calculation is incorrect!");
    }
}