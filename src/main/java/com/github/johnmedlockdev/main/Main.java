package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;

import java.util.Scanner;

public class Main {
    public static void main(String... args) {

        while (true) {
            ParseInput userInput = new ParseInput(args);

            if (userInput.getMode().equals("")) {

                FileInfo fileInfo = new FileInfo(userInput);
                Data data = new Data(userInput, fileInfo);

                data.logic();

            } else {
                if (userInput.getMode().equals("exit")) {
                    break;
                }
                System.out.println("What's the name of the file you would like to input?");
                Scanner scanner = new Scanner(System.in);  // Create a Scanner object
                String fileName = scanner.nextLine();  // Read user input
                Database dataDB = new Database(fileName);

            }

        }
    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
