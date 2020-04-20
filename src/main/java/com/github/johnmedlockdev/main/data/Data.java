package com.github.johnmedlockdev.main.data;

import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Data {

    private String ticker;
    private double price;
    private String method;
    private String fileFullName;
    private File path;

    //    prediction logic
    private BufferedReader br = null;
    private String line = "";
    private int total;
    private int count;
    private double sum;
    //    prediction logic


    public Data(ParseInput userInput, FileInfo fileInfo) {
        this.ticker = userInput.getTicker();
        this.price = userInput.getPrice();
        this.method = userInput.getMethod();
        this.fileFullName = fileInfo.getFileFullName();
        this.path = fileInfo.getPath();
    }


    // getters
    public String getTicker() {
        return this.ticker;
    }

    public double getPrice() {
        return this.price;
    }

    // setters
    public void setPrice(double price) {
        this.price = price;
    }

    public String getMethod() {
        return this.method;
    }

    //    methods

    public void getPrediction() {

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

                strRange[count] = line;
                count++;

            }
//            Parses String array to double array.
            double[] doubleValues = Arrays.stream(strRange)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            sum = 0;
            for (double doubleValue : doubleValues) {
                sum += doubleValue;
            }

//            where the moving average is.
            double average = sum / total;

//
            if (average > doubleValues[count - 1]) {
                System.out.println("You're in a bull market, you should Buy.");
            } else {
                System.out.println("You're in a bear market, you should not buy");
            }

            // error handling for buffers
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


    }

    public void createFile() throws IOException {

        OutputStream outputStream = new FileOutputStream(this.path);
        String contentsToWrite = Double.toString(this.price);
        outputStream.write(contentsToWrite.getBytes());
        outputStream.close();
        System.out.println("New file created for " + this.ticker);

    }

    public void createInput() throws IOException {

        String contentsToWrite = Double.toString(this.price);
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(this.fileFullName, true)
        );
        writer.newLine();   //Add new line
        writer.write(contentsToWrite);
        writer.close();

        System.out.println("The data file exist");
    }

    public void generate() throws IOException {

        String contentsToWrite = Double.toString(price);
        for (int i = 0; i < 200; i++) {
            Random r = new Random(); // creating Random object
            double randomValue = 1 + (10 - 1) * r.nextDouble();
            String ranStr = String.format("%.2f", randomValue);

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileFullName, true)
            );
            writer.newLine();   //Add new line
            writer.write(ranStr);
            writer.close();
        }
    }
}
