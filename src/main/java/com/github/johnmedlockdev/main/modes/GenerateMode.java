package com.github.johnmedlockdev.main.modes;

import com.github.johnmedlockdev.main.datastructures.Demo;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

import java.util.Scanner;

public class GenerateMode implements Mode {
    @Override
    public void gatherInput() {

        System.out.println("What is the Ticker?");
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.nextLine();

        Demo demo = new Demo(symbol);

    }
}
