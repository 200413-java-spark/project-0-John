package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class BatchMode implements ModeInterface {

    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat would you like to do with the database?\n");
        String function = scanner.nextLine();

        System.out.println("\nWhich Symbol?\n");
        String symbol = scanner.nextLine();

        new Database(function, symbol);
        ModeInterface.startOver();
        scanner.close();
    }

}

