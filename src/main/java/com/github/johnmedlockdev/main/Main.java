package com.github.johnmedlockdev.main;

import java.io.IOException;

import com.github.johnmedlockdev.main.data.Data;

class Main {
    public static void main(String[] args) throws IOException {

        // parse input
        String method = args[0];
        String ticker = args[1].toUpperCase();
        double price = Double.parseDouble(args[2]);

        // Scaffolding
        String staticPath = "C:/Users/johnm/Desktop/bootcamp/project-0-John/src/main/java/com/github/johnmedlockdev/main/data/storage/";
        String fileFullName = staticPath + ticker + ".csv";

        // create instance
        Data asset = new Data(ticker, price, fileFullName);

        // control flow for based off user operation selection
        if (method.equals("input")) {
            asset.setPrice(price);
        }

        if (method.equals("predict")) {
            System.out.println(asset.getPrediction());
        }

        /// ------------------------------------------------

        // need to figure out how to make paths dynamic
        // File path = new File(fileFullName);

        // System.out.println("we got a file: " + path);
        // System.out.println("Does it exist " + path.exists());
        // System.out.println("What? " + path.isDirectory());

        // String contentsToWrite = "Hello World";

        // how to write a file
        // OutputStream outputStream = new FileOutputStream(path);
        // outputStream.write(contentsToWrite.getBytes());
        // outputStream.close();

        // how to read a file
        // BufferedReader reader = new BufferedReader(new InputStreamReader(new
        // FileInputStream(path)));
        // String firstLine = reader.readLine();
        // reader.close();
        // System.out.println("read a line:" + firstLine);

    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recomendation based off where the ticker is in the 200 day
// moving average.
