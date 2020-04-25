package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.modes.interfaces.Mode;
import com.github.johnmedlockdev.main.strategy.interfaces.Strategy;

import java.util.Scanner;

public class PredictMode implements Mode {
    @Override
    public void gatherInput() {

        System.out.println("What symbol?");
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.nextLine();

        System.out.println("What Strategy?");
        scanner = new Scanner(System.in);
        String strategy = scanner.nextLine();

        Strategy strat = new Strategy(symbol, strategy);
    }
}
