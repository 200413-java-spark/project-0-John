package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;

class Main {
    public static void main(String[] args) {

        // parse input
        String method = args[0];
        String ticker = args[1];
        double price = Double.parseDouble(args[2]);

        // create instance
        Data asset = new Data(ticker, price);

        if (method.equals("input")) {
            asset.setPrice(price);
        }

        if (method.equals("predict")) {
            System.out.println(asset.getPrediction());
        }
    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recomendation based off where the ticker is in the 200 day moving average.
