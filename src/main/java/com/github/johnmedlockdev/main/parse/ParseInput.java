package com.github.johnmedlockdev.main.parse;

public class ParseInput {

    private String method;
    private String ticker;
    private double price;


    public ParseInput(String... args) {
        if (args.length == 2) {
            this.method = args[0];
            this.ticker = args[1].toUpperCase();
        }

        if (args.length == 3) {
            System.out.println(args.length); // 3
            this.method = args[0];
            this.ticker = args[1].toUpperCase();
            this.price = Double.parseDouble(args[2]);
        }

    }


    public String getMethod() {
        return this.method;
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getPrice() {
        return this.price;
    }
}
