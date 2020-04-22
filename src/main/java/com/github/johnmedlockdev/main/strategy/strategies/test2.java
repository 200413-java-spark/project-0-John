package com.github.johnmedlockdev.main.strategy.strategies;

import com.github.johnmedlockdev.main.data.Data;
import com.github.johnmedlockdev.main.strategy.Strategy;

import java.util.Arrays;

public class test2 extends Strategy {
    double[] values = super.processData();

    public test2(Data data) {
        super(data);

    }


    public void advise() {
        System.out.println(Arrays.toString(values));
    }
}


//TODO
//trying to get processed data from parent.