import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_007Page {

    WebDriver driver;

    By montoAcumuladoCell = By.xpath("//td[contains(text(), 'Monto Acumulado Folio OPC (2121)')]");
    By formulaCell = By.xpath("//td[@data-formula='=Z4+AD5+AE5+AH5+AC5+AB5+AM5']");

    public tc_007Page(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMontoAcumuladoCellPresent() {
        return driver.findElements(montoAcumuladoCell).size() > 0;
    }

    public boolean isFormulaAppliedCorrectly() {
        return driver.findElements(formulaCell).size() > 0;
    }
}