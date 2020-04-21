package com.github.johnmedlockdev.main.strategy.strategies;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.strategy.Strategy;

import java.io.IOException;
import java.util.Arrays;

public class test extends Strategy {
    double[] values = super.processData();

    public test(Data data) throws IOException {
        super(data);
    }


    public void advise() {
        System.out.println(Arrays.toString(values));
    }
}


//TODO
//trying to get processed data from parent.