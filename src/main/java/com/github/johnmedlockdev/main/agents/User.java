package com.github.johnmedlockdev.main.agents;

abstract class User {
    protected final String symbol;
    protected double price;

    public User(String symbol, String price) {
        this.symbol = symbol.toUpperCase();
        this.price = Double.parseDouble(price);
    }

    public User(String symbol) {
        this.symbol = symbol.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }
}
