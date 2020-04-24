package com.github.johnmedlockdev.main.data;

import com.github.johnmedlockdev.main.strategy.interfaces.Strategy;
import com.github.johnmedlockdev.main.strategy.test;
import com.github.johnmedlockdev.main.strategy.test1;
import com.github.johnmedlockdev.main.strategy.test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Data {

    private BufferedWriter writer;

    //  methods
    public void getPrediction() {
//todo refactor doesn't work
        try {
            // get user input to display which strategy they want.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Which strategy would you like to use?");
            String nameOfStrategy = reader.readLine();

            Strategy strategy;
            switch (nameOfStrategy) {
                case "test":
                    strategy = new test(this);
                    break;
                case "test1":
                    strategy = new test1(this);
                    break;
                case "test2":
                    strategy = new test2(this);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + nameOfStrategy);
            }

            strategy.advise();

        } catch (IOException e) {
            System.out.println("Completed!");
        }

    public void logic() {
        switch (getMethod()) {
            case "new":
                createFile();
                break;
            case "add":
                createInput();
                break;
            case "generate":
                generate();
                break;
            case "predict":
                getPrediction();
                break;
            default:
                System.out.println("Not a valid method.");
                break;
        }
    }
}