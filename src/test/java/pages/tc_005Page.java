package pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tc_005Page {
    
    private static final String FILE_PATH = "path/to/exported/excel.xlsx";
    private Workbook workbook;

    public void exportExcelFile() {
        // Simulate exporting Excel file, if needed by application workflow
        // e.g., click on a button to download the file
    }

    public void loadExcelFile() {
        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH))) {
            this.workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isColumnPresent(String columnName) {
        Sheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        for (Cell cell : firstRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public String getColumnNameFromExcel() {
        Sheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        for (Cell cell : firstRow) {
            if (cell.getStringCellValue().equals("Monto Acumulado Folio OPC (2121)")) {
                return cell.getStringCellValue();
            }
        }
        return null;
    }
}