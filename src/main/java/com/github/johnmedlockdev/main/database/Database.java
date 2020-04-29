package com.github.johnmedlockdev.main.database;

import com.github.johnmedlockdev.main.agents.FileStructure;
import com.github.johnmedlockdev.main.logs.Logger;

import java.io.*;
import java.sql.*;

public class Database {
    private final String symbol;
    private final FileStructure fileSymbol;
    private File path;

    public Database(String function, String symbol) {
        this.symbol = symbol.toUpperCase();
        this.fileSymbol = new FileStructure(symbol);
        logic(function.toLowerCase()); // select || insert
    }

    private void logic(String function) {

        if (function.equals("select") || function.equals("s")) {
            function = "select";
            try {
                getSql(function, symbol);
            } catch (IOException | SQLException | ClassNotFoundException ioException) {
                Logger logger = new Logger();
                Logger.setup();
                logger.Log(1, ioException.toString());
            }
        } else if (function.equals("insert") || function.equals("i")) {
            function = "insert";
            try {
                getSql(function, symbol);
            } catch (IOException | SQLException | ClassNotFoundException ioException) {
                Logger logger = new Logger();
                Logger.setup();
                logger.Log(1, ioException.toString());
            }
        } else {
            System.out.println("\nInvalid function Exiting batch mode.\n");
        }
    }

    private void getSql(String function, String fileName) throws IOException, SQLException, ClassNotFoundException {
        Connection conn = connectToDatabase();

//      prepared statement setup
        PreparedStatement statement = conn.prepareStatement(getStatement(function));

//      Results set obj
        if (function.equals("select")) {
            ResultSet rs = statement.executeQuery();
            readData(rs, fileName);
            rs.close();
        } else {
            writeData(statement, fileName);
        }
        statement.close();
        conn.close();
    }

    private void readData(ResultSet rs, String fileName) throws SQLException, IOException {
        path = new File(fileSymbol.getAbsolutePathStr());

        OutputStream outputStream = new FileOutputStream(path);

        while (rs.next()) {
            if (rs.getString(2).equals(fileName)) {
                String ticker = rs.getString(2);
                double price = rs.getDouble(3);
                String output = ticker + "," + price;

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(fileSymbol.getAbsolutePathStr(), true)
                );
                writer.write(output);
                writer.newLine();
                writer.close();
            }
        }
        outputStream.close();

    }

    private void writeData(PreparedStatement statement, String fileName) throws SQLException, IOException {
        path = new File(fileSymbol.getAbsolutePathStr());

        BufferedReader br = new BufferedReader(new FileReader(fileSymbol.getAbsolutePathStr()));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] values = line.split("\\s*,\\s*");
            statement.setString(1, values[0].toUpperCase()); // set params based of what they are
            statement.setDouble(2, Double.parseDouble(values[1])); // set params based of what they are
            statement.addBatch();
        }

        statement.executeBatch();
        br.close();
    }

    private Connection connectToDatabase() throws IOException, SQLException {

        //      db connection setup
        String username = "mydb";
        String password = "mydb";
        String url = "jdbc:postgresql://3.17.207.114:5432/mydb";

        return DriverManager.getConnection(url, username, password);

    }

    private String getStatement(String method) throws IOException {
        String preparedStatement = "";

        //      prepared statement assignment
        if (method.equals("insert")) {
            preparedStatement = "insert into tickers (ticker, price) values (?,?)";
        }
        if (method.equals("select")) {
            preparedStatement = "select * from tickers";
        }

        return preparedStatement;
    }


}
