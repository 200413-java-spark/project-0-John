package com.github.johnmedlockdev.main.data;

public class Data {
    // instance vars
    private String ticker;
    private double price;

    // constructors
    public Data(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
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