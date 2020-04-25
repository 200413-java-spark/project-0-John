package com.github.johnmedlockdev.main.strategy.interfaces;

import com.github.johnmedlockdev.main.datastructures.FileStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;

public class Strategy implements StrategyTemplate {

    private FileStructure fileSymbol;
    private String symbol;

    private int total;
    private int count;
    private double sum;
    private BufferedWriter writer;


    public Strategy(String symbol, String strategy) {
        this.symbol = symbol;
        fileSymbol = new FileStructure(symbol);
    }

    @Override
    public double[] processData() {

        try {// code reads csv
            // gets number of lines in file
            BufferedReader br = new BufferedReader(new FileReader(fileSymbol.getAbsolutePathStr()));
            String line = "";
            while ((line = br.readLine()) != null) {
                total++;
            }

            // defines len of range
            String[] strRange = new String[total];

            // creates array of string values and parses extra "
            br = new BufferedReader(new FileReader(fileSymbol.getAbsolutePathStr()));
            while ((line = br.readLine()) != null) {
                strRange[count] = line;
                count++;
            }
//            Parses String array to double array.
            double[] doubleValues;

            doubleValues = Arrays.stream(strRange)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            return doubleValues;
        } catch (Exception e) {
            System.out.println("exception handled");
            return null;
        }
    }


    @Override
    public void advise() {
        System.out.println("You need to override this method!");
    }

    //  methods
    public void getPrediction() {
//        try {
//            // get user input to display which strategy they want.
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Which strategy would you like to use?");
//            String nameOfStrategy = reader.readLine();
//
//            Strategy strategy;
//            switch (nameOfStrategy) {
//                case "test":
//                    strategy = new test(this);
//                    break;
//                case "test1":
//                    strategy = new test1(this);
//                    break;
//                case "test2":
//                    strategy = new test2(this);
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + nameOfStrategy);
//            }
//
//            strategy.advise();
//
//        } catch (IOException e) {
//            System.out.println("Completed!");
//        }

    }
}