package Interface;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.xssf.usermodel.*;

public class ExcelProvider {

    public double[][] readExcel() throws FileNotFoundException, IOException {
        double[][] mas = new double[3][100];
        FileInputStream file = new FileInputStream(new File("ДЗ4.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int i = -1;
        int j;
        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();
            j = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC -> {
                        mas[j][i] = (double) cell.getNumericCellValue();
                    }
                }
                j = j + 1;
            }
            i = i + 1;
        }
        file.close();
        return mas;
    }

    public void writeExcel(double[][] mas) throws FileNotFoundException, IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Лист 1");
        Row row = sheet.createRow(0);
        Cell name = row.createCell(0);
        name.setCellValue("John");
        Cell birthdate = row.createCell(1);
        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);
        birthdate.setCellValue(new Date(110, 10, 10));
        sheet.autoSizeColumn(1);
        book.write(new FileOutputStream("краб.xlsx"));
        book.close();
    }

}
