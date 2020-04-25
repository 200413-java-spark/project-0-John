package com.github.johnmedlockdev.main.agents;

import java.io.File;

public class FileStructure extends User {

    private final String absolutePathStr;
    private final File path;

    public FileStructure(String symbol) {
        super(symbol);
        absolutePathStr = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\" + super.getSymbol() + ".csv";
        path = new File(absolutePathStr);
    }

    public String getAbsolutePathStr() {
        return this.absolutePathStr;
    }

    public File getPath() {
        return this.path;
    }

}

