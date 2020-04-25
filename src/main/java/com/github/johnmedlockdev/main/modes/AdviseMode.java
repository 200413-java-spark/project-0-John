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
        String symbol = scanner.nextLine().toUpperCase();

        System.out.println("What Strategy?");
        String indicator = scanner.nextLine().toUpperCase();

        strategyFactory(symbol, indicator);
    }

    public void strategyFactory(String symbol, String indicator) {

        Strategy strategy = null;
        switch (indicator) {
            case "MOVINGAVERAGE":
            case "MA":
                strategy = new MovingAverage(symbol);
                break;
            default:
                System.out.printf("This Program doesn't currently support indicator=%s",indicator);
        }
        assert strategy != null;
        strategy.advise();
    }
}
