package Interface;

import java.util.ArrayList;

public class Repository {
    
    private static Repository INSTANCE;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public double[][] mas;
    public double[][] Parameters;

    public double[][] getMas() {
        return mas;
    }

    public void setMas(double[][] a) {
        mas = a;
    }

    public double[][] getParameters() {
        return Parameters;
    }

    public void setParameters() {
        if (mas == null) {
            System.out.println("Import data firstly");
        } else {
            Parameters = new double[12][getMas().length];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < getMas().length; j++) {
                    Parameters[i][j] = Decider(i, j);
                }
            }
        }
    }

    public double Decider(int i, int j) {
        switch (i) {
            case 0 -> {
                return Calculator.getAverageGeom(mas, j);
            }
            case 1 -> {
                return Calculator.getAverage(mas, j);
            }
            case 2 -> {
                return Calculator.getStandartDeivation(mas, j);
            }
            case 3 -> {
                return Calculator.getRange(mas, j);
            }
            case 4 -> {
                return Calculator.getCovariaton(mas, j);
            }
            case 5 -> {
                return Calculator.getAmount(mas, j);
            }
            case 6 -> {
                return Calculator.getVariationCoef(mas, j);
            }
            case 7 -> {
                return Calculator.getIntervalLower(mas, j);
            }
            case 8 -> {
                return Calculator.getIntervalUpper(mas, j);
            }
            case 9 -> {
                return Calculator.getDispersion(mas, j);
            }
            case 10 -> {
                return Calculator.getMax(mas, j);
            }
            case 11 -> {
                return Calculator.getMin(mas, j);
            }
            default -> {
                return 0;
            }
        }
    }

}
