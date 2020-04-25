package com.github.johnmedlockdev.main.strategy;

import java.util.Arrays;

public class MovingAverage extends Strategy {

    public MovingAverage(String symbol) {
        super(symbol);
        System.out.println(Arrays.toString(processData().toArray()));
    }
}
