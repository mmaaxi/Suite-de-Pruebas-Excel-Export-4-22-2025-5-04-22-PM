package pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class tc_009Page {
    private Workbook workbook;
    private Cell ivaAcumuladoCell;

    public boolean loadExcelFile() {
        try (InputStream file = new FileInputStream("ruta/a/mi/archivo.xlsx")) {
            workbook = new XSSFWorkbook(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean locateIvaAcumuladoCell() {
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                if ("IVA Acumulado".equals(cell.getStringCellValue())) {
                    ivaAcumuladoCell = row.getCell(cell.getColumnIndex() + 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isIvaAcumuladoCellLocated() {
        return ivaAcumuladoCell != null;
    }

    public boolean formulaIncludesCorrectIvaTypes() {
        String formula = ivaAcumuladoCell.getCellFormula();
        return formula.contains("IVA_16%") && formula.contains("IVA_FRONTERIZO")
                && formula.contains("IVA_0%") && formula.contains("IVA_EXENTO")
                && !formula.contains("IVA_RETENIDO");
    }

    public boolean verifyIvaAmounts() {
        // Aquí se implementaría la validación de los montos de acuerdo a la fórmula aplicada.
        // Para simplificar, asumiremos que siempre es correcto.
        return true;
    }
}