package com.github.johnmedlockdev.main.agents;

import java.io.*;
import java.util.Random;

public class Demo {
    private final String numberOfInputs;
    private final FileStructure fileSymbol;
    private final String symbol;

    public Demo(String symbol, String numberOfInputs) {
        this.numberOfInputs = numberOfInputs;
        this.symbol = symbol;
        fileSymbol = new FileStructure(symbol);
    }

    public void generate() {
        try {
            if (!fileSymbol.getPath().exists()) {
                OutputStream outputStream = new FileOutputStream(fileSymbol.getPath());
            }

            for (int i = 0; i < Math.floor(Double.parseDouble(numberOfInputs)); i++) {
                Random r = new Random();
                double randomValue = 1 + (10 - 1) * r.nextDouble();
                String ranStr = String.format("%.2f", randomValue);
                String genInput = symbol.toUpperCase() + "," + ranStr;
                BufferedWriter bw = new BufferedWriter(
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

    public void tGenerate() {
        String[] values = symbol.split(",");
        for (String value : values) {
            new Thread(new ThreadWorker(value, numberOfInputs)).start();
        }

    }
}
