package com.github.johnmedlockdev.main.routes;

import com.github.johnmedlockdev.main.modes.AdviseMode;
import com.github.johnmedlockdev.main.modes.BatchMode;
import com.github.johnmedlockdev.main.modes.GenerateMode;
import com.github.johnmedlockdev.main.modes.ManualMode;
import com.github.johnmedlockdev.main.modes.interfaces.ModeInterface;

public class Init {

    public Init(String[] args) {
        String selection = args[0];
        System.out.println("Select Mode:");
        System.out.println("Manual : M || Batch : B || Generate : G || Advise : A");
        modeFactory(selection);
    }

    private void modeFactory(String selection) {
        selection = capitalizeInput(selection);
        ModeInterface mode;

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
                throw new IllegalStateException("Unexpected value: " + selection);
        }
        mode.gatherInput();
    }

    private String capitalizeInput(String input) {
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        return input;
    }
}