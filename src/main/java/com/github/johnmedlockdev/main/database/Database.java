package com.github.johnmedlockdev.main.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Database {


    public Database(String function) throws SQLException, IOException, ClassNotFoundException {
        logic(function); // view || write || exit
    }

    private void logic(String function) throws SQLException, IOException, ClassNotFoundException {
        if (function.equals("select")) {
            //     view = will write or append data to a local file in storage // ask for data name
            System.out.println("Which data do you want to select?");
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String fileName = scanner.nextLine();  // Read user input

            getSql(function, fileName);
        } else if(function.equals("insert")) {
            //     write = will write data from file stored in storage // ask for file name
            System.out.println("What's the name of your file?"); // file must be located in storage.
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String fileName = scanner.nextLine();  // Read user input

            getSql(function, fileName);
        }else if(function.equals("exit")) {
            System.out.println("Exiting batch mode.");
        }
    }

    private void getSql(String function, String fileName) throws IOException, SQLException, ClassNotFoundException {

        Connection conn = connectToDatabase();

//      prepared statement setup
        PreparedStatement statement = conn.prepareStatement(getStatement(function)); // input sql statement with ?

//      Results set obj
        if (function.equals("select")) {
            ResultSet rs = statement.executeQuery();
            readData(rs);
            rs.close(); // close connection
        } else {
            writeData(statement);
        }

        statement.close(); // close connection
        conn.close(); // close connection
    }


    private void readData(ResultSet rs) throws SQLException {
        while (rs.next()) {

            int id = rs.getInt(1);
            String ticker = rs.getString(2);
            double price = rs.getDouble(3);
            System.out.println(id + " " + ticker + " " + price);

// TODO: would be nice to have it generate a file instead of just writing to the commandline.

        }
    }

    private void writeData(PreparedStatement statement) throws SQLException {
        statement.setString(1, "adsaf"); // set params based of what they are
        statement.setDouble(2, 345.34); // set params based of what they are
        statement.executeUpdate();
    }

    private Connection connectToDatabase() throws IOException, SQLException {
        String propertiesFile = "src/main/java/com/github/johnmedlockdev/main/database/db.properties";
        FileReader reader = new FileReader(propertiesFile);
        Properties p = new Properties();
        p.load(reader);

        //      db connection setup
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");

        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;

    }

    private String getStatement(String method) throws IOException {
        String preparedStatement = "";
        String propertiesFile = "src/main/java/com/github/johnmedlockdev/main/database/statements.properties";
        FileReader reader = new FileReader(propertiesFile);
        Properties p = new Properties();
        p.load(reader);

        //      prepared statement assignment
        if (method.equals("insert")) {
            String insertStatement = p.getProperty("insertStatement");
            preparedStatement = insertStatement;

        }
        if (method.equals("select")) {
            String selectAll = p.getProperty("selectAll");
            preparedStatement = selectAll;
        }

        return preparedStatement;
    }


}
