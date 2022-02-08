package edu.ib.structures;


import java.sql.*;
import java.util.ArrayList;

/**
 * edu.ib.structures.Tester
 * class used to perform operations on database
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class Tester {
    /**
     * Methode transforming database response into 2D ArrayList of results
     * @param resultSet response od database
     * @return 2D String Arraylist which rows are SQL rows and columns are specific values
     * @throws SQLException thrown if SQL request is not valid
     */
    public static ArrayList<ArrayList<String>> getResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while (resultSet.next()){
            ArrayList<String> column = new ArrayList<>();
            for (int i=1; i<=columnCount; i++){//kolumny zaczynaja się od 1
                String string = resultSet.getString(i);
                if (string == null)
                    string = "brak";
                column.add(string);
            }
            result.add(column);
        }
        return result;
    }

    /**
     * Methode performing a procedure in database
     * @param command text of calling procedure, console version
     * @throws SQLException thrown if SQL request is not valid
     */
    public static void callProcedure(String command) throws SQLException {
        String urlConnection= "jdbc:mysql://" +
                "localhost:3306/" +
                "punkt_szczepien?" + // znak zapytania jest ważny
                "useUnicode=true&characterEncoding=utf-8" +
                "&user=admin" +
                "&password=password" +
                "&servertimeZone=CET";
        Connection connection = DriverManager.getConnection(urlConnection);
        PreparedStatement selectAllStatement = connection.
                prepareStatement(command);
        selectAllStatement.executeQuery();
    }

    /**
     * Methode selecting data from database
     * @param command text of selecting procedure, console version
     * @return 2D String Arraylist which rows are SQL rows and columns are specific values
     * @throws SQLException thrown if SQL request is not valid
     */
    public static ArrayList<ArrayList<String>> dataBaseInfo(String command) throws SQLException {
        String urlConnection= "jdbc:mysql://" +
                "localhost:3306/" +
                "punkt_szczepien?" + // znak zapytania jest ważny
                "useUnicode=true&characterEncoding=utf-8" +
                "&user=admin" +
                "&password=password" +
                "&servertimeZone=CET";
        Connection connection = DriverManager.getConnection(urlConnection);
        PreparedStatement selectAllStatement = connection.
                prepareStatement(command);
        ResultSet rsTableContent = selectAllStatement.executeQuery();
        return getResult(rsTableContent);
    }


}
