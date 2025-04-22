package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.tc_008Page;

public class tc_008Steps {

    tc_008Page page = new tc_008Page();

    @When("the user reviews the presence of 'Folio Pre solicitud', 'Folio de Pago', and 'Status Pago Código' columns")
    public void theUserReviewsColumnsPresence() {
        page.verifyPresenceOfColumns();
    }

    @Then("these columns should appear in their respective positions")
    public void theseColumnsShouldAppearInTheirPositions() {
        page.verifyColumnsOrder();
    }

    @Then("the 'Status de Pago' column should be renamed to 'Descripción Status Pago'")
    public void theStatusDePagoColumnShouldBeRenamed() {
        page.verifyColumnRenaming();
    }

    @Then("it should not contain initial values")
    public void itShouldNotContainInitialValues() {
        page.verifyNoInitialValuesInRenamedColumn();
    }
}