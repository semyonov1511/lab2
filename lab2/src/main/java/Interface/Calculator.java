package Interface;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

public class Calculator {

    static Covariance covariance = new Covariance();

    //1
    static double getAverageGeom(double[][] mas, int j) {
        return StatUtils.geometricMean(mas[j]);
    }

    //2
    static double getAverage(double[][] mas, int j) {
        return StatUtils.mean(mas[j]);
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
    static double getCovariaton(double[][] mas, int j) {
        if (j != 2) {
            return covariance.covariance(mas[j], mas[j + 1]);
        } else {
            return covariance.covariance(mas[j], mas[j - 2]);
        }

    }

    //6
    static double getAmount(double[][] mas, int j) {
        return mas[j].length;
    }

    //7
    static double getVariationCoef(double[][] mas, int j) {
        return Math.sqrt(StatUtils.populationVariance(mas[j])) / StatUtils.mean(mas[j]);
    }

    //8.1
    static double getIntervalLower(double[][] mas, int j) {
        return StatUtils.mean(mas[j]) - 1.65 * Math.sqrt(Math.abs(StatUtils.variance(mas[j])) / mas[j].length);
    }

    //8.2
    static double getIntervalUpper(double[][] mas, int j) {
        return StatUtils.mean(mas[j]) + 1.65 * Math.sqrt(Math.abs(StatUtils.variance(mas[j])) / mas[j].length);
    }

    //9
    static double getDispersion(double[][] mas, int j) {
        return StatUtils.variance(mas[j]);
    }

    //10.1
    static double getMax(double[][] mas, int j) {
        return StatUtils.max(mas[j]);
    }

    //10.2
    static double getMin(double[][] mas, int j) {
        return StatUtils.min(mas[j]);
    }

}
