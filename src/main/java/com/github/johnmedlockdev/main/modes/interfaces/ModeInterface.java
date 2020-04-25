package com.github.johnmedlockdev.main.modes.interfaces;

import com.github.johnmedlockdev.main.routes.Init;

import java.util.Scanner;

public interface ModeInterface {

    static void startOver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Mode: Manual : M || Batch : B || Generate : G || Advise : A || Exit : E");
        String[] input = {scanner.nextLine()};
        new Init(input);
        scanner.close();
    }

    void gatherInput();
}