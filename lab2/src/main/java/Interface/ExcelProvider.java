package Interface;

import java.io.*;
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
        XSSFSheet sheet = book.createSheet("Полученные значения");
        String[] names = {"Среднее геометрическое", "Среднее арифметическое", "Оценка стандартного отклонения", "Размах", "Коэффициент ковариации с последующей выборкой", "Количество элементов",
            "Коэффициент варации", "Доверительный интервал", "Оценка дисперсии", "Максимум", "Минимум"};
        for (int i = 0; i < 11; i++) {
            Row row = sheet.createRow(i);
            int cellNumber = 0;
            for (int j = 0; j < 3; j++) {
                Cell name = row.createCell(cellNumber);
                name.setCellValue(names[i] + " для " + (j+1) + "-й выборки: ");
                Cell x = row.createCell(cellNumber+1);
                x.setCellValue(Repository.getInstance().Decider(i, j));
                cellNumber += 2;
            }
            sheet.autoSizeColumn(i);
        }
        book.write(new FileOutputStream("краб.xlsx"));
        book.close();
    }

}
