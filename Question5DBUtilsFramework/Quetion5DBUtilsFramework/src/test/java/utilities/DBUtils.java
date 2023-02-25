package utilities;

import java.sql.*;
import java.util.*;

public class DBUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void createConnection() throws SQLException{
        connection = DriverManager.getConnection(
                ConfigReader.getProperties("dbUrl"),
                ConfigReader.getProperties("username"),
                ConfigReader.getProperties("password")

        );
        System.out.println("connection created!");

    }
    public static void executeQuery(String query) throws SQLException{
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet= statement.executeQuery(query);

            }

public static void destroy() throws SQLException{
    if (connection != null) {
        connection.close();
    }

    if (statement != null) {
        statement.close();
    }

    if (resultSet != null) {
        resultSet.close();
    }
}
public static List<Map<String, Integer>> getQueryResultMap(String query) throws SQLException{
    executeQuery(query);
    List<Map<String, Integer>> rowList = new ArrayList<>();
    ResultSetMetaData rsmd = resultSet.getMetaData();


    while (resultSet.next()) {
        Map<String, Integer> colNameValueMap = new HashMap<>();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            colNameValueMap.put(rsmd.getColumnName(i), resultSet.getInt(i));
        }
        rowList.add(colNameValueMap);
    }return rowList;
}


}
