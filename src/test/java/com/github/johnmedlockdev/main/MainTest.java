package com.github.johnmedlockdev.main;

import com.github.johnmedlockdev.main.data.Data;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {


    @Before
    public void setup() {
//        String[] args = {"new", "appl", "25"};
//        ParseInput userInput = new ParseInput(args);
//
//        FileInfo fileInfo = new FileInfo(userInput);
//        Data data = new Data(userInput, fileInfo);

    }

    @Test
    public void methodIsNew() {
        String[] args = {"new", "appl", "25"};
        ParseInput userInput = new ParseInput(args);

        FileInfo fileInfo = new FileInfo(userInput);
        Data data = new Data(userInput, fileInfo);
        String expected = "new";
        String actual = data.getMethod();

        assertEquals(expected, actual);
    }

    @Test
    public void filePathIs() {
        String[] args = {"new", "appl", "25"};
        ParseInput userInput = new ParseInput(args);

        FileInfo fileInfo = new FileInfo(userInput);
        Data data = new Data(userInput, fileInfo);
        System.out.println();
        String expected = "C:\\Users\\johnm\\IdeaProjects\\project-0-John\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\storage\\APPL.csv";
        String actual = data.getFileFullName();

        assertEquals(expected, actual);
    }

//
//    @Test
//    public void whenAdding2And2ThenOutput4() {
//        // Experiment
//        double expected = 4.0;
//        double actual = 4.0;
//
//        // Assert
//        assertEquals(expected, actual, 0.0);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenMissingSubcommandArgsThrowException() {
//        String[] args = {"ad", "2", "2"};
//        //  this.testOp = factory.getOperation(args);
//    }


}

