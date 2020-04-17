package com.github.johnmedlockdev.main;

import java.io.*;
import java.util.Random;

import com.github.johnmedlockdev.main.data.Data;

class Main {
    public static void main(String[] args) throws IOException {

        // parse input
        String method = args[0];
        String ticker = args[1].toUpperCase();
        double price = Double.parseDouble(args[2]);


        // Scaffolding
        String staticPath = "C:\\Users\\johnm\\IdeaProjects\\project-0-John\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\storage\\";
        String fileFullName = staticPath + ticker + ".csv";
        File path = new File(fileFullName);

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

        if (path.exists() && method.equals("input")) {
            String contentsToWrite = Double.toString(price);
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileFullName, true)
            );
            writer.newLine();   //Add new line
            writer.write(contentsToWrite);
            writer.close();

            System.out.println("The data file exist");
        } else if (!path.exists() && method.equals("input")) {
            OutputStream outputStream = new FileOutputStream(path);
            String contentsToWrite = Double.toString(price);
            outputStream.write(contentsToWrite.getBytes());
            outputStream.close();
            System.out.println("New file created for " + ticker);
        }


        if (path.exists() && method.equals("generate")) {
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

        // how to write a file

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
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
