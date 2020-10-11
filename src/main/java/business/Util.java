package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/webproj";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "1234";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println("Connection OK");
        return connection;
    }
}
