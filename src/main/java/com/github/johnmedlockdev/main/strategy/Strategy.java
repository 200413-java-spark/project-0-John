package com.github.johnmedlockdev.main.strategy;

import com.github.johnmedlockdev.main.data.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Strategy implements StrategyTemplate {

    private String fileFullName;

    //    prediction logic
    private BufferedReader br = null;
    private String line = "";
    private int total;
    private int count;
    private double sum;
    //    prediction logic

    protected Strategy(Data data){
        this.fileFullName = data.getFileFullName();
    }

    @Override
    public double[] processData() throws IOException {
                // code reads csv
            // gets number of lines in file
            br = new BufferedReader(new FileReader(fileFullName));
            while ((line = br.readLine()) != null) {
                total++;
            }

            // defines len of range
            String[] strRange = new String[total];

            // creates array of string values and parses extra "
            br = new BufferedReader(new FileReader(fileFullName));
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
    }

    @Override
    public void advise() {
        System.out.println("You need to override this method!");
    }
}
