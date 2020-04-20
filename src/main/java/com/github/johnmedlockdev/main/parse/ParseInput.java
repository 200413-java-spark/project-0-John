package com.github.johnmedlockdev.main.parse;

public class ParseInput {

    protected String method;
    protected String ticker;
    protected double price;


    public ParseInput(String ...args) {

        // parse input
         this.method= args[0];
         this.ticker = args[1].toUpperCase();
         this.price = Double.parseDouble(args[2]);
    }

     public String getMethod(){
        return this.method;
    }

    public String getTicker(){
        return this.ticker;
    }

    public double getPrice(){
        return this.price;
    }
}
