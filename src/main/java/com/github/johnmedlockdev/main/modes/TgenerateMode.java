package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.agents.Demo;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class TgenerateMode extends GenerateMode {

    @Override
    public void gatherInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What are the Tickers?");
        System.out.println("ticker,ticker,ticker");
        String symbol = scanner.nextLine();

        System.out.println("How Many Inputs?");
        String numberOfInputs = scanner.nextLine();

        new Demo(symbol, numberOfInputs).tGenerate();

        ModeInterface.startOver();
        scanner.close();
    }
}
