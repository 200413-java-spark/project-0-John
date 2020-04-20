package com.github.johnmedlockdev.main.file;

import com.github.johnmedlockdev.main.parse.ParseInput;

import java.io.File;

public class FileInfo {
    String fileFullName;
    File path;

    public FileInfo(ParseInput userInput){
        fileFullName = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\storage\\" + userInput.getTicker()+ ".csv";
        path = new File(fileFullName);
    }

    public String getFileFullName(){
        return this.fileFullName;
    }

    public File getPath(){
        return this.path;
    }
}

