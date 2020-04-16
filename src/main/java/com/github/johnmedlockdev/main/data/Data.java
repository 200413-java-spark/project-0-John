package com.github.johnmedlockdev.main.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Data {
    // instance vars
    private String ticker;
    private double price;
    private String fileFullName;

    ///// code reads csv
    BufferedReader br = null;
    String line = "";

    int total;
    int count;
    double sum;

    // constructors
    public Data(String ticker, double price, String fileFullName) {
        this.ticker = ticker;
        this.price = price;
        this.fileFullName = fileFullName;

    }

    // instance methods

    // getters
    public String getTicker() {
        return this.ticker;
    }

    public double getPrice() {
        return this.price;
    }

    // =======
    public String getPrediction() {

        // code reads csv
        try {

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

                strRange[count] = line.replace("\"", "");
                count++;

            }

            // parses str value to int
            int[] intRange = new int[strRange.length];
            for (int i = 0; i < strRange.length; i++) {
                intRange[i] = Integer.parseInt(strRange[i]);
            }
            System.out.println(Arrays.toString(intRange));
            sum = 0;
            for (int i = 0; i < intRange.length; i++) {
                sum += intRange[i];
            }

            double average = sum / total;

            if (average > intRange[count - 1]) {
                return "You're in a bull market, you should Buy.";
            } else {
                return "You're in a bear market, you should not buy";
            }

            // error handling for buffers
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    // =======

    // setters
    public void setPrice(double price) {
        this.price = price;
    }

}

// create method to store data on json or csv
// create method to make calculate 200 day moving avg
// create method to decide wether to make trade or not to make trades