package com.github.johnmedlockdev.main.parse;

public class ParseInput {

    private String mode = "";
    private String method;
    private String ticker;
    private double price;

    public ParseInput(String... args) {
        ParseLogic(args);
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

    public String getMode() {
        return mode;
    }

    private void ParseLogic(String... args) {
        if (args.length == 1) {
            this.mode = args[0]; // batch
        } else {
            if (args.length == 2) { // manual generate or predict
                this.method = args[0];
                this.ticker = args[1].toUpperCase();
            }
            if (args.length == 3) { // manual
                this.method = args[0];
                this.ticker = args[1].toUpperCase();
                this.price = Double.parseDouble(args[2]);
            }
        }
    }
}
// manual batch