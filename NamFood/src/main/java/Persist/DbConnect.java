package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DbConnect {

    private static DbConnect instance;

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String PROTOCOL = "jdbc:mysql:";
    static final String HOST = "remotemysql.com:3306";
    static final String BD_NAME = "vyTZacrX0C";
    static final String USER = "vyTZacrX0C";
    static final String PASSWORD = "IklmroMKNT";
    static final String PARAMS = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private DbConnect() throws ClassNotFoundException {
        loadDriver();
    }

    /**
     * gets and returns the instance to database
     *
     * @return instance
     * @throws ClassNotFoundException
     */
    public static DbConnect getInstance() throws ClassNotFoundException {
        if (instance == null) {
            instance = new DbConnect();
        }
        return instance;
    }

    public void loadDriver() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }

    /**
     * gets and returns a connection to database
     *
     * @return connection
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        final String BD_URL = String.format("%s//%s/%s?%s", PROTOCOL, HOST, BD_NAME, PARAMS);
        Connection conn = null;
        conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        return conn;
    }
}