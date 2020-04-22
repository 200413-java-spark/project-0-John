package com.github.johnmedlockdev.main.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {
    public Database(String fileName) {

    }

    private void getSql() throws IOException, SQLException {

        FileReader reader = new FileReader("db.properties");
        Properties p = new Properties();
        p.load(reader);
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String getAll = p.getProperty("selectAll");

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
