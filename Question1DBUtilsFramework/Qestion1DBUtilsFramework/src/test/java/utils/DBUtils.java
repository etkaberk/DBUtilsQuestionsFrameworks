package utils;

import com.sun.javafx.collections.MappingChange;

import java.sql.*;
import java.util.*;

public class DBUtils {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(
                    ConfigReader.getProperty("dbUrl"),
                    ConfigReader.getProperty("username"),
                    ConfigReader.getProperty("password")
            );
            System.out.println("DB connection is done ! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void destroy() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
public static List<Map<String,Object>> getQueryResultMap(String query){
        executeQuery(query);
        List<Map<String,Object>> result = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()){
                Map<String,Object> colNameValueMap = new HashMap<>();
                for(int i = 1; i <= rsmd.getColumnCount();i++){
                    colNameValueMap.put(rsmd.getColumnName(i),resultSet.getObject(i));
                }
                result.add(colNameValueMap);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
