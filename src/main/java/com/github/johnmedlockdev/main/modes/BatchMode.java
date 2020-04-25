package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchMode implements Mode {

    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println("What would you like to do with the database?");
        String function = scanner.nextLine();  // Read user input

        System.out.println("Which Symbol?");
        String symbol = scanner.nextLine();  // Read user input

        Database dataDB = new Database(function,symbol);
    }

}


//todo deal with horribles