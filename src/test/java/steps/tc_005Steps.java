package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.tc_005Page;

public class tc_005Steps {
    tc_005Page page = new tc_005Page();

    @Given("I export the Excel file from the application")
    public void i_export_the_excel_file_from_the_application() {
        page.exportExcelFile();
    }

    @When("I check the column names in the Excel file")
    public void i_check_the_column_names_in_the_excel_file() {
        page.loadExcelFile();
    }

    @Then("I should see the column named 'Monto Acumulado Folio OPC \\(2121\\)'")
    public void i_should_see_the_column_named_monto_acumulado_folio_opc_2121() {
        Assert.assertTrue("Column name was not found!", page.isColumnPresent("Monto Acumulado Folio OPC (2121)"));
    }

    @Then("the column name should match the documentation exactly")
    public void the_column_name_should_match_the_documentation_exactly() {
        String expectedColumnName = "Monto Acumulado Folio OPC (2121)";
        Assert.assertEquals("Column name does not match the documentation",
                            expectedColumnName, page.getColumnNameFromExcel());
    }
}