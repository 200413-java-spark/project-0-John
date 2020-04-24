package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.datastructures.User;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.util.Scanner;

public class ManualMode implements Mode {

    @Override
    public void gatherInput() {

        System.out.println("What is the Ticker?");
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.nextLine();

        System.out.println("What is the price?");
        scanner = new Scanner(System.in);
        String price = scanner.nextLine();

        User ticker = new User(symbol, price);
    }

}
