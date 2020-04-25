package com.github.johnmedlockdev.main.strategy;

import com.github.johnmedlockdev.main.agents.FileStructure;
import com.github.johnmedlockdev.main.strategy.interfaces.StrategyInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Strategy implements StrategyInterface {

    private final FileStructure fileSymbol;

    public Strategy(String symbol) {
        fileSymbol = new FileStructure(symbol);
    }

    @Override
    public ArrayList<Double> processData() {

        try {

            ArrayList<Double> valuesArray = new ArrayList<Double>();

            BufferedReader br = new BufferedReader(new FileReader(fileSymbol.getAbsolutePathStr()));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                valuesArray.add(Double.parseDouble(values[1]));
            }

            return valuesArray;

        } catch (Exception e) {
            System.out.println("exception handled");
            return null;
        }
    }

    @Override
    public void advise() {
        System.out.println("You need to override this method!");
    }

}