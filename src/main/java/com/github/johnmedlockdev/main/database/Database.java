package com.github.johnmedlockdev.main.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {

    public Database(String fileName) throws SQLException, IOException, ClassNotFoundException {
        getSql();
    }

    private void getSql() throws IOException, SQLException, ClassNotFoundException {

        String propertiesFile = "src/main/java/com/github/johnmedlockdev/main/database/db.properties";
        FileReader reader = new FileReader(propertiesFile);
        Properties p = new Properties();
        p.load(reader);

//      db connection setup
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");

//      prepared statement assignment
        String selectAll = p.getProperty("selectAll");
        String insertStatement = p.getProperty("insertStatement");

////////////////////////////////////////////////////////////////////////////////
        Connection conn = DriverManager.getConnection(url, username, password);
////////////////////////////////////////////////////////////////////////////////

//      prepared statement setup
        PreparedStatement stmt = conn.prepareStatement(insertStatement); // input sql statement with ?

        stmt.setString(2,"spy"); // set params based of what they are
        stmt.setDouble(3,54.34); // set params based of what they are

//      Results set obj
        ResultSet rs = stmt.executeQuery();

//        rs.next(); // you have to do this to get off the headers
//        System.out.println(rs.getInt(1)+" "+rs.getString(2) + " "+ rs.getDouble(3));

        rs.close(); // close connection
        stmt.close(); // close connection
        conn.close(); // close connection

//        prints query
//        ResultSet resultSet = statement.executeQuery(getAll);
//        ResultSetMetaData rsmd = resultSet.getMetaData();
//        int columnsNumber = rsmd.getColumnCount();
//        while (resultSet.next()) {
//            for (int i = 1; i <= columnsNumber; i++) {
//                if (i > 1) System.out.print(", ");
//                String columnValue = resultSet.getString(i);
//                System.out.print(columnValue + " " + rsmd.getColumnName(i));
//            }
//            System.out.println();
//        }


//        stuff to learn
//        results.getString(arg) .getInt(arg) statement.execute() preparedstatement(statement) executeQuery
//        System.out.println(rs.getMetaData()); => prints obj


    }

private void readData(){

}
private void writeData(){

}
}
