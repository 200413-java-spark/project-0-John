package com.github.johnmedlockdev.main.database;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Database {

    public Database(String function) throws SQLException, IOException, ClassNotFoundException {
        logic(function); // view || write || exit
    }

    // TODO: duplicate code
    private void logic(String function) throws SQLException, IOException, ClassNotFoundException {
        if (function.equals("select")) {
            //     view = will write or append data to a local file in storage // ask for data name
            System.out.println("Which data do you want to select?");
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String fileName = scanner.nextLine();  // Read user input

            getSql(function, fileName);
        } else if (function.equals("insert")) {
            //     write = will write data from file stored in storage // ask for file name
            System.out.println("What's the name of your file?"); // file must be located in storage.
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String fileName = scanner.nextLine();  // Read user input

            getSql(function, fileName);
        } else if (function.equals("exit")) {
            System.out.println("Exiting batch mode.");
            //TODO: this needs to properly exit the loop
        }
    }

    private void getSql(String function, String fileName) throws IOException, SQLException, ClassNotFoundException {

        Connection conn = connectToDatabase();

//      prepared statement setup
        PreparedStatement statement = conn.prepareStatement(getStatement(function)); // input sql statement with ?

//      Results set obj
        if (function.equals("select")) {
            ResultSet rs = statement.executeQuery();
            readData(rs, fileName);
            rs.close(); // close connection
        } else {
            writeData(statement, fileName);
        }

        statement.close(); // close connection
        conn.close(); // close connection
    }


    private void readData(ResultSet rs, String fileName) throws SQLException, IOException {

        String fileFullName;
        File path;

        fileFullName = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\storage\\" + fileName.toUpperCase() + ".csv";
        path = new File(fileFullName);

        if (!path.exists()) {
            OutputStream outputStream = new FileOutputStream(path);
        }

        while (rs.next()) {

            String ticker = rs.getString(2);
            double price = rs.getDouble(3);
            String output = ticker + "," + price;

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileFullName, true)
            );
            writer.write(output);
            writer.newLine();
            writer.close();
        }
        // TODO: would be nice to have it generate a file instead of just writing to the commandline. X
    }

    // TODO: make read from csv file X
    private void writeData(PreparedStatement statement, String fileName) throws SQLException, IOException {
        // for reading
        String fileFullName;
        File path;

        fileFullName = new File("").getAbsolutePath() + "\\src\\main\\java\\com\\github\\johnmedlockdev\\main\\data\\storage\\" + fileName.toUpperCase() + ".csv";
        path = new File(fileFullName);


            BufferedReader br = new BufferedReader(new FileReader(fileFullName));
            String line = "";
            while ((line = br.readLine()) != null) {
                statement.setString(1, fileName); // set params based of what they are
                statement.setDouble(2, Double.parseDouble(line)); // set params based of what they are
                statement.addBatch();
            }

        statement.executeBatch();
    }

    private Connection connectToDatabase() throws IOException, SQLException {
        String dbFile = "src/main/java/com/github/johnmedlockdev/main/database/db.properties";
        FileReader reader = new FileReader(dbFile);
        Properties p = new Properties();
        p.load(reader);

        //      db connection setup
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");

        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;

    }

    // TODO: probably need to refactor the properties file.
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
