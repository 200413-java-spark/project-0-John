package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.agents.Demo;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class GenerateMode implements ModeInterface {

    @Override
    public void gatherInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the Ticker?");
        String symbol = scanner.nextLine();

        System.out.println("How Many Inputs?");
        String numberOfInputs = scanner.nextLine();

        new Demo(symbol, numberOfInputs).generate();

        ModeInterface.startOver();
        scanner.close();
    }
}
