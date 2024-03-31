package com.mycompany.lab2;

import Interface.*;
import java.io.IOException;

public class Lab2 {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        ExcelProvider provider = new ExcelProvider();
        provider.readExcel();
    }
}
