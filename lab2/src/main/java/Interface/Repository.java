package Interface;

import org.apache.commons.math3.stat.correlation.Covariance;

public class Repository {

    Covariance covariance = new Covariance();
    private static Repository INSTANCE;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public double[][] mas;
    public double[][] Parameters = new double[11][3];

    public double[][] getMas() {
        return mas;
    }

    public void setMas(double[][] a) {
        mas = a;
    }

    public double[][] getParameters() {
        return Parameters;
    }
    
    public void setParameters(){
        for (int i=0; i<11; i++){
            for (int j=0; j<3; j++){
                Parameters[i][j] = Decider(i,j);
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
                return Calculator.getCovariaton(mas,j);
            }
            case 5 -> {
                return Calculator.getAmount(mas,j);
            }
            case 6 -> {
                return Calculator.getVariationCoef(mas,j);
            }
            case 7 -> {
                return 0;
            }
            case 8 -> {
                return Calculator.getDispersion(mas,j);
            }
            case 9 -> {
                return Calculator.getMax(mas,j);
            }
            case 10 -> {
                return Calculator.getMin(mas,j);
            }
            default -> {
                return 0;
            }
        }
    }

    
}
