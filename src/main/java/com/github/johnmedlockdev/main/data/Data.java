package com.github.johnmedlockdev.main.data;

import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;
import com.github.johnmedlockdev.main.strategy.Strategy;
import com.github.johnmedlockdev.main.strategy.strategies.test;

import java.io.*;
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

    public String getFileFullName(){
        return this.fileFullName;
    };

    // setters
    public void setPrice(double price) {
        this.price = price;
    }

    public String getMethod() {
        return this.method;
    }


    //    methods

    public void getPrediction() throws IOException {
        Strategy strat = new test(this);


//        Todo create function factory



        strat.advise();

    }

//todo make the best output combination

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
//TODO:
// deal with io exceptions with try catch blocks
// Optimize file read right
// abstract strategy template