package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;
import com.github.johnmedlockdev.main.strategy.MovingAverage;
import com.github.johnmedlockdev.main.strategy.Strategy;

import java.util.Scanner;

public class AdviseMode implements ModeInterface {

    @Override
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat symbol?\n");
        String symbol = scanner.nextLine().toUpperCase();

        System.out.println("\nWhat Strategy?\n");
        String indicator = scanner.nextLine().toUpperCase();

        strategyFactory(symbol, indicator);
        scanner.close();
    }

    public void strategyFactory(String symbol, String indicator) {

        Strategy strategy = null;
        switch (indicator) {
            case "MOVINGAVERAGE":
            case "MA":
                strategy = new MovingAverage(symbol);
                break;
            default:
                System.out.printf("\nThis Program doesn't currently support indicator=%s\n", indicator);
        }
        assert strategy != null;
        strategy.advise();
        ModeInterface.startOver();
    }
}
