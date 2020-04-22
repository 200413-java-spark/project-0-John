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

    private BufferedWriter writer;
    private BufferedReader reader;
    private Strategy strategy;


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
    public void getPrediction() {

        try {
            // get user input to display which strategy they want.
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Which strategy would you like to use?");
            String nameOfStrategy = reader.readLine();

            switch (nameOfStrategy) {
                case "test":
                    strategy = new test(this);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + nameOfStrategy);
            }

//        Todo create more strategies

            strategy.advise();

        } catch (IOException e) {
            System.out.println("Completed!");
        }

    }


    public void createFile() {
        try {
            if (!path.exists()) {
                OutputStream outputStream = new FileOutputStream(this.path);
            }
            createInput();
        } catch(IOException e) {
            System.out.println("Completed!");
        }
    }

    public void createInput() {
        try {
            String priceInput = Double.toString(this.price);

            writer = new BufferedWriter(
                    new FileWriter(this.fileFullName, true)
            );
            writer.write(priceInput);
            writer.newLine();
            writer.close();
        } catch(IOException e) {
            System.out.println("Completed!");
        }
    }

    public void generate() {
        try {

            if (!path.exists()) {
                OutputStream outputStream = new FileOutputStream(this.path);
            }

            for (int i = 0; i < 200; i++) {
                Random r = new Random(); // creating Random object
                double randomValue = 1 + (10 - 1) * r.nextDouble();
                String ranStr = String.format("%.2f", randomValue);

                writer = new BufferedWriter(
                        new FileWriter(fileFullName, true)
                );
                writer.write(ranStr);
                writer.newLine();
                writer.close();
            }

        } catch(IOException e) {
            System.out.println("Completed!");
        }

    }

}