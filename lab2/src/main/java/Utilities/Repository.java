package Utilities;

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
public double getCov(int i, int j) {
        return Calculator.getCovariaton(mas, i, j);
    }

    public void setParameters() {
        if (mas == null) {
            System.out.println("Import data firstly");
        } else {
            Parameters = new double[11][getMas().length];
            for (int i = 0; i < 11; i++) {
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
                return Calculator.getAmount(mas, j);
            }
            case 5 -> {
                return Calculator.getVariationCoef(mas, j);
            }
            case 6 -> {
                return Calculator.getIntervalLower(mas, j);
            }
            case 7 -> {
                return Calculator.getIntervalUpper(mas, j);
            }
            case 8 -> {
                return Calculator.getDispersion(mas, j);
            }
            case 9 -> {
                return Calculator.getMax(mas, j);
            }
            case 10 -> {
                return Calculator.getMin(mas, j);
            }
            default -> {
                return 0;
            }
        }
    }

}
