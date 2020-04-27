package com.github.johnmedlockdev.main.logs;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Logger {
    private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
    static private FileHandler fileTxt;

    static public void setup() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
        try {
            fileTxt = new FileHandler("Logging.txt", true);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        SimpleFormatter formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }

    public void Log(int num, String exception) {

        LOGGER.setLevel(Level.INFO);

        if (num == 1) {
            LOGGER.severe(exception);
        } else if (num == 2) {
            LOGGER.severe(exception);
        } else if (num == 3) {
            LOGGER.warning(exception);
        } else if (num == 4) {
            LOGGER.info(exception);
        } else {
            LOGGER.finest(exception);
        }
    }
}
