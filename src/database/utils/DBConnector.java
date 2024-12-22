package database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DBConnector {
    private static final String DB_CONNECTION;
    private static final String DB_HOST;
    private static final String DB_USER;
    private static final String DB_PASSWORD;
    private static final String DB_DRIVER;
    private static final String DB_PORT;
    private static final String DB_DATABASE;
    private static Connection connection;
    private static String CONNECT_URL;

    static {
        DB_CONNECTION = System.getenv("DB_CONNECTION");
        DB_HOST = System.getenv("DB_HOST");
        DB_USER = System.getenv("DB_USER");
        DB_PASSWORD = System.getenv("DB_PASSWORD");
        DB_DRIVER = System.getenv("DB_DRIVER");
        DB_PORT = System.getenv("DB_PORT");
        DB_DATABASE = System.getenv("DB_DATABASE");
        CONNECT_URL = new StringBuilder()
            .append("jdbc:")
            .append(DB_CONNECTION)
            .append("://")
            .append(DB_HOST)
            .append(":")
            .append(DB_PORT)
            .append("/")
            .append(DB_DATABASE)
            .toString();
    }

    public static void connectDB() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(CONNECT_URL, DB_USER, DB_PASSWORD);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnectDB() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet crs;
        connectDB();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        crs = RowSetProvider.newFactory().createCachedRowSet();
        crs.populate(resultSet);
        if(resultSet != null) {
            resultSet.close();
        }
        if(statement != null) {
            statement.close();
        }
        disconnectDB();
        return crs;
    }

    public static void executeUpdate(String query) throws SQLException {
        Statement statement = null;
        try {
            connectDB();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            if(statement != null) {
                statement.close();
            }
            disconnectDB();
        }
    }
}
