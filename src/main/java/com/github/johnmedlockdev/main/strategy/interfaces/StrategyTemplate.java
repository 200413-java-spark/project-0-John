package com.github.johnmedlockdev.main.strategy.interfaces;

import java.io.IOException;

public interface StrategyTemplate {

    double[] processData() throws IOException;

    void advise();
}
