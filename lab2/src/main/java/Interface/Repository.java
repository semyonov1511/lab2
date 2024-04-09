package Interface;

import org.apache.commons.math3.stat.StatUtils;
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
                
            }
        }
    }
    public double Decider(int i, int j) {
        switch (i) {
            case 0 -> {
                return getAverageGeom(mas, j);
            }
            case 1 -> {
                return getAverage(mas, j);
            }
            case 2 -> {
                return getStandartDeivation(mas, j);
            }
            case 3 -> {
                return getRange(mas, j);
            }
            case 4 -> {
                if (j != 2) {
                    return covariance.covariance(mas[j], mas[j + 1]);
                } else {
                    return covariance.covariance(mas[j], mas[j - 2]);
                }
            }
            case 5 -> {
                return mas[j].length;
            }
            case 6 -> {
                return Math.sqrt(StatUtils.populationVariance(mas[j])) / StatUtils.mean(mas[j]);
            }
            case 7 -> {
                return 0;
            }
            case 8 -> {
                return StatUtils.variance(mas[j]);
            }
            case 9 -> {
                return StatUtils.max(mas[j]);
            }
            case 10 -> {
                return StatUtils.min(mas[j]);
            }
            default -> {
                return StatUtils.geometricMean(mas[j]);
            }
        }
    }

    
}
