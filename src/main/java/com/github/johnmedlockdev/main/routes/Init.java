package com.github.johnmedlockdev.main.routes;

import com.github.johnmedlockdev.main.modes.*;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

import java.util.Scanner;

public class Init {

    public Init(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nSelect Mode\n");
            System.out.println("Manual : M || Batch : B || Generate : G || Tgenerate : T || Advise : A || Exit : E\n");
            String selection = scanner.nextLine();
            modeFactory(selection);
        }
        String selection = args[0];
        modeFactory(selection);
    }

    private void modeFactory(String selection) {
        ModeInterface mode = null;
        selection = capitalizeInput(selection);
        if (selection.equals("Exit") || selection.equals("E")) {
            System.out.println("\nExiting Program");
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
            case "Tgenerate":
            case "T":
                mode = new TgenerateMode();
                break;
            case "Advise":
            case "A":
                mode = new AdviseMode();
                break;
            default:
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nInvalid input! Select a valid mode.");
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
        input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        return input;
    }
}