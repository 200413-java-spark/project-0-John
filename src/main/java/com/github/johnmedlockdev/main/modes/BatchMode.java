package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchMode implements Mode {

    @Override
    public void gatherInput() {
        System.out.println("What would you like to do with the database?");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String function = scanner.nextLine();  // Read user input
        try {
            Database dataDB = new Database(function);
        } catch (SQLException | ClassNotFoundException | IOException horribles) {
            horribles.printStackTrace();
        }
    }

}


//todo deal with horribles