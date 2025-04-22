package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class tc_008Page {
    
    WebDriver driver;

    // Constructor to initialize driver
    public tc_008Page(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPresenceOfColumns() {
        List<String> columnTitles = getColumnTitlesFromExportedExcel();
        assertTrue("Folio Pre solicitud column is not present", columnTitles.contains("Folio Pre solicitud"));
        assertTrue("Folio de Pago column is not present", columnTitles.contains("Folio de Pago"));
        assertTrue("Status Pago Código column is not present", columnTitles.contains("Status Pago Código"));
    }

    public void verifyColumnsOrder() {
        List<String> columnTitles = getColumnTitlesFromExportedExcel();
        int indexFolioPreSolicitud = columnTitles.indexOf("Folio Pre solicitud");
        int indexFolioDePago = columnTitles.indexOf("Folio de Pago");
        int indexStatusPagoCodigo = columnTitles.indexOf("Status Pago Código");

        assertTrue("Folio Pre solicitud is not in correct order", indexFolioPreSolicitud > 0 && indexFolioDePago > indexFolioPreSolicitud);
        assertTrue("Status Pago Código is not in correct order", indexStatusPagoCodigo > columnTitles.indexOf("Fecha de Pago"));
    }

    public void verifyColumnRenaming() {
        List<String> columnTitles = getColumnTitlesFromExportedExcel();
        assertTrue("Descripción Status Pago column is not renamed correctly", columnTitles.contains("Descripción Status Pago"));
    }

    public void verifyNoInitialValuesInRenamedColumn() {
        // Implementation to open the exported excel and check the values in the renamed column.
        // This can be done using Apache POI or a similar library for handling Excel files.
        // Assuming there is a method that fetches the values of the given column.
        List<String> columnValues = getColumnValues("Descripción Status Pago");
        for (String value : columnValues) {
            assertTrue("Initial value found in renamed column", value.trim().isEmpty());
        }
    }

    private List<String> getColumnTitlesFromExportedExcel() {
        // Dummy method for fetching column titles from Excel file
        return List.of("Ramo", "Folio Pre solicitud", "Folio de Pago", "Fecha de Pago", "Status Pago Código");
    }
    
    private List<String> getColumnValues(String columnTitle) {
        // Dummy method to simulate fetching column values from Excel
        return List.of("", "");
    }
}