package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {

        ParseInput userInput = new ParseInput(args);
        FileInfo fileInfo = new FileInfo(userInput);
        Data data = new Data(userInput, fileInfo);

        switch (data.getMethod()) {
            case "new":
                data.createFile();
                break;
            case "add":
                data.createInput();
                break;
            case "generate":
                data.generate();
                break;
            case "predict":
                data.getPrediction();
                break;
            default:
                System.out.println("Not a valid method.");
                break;
        }


    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
