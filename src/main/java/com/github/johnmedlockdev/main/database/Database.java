package com.github.johnmedlockdev.main.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {


    public Database(String fileName) throws SQLException, IOException, ClassNotFoundException {
//        getSql("insert");
        getSql("select");
    }

    private void getSql(String method) throws IOException, SQLException, ClassNotFoundException {

        Connection conn = connectToDatabase();

//      prepared statement setup
        PreparedStatement stmt = conn.prepareStatement(getStatement(method)); // input sql statement with ?
//
//        stmt.setString(1, "spy"); // set params based of what they are
//        stmt.setDouble(2, 54.34); // set params based of what they are

//      Results set obj
        ResultSet rs = stmt.executeQuery();

        rs.next(); // you have to do this to get off the headers
        System.out.println(rs.getInt(1)+" "+rs.getString(2) + " "+ rs.getDouble(3));

        rs.close(); // close connection
        stmt.close(); // close connection
        conn.close(); // close connection

    }


    private void readData() {

    }

    private void writeData() {

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
