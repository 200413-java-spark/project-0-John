package com.github.johnmedlockdev.main.datastructures;

import java.io.*;
import java.util.Random;

public class Ticker extends User {
    private BufferedWriter bw;
    private final FileStructure symbolFile;

    public Ticker(String symbol, String price) {
        super(symbol,price);
        symbolFile = new FileStructure(symbol);
    }

    public void createFile() {
        try {
            if (!symbolFile.getPath().exists()) {
                OutputStream outputStream = new FileOutputStream(symbolFile.getPath());
            }
            createInput();
        } catch (IOException e) {
            System.out.println("Completed!");
        }
    }

    public void createInput() {
        try {
            String priceInput = Double.toString(this.price);
            String newUserInput = super.getSymbol() + "," + priceInput;

            bw = new BufferedWriter(
                    new FileWriter(symbolFile.getAbsolutePathStr(), true)
            );
            bw.write(newUserInput);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Completed!");
        }
    }

    public void generate() {
        try {

            if (!symbolFile.getPath().exists()) {
                OutputStream outputStream = new FileOutputStream(symbolFile.getPath());
            }

            for (int i = 0; i < 200; i++) {
                Random r = new Random(); // creating Random object
                double randomValue = 1 + (10 - 1) * r.nextDouble();
                String ranStr = String.format("%.2f", randomValue);
                String ticker = "SPY";
                String genInput = ticker + "," + ranStr;
                bw = new BufferedWriter(
                        new FileWriter(symbolFile.getAbsolutePathStr(), true)
                );
                bw.write(genInput);
                bw.newLine();
                bw.close();
            }

        } catch (IOException e) {
            System.out.println("Completed!");
        }

    }
}

