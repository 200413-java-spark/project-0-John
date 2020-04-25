package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.agents.Ticker;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.util.Scanner;

public class ManualMode implements Mode {

    @Override
    public void gatherInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the Ticker?");
        String symbol = scanner.nextLine();

        System.out.println("What is the price?");
        String price = scanner.nextLine();

        Ticker ticker = new Ticker(symbol, price);
        ticker.createFile();
    }

}
