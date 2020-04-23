package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.file.FileInfo;
import com.github.johnmedlockdev.main.parse.ParseInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String... args) throws SQLException, IOException, ClassNotFoundException {

        while (true) {
            ParseInput userInput = new ParseInput(args);

            if (userInput.getMode().equals("")) {

                FileInfo fileInfo = new FileInfo(userInput);
                Data data = new Data(userInput, fileInfo);

                data.logic();

            } else {
                // need to refactor this
                if (userInput.getMode().equals("exit")) {
                    break;
                }
                System.out.println("What would you like to do with the database?");
                Scanner scanner = new Scanner(System.in);  // Create a Scanner object
                String function = scanner.nextLine();  // Read user input
                Database dataDB = new Database(function);
            }

        }
    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
