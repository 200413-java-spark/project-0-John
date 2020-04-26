package com.github.johnmedlockdev.main.database;

import org.junit.Test;

public class DatabaseTest {
    @Test
    public void selectStmts() {
        Database db = new Database("Select", "TEST");
    }

    @Test
    public void insertStmts() {
        Database db = new Database("insert", "TEST");
    }
}
