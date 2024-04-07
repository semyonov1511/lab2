package Interface;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

public class Repository {

    Covariance x = new Covariance();
    private static Repository INSTANCE;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }
    public double[][] mas;

    public double[][] getMas() {
        return mas;
    }

    public void setMas(double[][] a) {
        mas = a;
    }

    public double Decider(int i, int j) {
        switch (i) {
            case 0 -> {
                return StatUtils.geometricMean(mas[j]);
            }
            case 1 -> {
                return StatUtils.mean(mas[j]);
            }
            case 2 -> {
                return Math.sqrt(StatUtils.variance(mas[j]));
            }
            case 3 -> {
                return StatUtils.max(mas[j]) - StatUtils.min(mas[j]);
            }
            case 4 -> {
                if (j != 2) {
                    return x.covariance(mas[j], mas[j + 1]);
                } else {
                    return x.covariance(mas[j], mas[j - 2]);
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
