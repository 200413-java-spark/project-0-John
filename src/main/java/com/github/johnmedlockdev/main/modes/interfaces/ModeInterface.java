package com.github.johnmedlockdev.main.modes.interfaces;

import com.github.johnmedlockdev.main.routes.Init;

import java.util.Scanner;

public interface ModeInterface {

    static void startOver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect Mode\n");
        System.out.println("Manual : M || Batch : B || Generate : G || Tgenerate : T || Advise : A || Exit : E\n");
        String[] input = {scanner.nextLine()};
        new Init(input);
        scanner.close();
    }

    void gatherInput();
}