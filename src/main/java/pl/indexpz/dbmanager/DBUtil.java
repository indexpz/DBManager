package pl.indexpz.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";
    private static final String DB_PARAMS = "?characterEncoding=utf8";




    public static Connection conn(String dbName) throws SQLException {
        String sql = DB_URL + (dbName != null ? "/" + dbName : "")+ DB_PARAMS;
        Connection conn = DriverManager.getConnection(sql, DB_USER, DB_PASS);
        return conn;
    }

}
