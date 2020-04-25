package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.database.Database;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class BatchMode implements ModeInterface {

    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do with the database?");
        String function = scanner.nextLine();

        System.out.println("Which Symbol?");
        String symbol = scanner.nextLine();

        new Database(function, symbol);
    }

}

