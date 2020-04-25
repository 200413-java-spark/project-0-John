package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.agents.Demo;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.util.Scanner;

public class GenerateMode implements Mode {
    @Override
    public void gatherInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the Ticker?");
        String symbol = scanner.nextLine();

        Demo demo = new Demo(symbol);

    }
}
