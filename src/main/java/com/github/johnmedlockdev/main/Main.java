package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.modes.BatchMode;
import com.github.johnmedlockdev.main.modes.ManualMode;
import com.github.johnmedlockdev.main.parse.ParseMode;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String... args) throws SQLException, IOException, ClassNotFoundException {

        ParseMode parseMode = new ParseMode(args);

        if (parseMode.getMode().equals("Manual")) {
            ManualMode manualMode = new ManualMode();
            manualMode.gatherInput();

        } else if (parseMode.getMode().equals("Batch")) {
            BatchMode batchMode = new BatchMode();
            batchMode.gatherInput();
        }

    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
