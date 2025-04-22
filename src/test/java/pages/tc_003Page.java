package pages;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class tc_003Page {

    private static Workbook workbook;
    private static Sheet sheet;

    public void abrirExcel() {
        try {
            File excelFile = new File("path/to/exported/excel.xlsx");
            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verificarUbicacionColumnaEstado() {
        Row headerRow = sheet.getRow(0);
        boolean isCorrectLocation = false;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals("estado")) {
                isCorrectLocation = true;
                break;
            }
        }
        return isCorrectLocation;
    }

    public boolean compararValoresYFormato() {
        Sheet hojaDescripcion = workbook.getSheet("Descripción de Campos");
        Row descripcionRow = hojaDescripcion.getRow(11); // ID 11, es decir, fila 12

        for (Row row : sheet) {
            Cell estadoCell = row.getCell(findColIndex("estado"));

            // Compare value
            String descripcionValue = descripcionRow.getCell(11).getStringCellValue();
            if (!estadoCell.getStringCellValue().equals(descripcionValue)) {
                return false;
            }

            // Compare format (assuming similar cell styles, customization needed)
            CellStyle estadoStyle = estadoCell.getCellStyle();
            CellStyle descripcionStyle = descripcionRow.getCell(11).getCellStyle();
            if (!estadoStyle.equals(descripcionStyle)) {
                return false;
            }
        }
        return true;
    }

    private int findColIndex(String columnName) {
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return -1;
    }
}