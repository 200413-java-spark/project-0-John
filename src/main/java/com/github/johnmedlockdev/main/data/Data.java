package com.github.johnmedlockdev.main.data;

import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;
import com.github.johnmedlockdev.main.strategy.Strategy;
import com.github.johnmedlockdev.main.strategy.strategies.test;

import java.io.*;
import java.util.Random;

public class Data {
    //instance variables
    private final String ticker;
    private final String method;
    private final String fileFullName;
    private final File path;
    private double price;
    //Todo
    private String strategy;
    //Todo


    // constructors
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

    public String getFileFullName() {
        return this.fileFullName;
    }

    public String getMethod() {
        return this.method;
    }


    //  methods
    public void getPrediction() throws IOException {
        Strategy strategy;

// get user input to display which strategy they want.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which strategy would you like to use?");
        String nameOfStrategy = reader.readLine();


        switch (nameOfStrategy) {
            case "test":
                strategy = new test(this);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + nameOfStrategy);
        }

//        Todo create function factory

        strategy.advise();

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

        OutputStream outputStream = new FileOutputStream(this.path);
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
// fix first input blank bug generate
// create more test replace test