package edu.ib.structures;


//import com.sun.rowset.CachedRowSetImpl;
//
//import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.ArrayList;


public class Tester {
    public static void main(String[] args) {
        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://");
        url.append("localhost:3306/");
        url.append("punkt_szczepien?"); // znak zapytania jest ważny
        url.append("useUnicode=true&characterEncoding=utf-8");
        url.append("&user=admin");
        url.append("&password=password");
        url.append("&servertimeZone=CET");
        String urlConnection= url.toString();

        try {
            Connection connection = DriverManager.getConnection(urlConnection);

            PreparedStatement selectAllStatement = connection.
                    prepareStatement("select PESEL, Haslo from Pacjenci_zapisywani;");
            ResultSet rsTableContent = selectAllStatement.executeQuery();
            ArrayList<ArrayList<String>> res = getResult(rsTableContent);
            System.out.println(res.get(0).get(1));
//            System.out.println();
//            printResultsSet(rsTableContent);
//            rsTables.close();
//            showTableStm.close();
//            String insertString = "INSERT INTO "  +
//                    "table_mcharacters (id, first, last, age)" +
//                    "VALUES (200, 'John', 'Doe', 23);";
//            PreparedStatement insertStm = connection.prepareStatement(insertString);
//            int rowAffected = insertStm.executeUpdate();
//            System.out.println("Affected rows: " + rowAffected);

//            String deleteString = "DELETE from "  +
//                    "table_mcharacters where last='Doe';";
//            PreparedStatement deleteStm = connection.prepareStatement(deleteString);
//            int rowAffected = deleteStm.executeUpdate();
//            System.out.println("Affected rows: " + rowAffected);
//            printResultsSet(rsTableContent);

//            System.out.println("*******************************************");
//            String query = "INSERT INTO table_mcharacters (id, first, last, age) Values (?,?,?,?);";
//            PreparedStatement multipleInsertStm = connection.prepareStatement(query);
//            for (MovieCharacter mc: movieCharacters){
//                multipleInsertStm.setInt(1,mc.getId());
//                multipleInsertStm.setString(2,mc.getFirst());
//                multipleInsertStm.setString(3,mc.getLast());
//                multipleInsertStm.setInt(4,mc.getAge());
//                multipleInsertStm.addBatch();
//            }
//            multipleInsertStm.executeBatch();
//            rsTables.close();
//            showTableStm.close();
//            PreparedStatement insertMultipleCheckStm = connection.prepareStatement("SELECT * FROM table_mcharacters");
//            ResultSet rsMultipleTableCheck = insertMultipleCheckStm.executeQuery();
//            CachedRowSet cachedRowSet;
//            cachedRowSet = new CachedRowSetImpl();
//            cachedRowSet.populate(rsMultipleTableCheck);
//            insertMultipleCheckStm = connection.prepareStatement(
//                    "SELECT * FROM table_mcharacters;"
//            );
//            rsMultipleTableCheck = insertMultipleCheckStm.executeQuery();
//            printResultsSet(rsMultipleTableCheck);
//            CachedRowSet cachedRowSet;
//            cachedRowSet = new CachedRowSetImpl();
//            cachedRowSet.populate(rsMultipleTableCheck);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void printResultsSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (resultSet.next()){
            for (int i=1; i<=columnCount; i++){//kolumny zaczyanja się od 1
                String colVal = resultSet.getString(i);
                System.out.print(colVal + "\t");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<String>> getResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while (resultSet.next()){
            ArrayList<String> column = new ArrayList<>();
            for (int i=1; i<=columnCount; i++){//kolumny zaczynaja się od 1
                String string = resultSet.getString(i).toString();
                column.add(string);
            }
            result.add(column);
        }
        return result;
    }

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
