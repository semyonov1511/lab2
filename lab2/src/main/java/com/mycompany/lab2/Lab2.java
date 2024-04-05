package com.mycompany.lab2;

import Interface.*;
import java.io.IOException;
import org.apache.commons.math3.stat.StatUtils;

public class Lab2 {

    public static void main(String[] args) throws IOException {
        double[] a = {0.2, 1, 3};
        System.out.println(StatUtils.	geometricMean(a));
        (new GUI()).setVisible(true);
    }
}
