package com.github.johnmedlockdev.main.routes;

import com.github.johnmedlockdev.main.modes.BatchMode;
import com.github.johnmedlockdev.main.modes.GenerateMode;
import com.github.johnmedlockdev.main.modes.ManualMode;
import com.github.johnmedlockdev.main.modes.PredictMode;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

public class Init {
    private String userSelection;

    public Init(String[] args) {
        logic(args[0]);
    }

     private Mode logic(String arg) {
        userSelection = capitalizeInput(userSelection);
        Mode mode;
        switch (userSelection) {
            case "Manual":
                mode = new ManualMode();
                mode.gatherInput();
                break;
            case "Batch":
                mode = new BatchMode();
                mode.gatherInput();
                break;
            case "Generate":
                mode = new GenerateMode();
                break;
            case "Predict":
                mode = new PredictMode();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + userSelection);
        }
        return mode;
    }


    private String capitalizeInput(String input) {
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        return input;
    }
}