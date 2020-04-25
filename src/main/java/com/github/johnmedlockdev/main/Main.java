package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.routes.Init;

public class Main {
    public static void main(String... args) {
        Init init = new Init(args);
    }
}

// Desired output:
// 1. feed in SPY data
// 2. add data to csv or json file
// 3. get back trade recommendation based off where the ticker is in the 200 day
// moving average.
