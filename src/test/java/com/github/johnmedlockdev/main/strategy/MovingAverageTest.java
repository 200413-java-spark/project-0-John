package com.github.johnmedlockdev.main.strategy;

import org.junit.Test;

public class MovingAverageTest {
    @Test
    public void advise() {
        MovingAverage mv = new MovingAverage("TEST");
        mv.advise();
    }
}
