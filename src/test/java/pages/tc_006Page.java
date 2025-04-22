package pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

public class TC_006Page {

    private static final String FILE_PATH = "ruta/al/archivo/exportado.xlsx";

    public void exportarExcel() {
        // Método simulado para exportar Excel
        // La implementación real dependerá de cómo se realiza la exportación en la aplicación
    }

    public void verificarColumnas() {
        // Implementación para verificar las columnas específicas en el archivo Excel
    }

    public boolean columnasExistenYEstanOrdenadas() {
        try (FileInputStream file = new FileInputStream(new File(FILE_PATH))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            List<String> columnasEsperadas = List.of("IVA 0%", "IVA exento", "IVA retenido");
            List<String> columnasEncontradas = new ArrayList<>();

            for (Cell cell : headerRow) {
                columnasEncontradas.add(cell.getStringCellValue());
            }

            return columnasEsperadas.equals(columnasEncontradas.subList(0, columnasEsperadas.size()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarFormatoColumnas() {
        try (FileInputStream file = new FileInputStream(new File(FILE_PATH))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            // Recorre las columnas y verifica el formato
            for (Cell cell : headerRow) {
                CellType cellType = cell.getCellType();
                if (cellType != CellType.NUMERIC && cellType != CellType.STRING) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}