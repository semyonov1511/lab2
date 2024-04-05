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

    //1
    static double getAverage(double[][] mas, int j) {
        return StatUtils.mean(mas[j]);
    }

    //2
    static double getAverageGeom(double[][] mas, int j) {
        return StatUtils.geometricMean(mas[j]);

    }

    //3
    static double getStandartDeivation(double[][] mas, int j) {
        return Math.sqrt(StatUtils.variance(mas[j]));
    }

    //4
    static double getRange(double[][] mas, int j) {
        return StatUtils.max(mas[j]) - StatUtils.min(mas[j]);
    }

    //5
    //6
    static double getAmount(double[][] mas, int j) {
        return mas[j].length;
    }

    //7
    static double getVariationCoef(double[][] mas, int j) {
        return Math.sqrt(StatUtils.populationVariance(mas[j])) / StatUtils.mean(mas[j]);
    }

    //8
    //9
    static double getDispersion(double[][] mas, int j) {
        return StatUtils.variance(mas[j]);
    }

    //10
    static double getMin(double[][] mas, int j) {
        return StatUtils.min(mas[j]);
    }

    static double getMax(double[][] mas, int j) {
        return StatUtils.max(mas[j]);
    }
}
