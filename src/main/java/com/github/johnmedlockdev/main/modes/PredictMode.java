package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.modes.interfaces.Mode;
import com.github.johnmedlockdev.main.strategy.interfaces.Strategy;

import java.util.Scanner;

public class PredictMode implements Mode {
    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What symbol?");
        String symbol = scanner.nextLine();

        System.out.println("What Strategy?");
        String strategy = scanner.nextLine();

        Strategy strat = new Strategy(symbol, strategy);
    }
}
