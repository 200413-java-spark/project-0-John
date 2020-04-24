package com.github.johnmedlockdev.main.parse;

public class ParseMode {
    private String mode;

    public ParseMode(String[] args) {
        this.mode = args[0];
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        mode = capitalizeInput(mode);

        if (mode.equals("Manual") || mode.equals("Batch") || mode.equals("Generate") || mode.equals("Predict")) {
            this.mode = mode;
        } else {
            System.out.printf("modes are batch or man. mode=%s is not a mode", mode);
        }
    }

    private String capitalizeInput(String input) {
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        return input;
    }
}


// class should route the user based off what mode they select.
// modes are man and batch.