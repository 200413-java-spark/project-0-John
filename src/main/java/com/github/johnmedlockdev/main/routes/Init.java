package com.github.johnmedlockdev.main.routes;

import com.github.johnmedlockdev.main.modes.AdviseMode;
import com.github.johnmedlockdev.main.modes.BatchMode;
import com.github.johnmedlockdev.main.modes.GenerateMode;
import com.github.johnmedlockdev.main.modes.ManualMode;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class Init {


    public Init(String[] args) {
        String selection = args[0];
        System.out.println("Select Mode: Manual : M || Batch : B || Generate : G || Advise : A || Exit : E");
        modeFactory(selection);
    }

    private void modeFactory(String selection) {
        ModeInterface mode = null;
        selection = capitalizeInput(selection);
        if (selection.equals("Exit") || selection.equals("E")) {
            System.out.println("Exiting Program");
            System.exit(1);
        }
        switch (selection) {
            case "Manual":
            case "M":
                mode = new ManualMode();
                break;
            case "Batch":
            case "B":
                mode = new BatchMode();
                break;
            case "Generate":
            case "G":
                mode = new GenerateMode();
                break;
            case "Advise":
            case "A":
                mode = new AdviseMode();
                break;
            default:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid input! Select a valid mode.");
                String[] input = {scanner.nextLine()};
                new Init(input);
                scanner.close();
                ModeInterface.startOver();
        }
        if (mode == null) {
            System.exit(1);
        }
        mode.gatherInput();
    }

    private String capitalizeInput(String input) {
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        return input;
    }
}