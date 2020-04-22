package com.github.johnmedlockdev.main.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {

    private final String propertiesFile = "src/main/java/com/github/johnmedlockdev/main/database/db.properties";

    public Database(String fileName) throws SQLException, IOException, ClassNotFoundException {
        getSql();
    }

    private void getSql() throws IOException, SQLException, ClassNotFoundException {

        FileReader reader = new FileReader(propertiesFile);
        Properties p = new Properties();
        p.load(reader);

        String user = p.getProperty("user");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String getAll = p.getProperty("selectAll");

        Class.forName(p.getProperty("postgresDriver"));

        Connection conn = DriverManager.getConnection(url, user, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getAll);
        while (rs.next()) {
//            String[] args;
//            args[0] = rs.getString("operation");
//            then he added it to array that he defined earlier
            // todo: learn prepared statement syntax
        }
    }


}
