package com.github.johnmedlockdev.main.agents;

import java.io.*;

public class Ticker extends User {
    private final FileStructure fileSymbol;

    public Ticker(String symbol, String price) {
        super(symbol, price);
        fileSymbol = new FileStructure(symbol);
    }

    public void createFile() {
        try {
            if (!fileSymbol.getPath().exists()) {
                OutputStream outputStream = new FileOutputStream(fileSymbol.getPath());
            }
            createInput();
        } catch (IOException e) {
            System.out.println("createFile error!");
        }
    }

    public void createInput() {
        try {
            String priceInput = Double.toString(this.price);
            String newUserInput = super.getSymbol() + "," + priceInput;

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(fileSymbol.getAbsolutePathStr(), true)
            );
            bw.write(newUserInput);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("createInput error!");
        }
    }


}

