package Interface;

public class Repository {

    public double[][] mas;

    public double[][] getMas() {
        return mas;
    }

    public void setMas(double[][] a) {
        mas = a;
    }

    static double getAverage(double[][] mas, int j) {
        double avg = 0;
        for (int i = 0; i < mas[j].length; i++) {
            avg += mas[j][i];
            System.out.println("mudak " + avg);
        }
        System.out.println("              " + avg / mas[j].length);
        return avg / mas[j].length;
    }

    static double getDispersion(double[][] mas, int j) {
        double sum = 0;
        double avg = getAverage(mas, j);
        for (int i = 0; i < mas[1].length; i++) {
            sum += Math.pow((mas[j][i] - avg), 2);
        }
        return sum / (mas[1].length);
    }
}
