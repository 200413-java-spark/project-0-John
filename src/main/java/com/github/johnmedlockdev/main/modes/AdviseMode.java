package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;
import com.github.johnmedlockdev.main.strategy.MovingAverage;
import com.github.johnmedlockdev.main.strategy.Strategy;

import java.util.Scanner;

public class AdviseMode implements ModeInterface {

    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What symbol?");
        String symbol = scanner.nextLine();

        System.out.println("What Strategy?");
        String indicator = scanner.nextLine();

        strategyFactory(symbol, indicator);
    }

    public void strategyFactory(String symbol, String indicator) {

        Strategy strategy;
        switch (indicator) {
            case "MovingAverage":
            case "MA":
                strategy = new MovingAverage(symbol);
        }
    }
}
