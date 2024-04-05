package Interface;

import org.apache.commons.math3.stat.StatUtils;

public class Repository {

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
        return switch (i) {
            case 0 ->
                StatUtils.geometricMean(mas[j]);
            case 1 ->
                StatUtils.mean(mas[j]);
            case 2 ->
                Math.sqrt(StatUtils.variance(mas[j]));
            case 3 ->
                StatUtils.max(mas[j]) - StatUtils.min(mas[j]);
            case 4 ->
                0;
            case 5 ->
                mas[j].length;
            case 6 ->
                Math.sqrt(StatUtils.populationVariance(mas[j])) / StatUtils.mean(mas[j]);
            case 7 ->
                0;
            case 8 ->
                StatUtils.variance(mas[j]);
            case 9 ->
                StatUtils.max(mas[j]);
            case 10 ->
                StatUtils.min(mas[j]);
            default ->
                StatUtils.geometricMean(mas[j]);
        };
    }
}
