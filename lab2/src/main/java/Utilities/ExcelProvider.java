package Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.xssf.usermodel.*;

public class ExcelProvider {

    public double[][] readExcel(File file, String which, boolean a) throws FileNotFoundException, IOException, InvalidFormatException {
        ArrayList<ArrayList<Double>> list = new ArrayList<>();
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (NotOfficeXmlFileException e) {
            System.out.println("This is not a valid .xlsx file");
            return null;
        }
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
        return mas;
    }

    public void writeExcel(double[][] mas) throws FileNotFoundException, IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Полученные значения");
        String[] StatNames = {"Среднее геометрическое", "Среднее арифметическое", "Оценка стандартного отклонения", "Размах", "Коэффициент ковариации с последующей выборкой", "Количество элементов",
            "Нижняя граница доверительного интервала", "Верхняя граница доверительного интервала", "Оценка дисперсии", "Максимум", "Минимум"};
        for (int i = 0; i < 11; i++) {
            Row row = sheet.createRow(i);
            int cellNumber = 0;
            for (int j = 0; j < Repository.getInstance().getMas().length; j++) {
                Cell name = row.createCell(cellNumber);
                name.setCellValue(StatNames[i] + " для " + (j + 1) + "-й выборки: ");
                Cell x = row.createCell(cellNumber + 1);
                x.setCellValue((Repository.getInstance().getParameters())[i][j]);
                cellNumber += 2;
            }
            sheet.autoSizeColumn(i);
        }
        XSSFSheet sheet2 = book.createSheet("Матрица ковариации");
        Row row = sheet2.createRow(0);
        for (int j = 0; j < Repository.getInstance().getMas().length; j++) {
            Cell name = row.createCell(j + 1);
            name.setCellValue("Выборка " + (j + 1));
        }
        for (int j = 1; j <= Repository.getInstance().getMas().length; j++) {
            row = sheet2.createRow(j);
            Cell name = row.createCell(0);
            name.setCellValue("Выборка " + j);
            for (int i = 1; i <= Repository.getInstance().getMas().length; i++) {
                name = row.createCell(i);
                name.setCellValue(Repository.getInstance().getCov(i - 1, j - 1));
            }
            sheet2.autoSizeColumn(j - 1);
        }
        try {
            book.write(new FileOutputStream("краб.xlsx"));
            System.out.println("Parameters were exported successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Close file firstsly");
        }
        book.close();
    }
}
