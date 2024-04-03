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
        XSSFSheet sheet = workbook.getSheetAt(8);
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
        Cell name1 = row.createCell(0);
        name1.setCellValue("Dispersion in X column: ");
        
        Cell x = row.createCell(1);
        x.setCellValue(Repository.getDispersion(mas, 0));
        
        Cell name2 = row.createCell(2);
        name2.setCellValue("Dispersion in Y column: ");
        Cell y = row.createCell(3);
        y.setCellValue(Repository.getDispersion(mas, 1));
        
        Cell name3 = row.createCell(4);
        name3.setCellValue("Dispersion in Z column: ");
        Cell z = row.createCell(5);
        z.setCellValue(Repository.getDispersion(mas, 2));
        
        sheet.autoSizeColumn(6);
        book.write(new FileOutputStream("краб.xlsx"));
        book.close();
    }

}
