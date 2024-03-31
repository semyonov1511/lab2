package Interface;

import java.io.*;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelProvider {

    public void readExcel() throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(new File("ДЗ4.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC -> System.out.print(cell.getNumericCellValue() + "t");
                    case STRING -> System.out.print(cell.getStringCellValue() + "t");
                }
            }
            System.out.println("");
        }
        file.close();
    }
}
