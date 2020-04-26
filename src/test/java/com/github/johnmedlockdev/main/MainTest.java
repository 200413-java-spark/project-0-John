package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.routes.Init;
import org.junit.Test;

public class MainTest {
    @Test
    public void init() {
        String[] args = {"E"};
        new Init(args);
    }

}

