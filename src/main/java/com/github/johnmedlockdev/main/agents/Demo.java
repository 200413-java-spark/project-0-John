package com.github.johnmedlockdev.main.agents;

import java.io.*;
import java.util.Random;

public class Demo {
    private final FileStructure fileSymbol;
    private final String symbol;
    BufferedWriter bw;

    public Demo(String symbol) {
        this.symbol = symbol;
        fileSymbol = new FileStructure(symbol);
    }

    public void generate() {
        try {

            if (!fileSymbol.getPath().exists()) {
                OutputStream outputStream = new FileOutputStream(fileSymbol.getPath());
            }

            for (int i = 0; i < 200; i++) {
                Random r = new Random();
                double randomValue = 1 + (10 - 1) * r.nextDouble();
                String ranStr = String.format("%.2f", randomValue);
                String genInput = symbol + "," + ranStr;
                bw = new BufferedWriter(
                        new FileWriter(fileSymbol.getAbsolutePathStr(), true)
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
