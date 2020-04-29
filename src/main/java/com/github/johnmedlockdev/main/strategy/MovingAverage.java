package com.github.johnmedlockdev.main.strategy;

import java.util.ArrayList;

public class MovingAverage extends Strategy {

    public MovingAverage(String symbol) {
        super(symbol);
    }

    @Override
    public void advise() {
        ArrayList<Double> values = processData();
        double sum = 0;
        double count = 0;
        double averagePrice = 0;
        double lastPrice = values.get(values.size() - 1);

        for (Double value : values) {
            sum += value;
            count++;
        }

        averagePrice = sum / count;

        sum = (int) (sum * 100) / 100.0;
        averagePrice = (int) (averagePrice * 100) / 100.0;

        System.out.println("\nInput Sum: " + sum);
        System.out.println("\nInput Count: " + count);
        System.out.println("\nAverage Price: $" + averagePrice);
        System.out.println("\nLast Price: $" + lastPrice);
        System.out.println("\n=========================\n");

        if (lastPrice > averagePrice) {
            System.out.printf("You are in a Bull market. The last input of $%s is higher than the $%s.\n", lastPrice, averagePrice);
        } else {
            System.out.printf("You are in a bear market. The last input of $%s is lower than the $%s.\n", lastPrice, averagePrice);
        }
    }
}

//        System.out.println(Arrays.toString(processData().toArray()));