package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.tc_001Page;
import org.junit.Assert;

public class tc_001Steps {
    tc_001Page page = new tc_001Page();

    @Given("^I am on the 'Canned Reports > Module Claim > Claim Accounting Report' page$")
    public void onReportPage() {
        page.navigateToClaimAccountingReport();
    }

    @When("^I export the Excel file$")
    public void exportExcelFile() {
        page.exportExcelFile();
    }

    @Then("^the system loads the Excel export correctly$")
    public void verifyExcelExportLoadedCorrectly() {
        Assert.assertTrue("Excel export was not loaded correctly", page.isExcelExportLoaded());
    }

    @When("^I open the exported Excel file$")
    public void openExportedExcel() {
        page.openExcelFile();
    }

    @Then("^I locate column C which should contain the new key$")
    public void locateColumnC() {
        Assert.assertTrue("New key column not found", page.isColumnCContainingKeys());
    }

    @When("^I verify the formula is applied correctly$")
    public void verifyFormula() {
        page.verifyConcatenateFormula();
    }

    @Then("^the key value is constructed correctly according to the formula$")
    public void verifyKeyConstruction() {
        Assert.assertTrue("Key value does not match expected construction", page.isKeyConstructedCorrectly());
    }
}