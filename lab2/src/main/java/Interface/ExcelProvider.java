package Interface;

import java.io.*;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelProvider {

    public double[][] readExcel() throws FileNotFoundException, IOException {
        double[][] mas = new double[3][100];
        FileInputStream file = new FileInputStream(new File("ДЗ4.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int i = -1;
        int j = 0;
        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();
            j = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC -> {
                        System.out.println("muda" + i);
                        mas[j][i] = (double) cell.getNumericCellValue();
                        //System.out.println(mas[0][i]);
                    }
                }
                j=j+1;
            }
            i = i + 1;
            System.out.println("");
        }
        file.close();
        return mas;
    }
}
