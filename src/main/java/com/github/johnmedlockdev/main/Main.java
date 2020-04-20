package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;

import java.io.*;
import java.util.Random;

class Main {
    public static void main(String ...args) throws IOException {

        ParseInput userInput = new ParseInput(args);
        FileInfo fileInfo = new FileInfo(userInput);

        // create instance
        Data asset = new Data(userInput.getTicker(), userInput.getPrice(), fileInfo.getFileFullName());

        // control flow for based off user operation selection
        if (userInput.getMethod().equals("input")) {
            asset.setPrice(userInput.getPrice());
        }

        if (userInput.getMethod().equals("predict")) {
            System.out.println(asset.getPrediction());
        }

        /// ------------------------------------------------

        // need to figure out how to make paths dynamic

        if (fileInfo.getPath().exists() && userInput.getMethod().equals("input")) {
            String contentsToWrite = Double.toString(userInput.getPrice());
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileInfo.getFileFullName(), true)
            );
            writer.newLine();   //Add new line
            writer.write(contentsToWrite);
            writer.close();

            System.out.println("The data file exist");
        } else if (!fileInfo.getPath().exists() && userInput.getMethod().equals("input")) {
            OutputStream outputStream = new FileOutputStream(fileInfo.getPath());
            String contentsToWrite = Double.toString(userInput.getPrice());
            outputStream.write(contentsToWrite.getBytes());
            outputStream.close();
            System.out.println("New file created for " + userInput.getTicker());
        }


        if (fileInfo.getPath().exists() && userInput.getMethod().equals("generate")) {
            String contentsToWrite = Double.toString(userInput.getPrice());
            for (int i = 0; i < 200; i++) {
                Random r = new Random(); // creating Random object
                double randomValue = 1 + (10 - 1) * r.nextDouble();
                String ranStr = String.format("%.2f", randomValue);

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(fileInfo.getFileFullName(), true)
                );
                writer.newLine();   //Add new line
                writer.write(ranStr);
                writer.close();
            }


        }

    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
