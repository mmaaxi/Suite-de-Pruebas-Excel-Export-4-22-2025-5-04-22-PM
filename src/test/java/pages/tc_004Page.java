package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_004Page {

    WebDriver driver;

    private By montoAcumuladoColumn = By.xpath("//th[text()='Monto acumulado Folio Reserva 5401']");
    private By montoColumn = By.xpath("//th[text()='Monto (reserva)']");
    private By previousAccumulatedAmountInput = By.id("previousAccumulatedAmount");
    private By currentReservationAmountInput = By.id("currentReservationAmount");
    private By calculatedAmountField = By.id("calculatedAmount");

    public tc_004Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToReservationPage() {
        driver.get("http://yourwebsite.com/reservation");
    }

    public boolean isMontoAcumuladoColumnPresent() {
        return driver.findElements(montoAcumuladoColumn).size() > 0;
    }

    public boolean isColumnPositionCorrect() {
        int montoPosition = driver.findElement(montoColumn).getLocation().getX();
        int montoAcumuladoPosition = driver.findElement(montoAcumuladoColumn).getLocation().getX();
        return montoAcumuladoPosition > montoPosition;
    }

    public void enterTestDataForMonto() {
        driver.findElement(previousAccumulatedAmountInput).sendKeys("1000");
        driver.findElement(currentReservationAmountInput).sendKeys("500");
    }

    public boolean isAccumulatedAmountCalculationCorrect() {
        double expectedTotal = 1500.0;  // 1000 (previous) + 500 (current)
        double actualTotal = Double.parseDouble(driver.findElement(calculatedAmountField).getText());
        return expectedTotal == actualTotal;
    }
}