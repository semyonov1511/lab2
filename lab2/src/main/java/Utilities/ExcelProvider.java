package Utilities;

import Utilities.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.xssf.usermodel.*;

public class ExcelProvider {

    public double[][] readExcel(String which, boolean a) throws FileNotFoundException, IOException {
        ArrayList<ArrayList<Double>> list = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File("ДЗ4.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet;
        if (a) {
            try {
                sheet = workbook.getSheetAt(Integer.parseInt(which) - 1);
            } catch (NumberFormatException e) {
                sheet = workbook.getSheetAt(Integer.parseInt("0"));
                System.out.println("Число введено некорректно, данные считаются для первого листа");
            }
        } else {
            sheet = workbook.getSheet(which);
        }
        ArrayList<Double> sample = new ArrayList<>();
        if (sheet == null) {
            sheet = workbook.getSheetAt(Integer.parseInt("0"));
            System.out.println("Число введено некорректно, данные считаются для первого листа");
        }
        for (Row row : sheet) {
            sample = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC -> {
                        sample.add((double) cell.getNumericCellValue());
                    }
                }
            }
            if (!sample.isEmpty()) {
                list.add(sample);
            }
        }
        double[][] mas = new double[sample.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < sample.size(); j++) {
                mas[j][i] = list.get(i).get(j);
            }
        }
        file.close();
        return mas;
    }

    public void writeExcel(double[][] mas) throws FileNotFoundException, IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Полученные значения");
        String[] names = {"Среднее геометрическое", "Среднее арифметическое", "Оценка стандартного отклонения", "Размах", "Коэффициент ковариации с последующей выборкой", "Количество элементов",
            "Коэффициент варации", "Нижняя граница доверительного интервала", "Верхняя граница доверительного интервала", "Оценка дисперсии", "Максимум", "Минимум"};
        for (int i = 0; i < 12; i++) {
            Row row = sheet.createRow(i);
            int cellNumber = 0;
            for (int j = 0; j < Repository.getInstance().getMas().length; j++) {
                Cell name = row.createCell(cellNumber);
                name.setCellValue(names[i] + " для " + (j + 1) + "-й выборки: ");
                Cell x = row.createCell(cellNumber + 1);
                x.setCellValue((Repository.getInstance().getParameters())[i][j]);
                cellNumber += 2;
            }
            sheet.autoSizeColumn(i);
        }
        book.write(new FileOutputStream("краб.xlsx"));
        book.close();
    }

}
