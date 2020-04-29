package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.agents.Ticker;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class ManualMode implements ModeInterface {

    @Override
    public void gatherInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat is the Ticker?\n");
        String symbol = scanner.nextLine();

        System.out.println("\nWhat is the price?\n");
        String price = scanner.nextLine();

        Ticker ticker = new Ticker(symbol, price);
        ticker.createInput();
        ModeInterface.startOver();
        scanner.close();
    }

}
