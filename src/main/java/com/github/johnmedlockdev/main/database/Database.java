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

        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String getAll = p.getProperty("selectAll");

        Class.forName(p.getProperty("postgresDriver"));


        Connection db = DriverManager.getConnection(url,username, password);
        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery(getAll);

        while (rs.next()) {
            System.out.print("Column 1 returned ");
            System.out.println(rs.getString(1));
        }
        rs.close();
        st.close();
    }


}
