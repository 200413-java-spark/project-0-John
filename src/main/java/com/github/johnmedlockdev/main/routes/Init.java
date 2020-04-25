package com.github.johnmedlockdev.main.routes;

import com.github.johnmedlockdev.main.modes.BatchMode;
import com.github.johnmedlockdev.main.modes.GenerateMode;
import com.github.johnmedlockdev.main.modes.ManualMode;
import com.github.johnmedlockdev.main.modes.PredictMode;
import com.github.johnmedlockdev.main.modes.interfaces.Mode;

public class Init {

    public Init(String[] args) {
        String selection = args[0];
        logic(selection);
    }

    private void logic(String selection) {
        selection = capitalizeInput(selection);
        Mode mode;
        switch (selection) {
            case "Manual":
                mode = new ManualMode();
                break;
            case "Batch":
                mode = new BatchMode();
                break;
            case "Generate":
                mode = new GenerateMode();
                break;
            case "Predict":
                mode = new PredictMode();
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