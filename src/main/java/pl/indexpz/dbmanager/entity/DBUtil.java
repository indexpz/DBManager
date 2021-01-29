package pl.indexpz.dbmanager.entity;

import java.sql.*;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";
    private static final String DB_PARAMS = "?characterEncoding=utf8";


    public static Connection conn(String dbName) throws SQLException {
        String sql = DB_URL + (dbName != null ? "/" + dbName : "") + DB_PARAMS;
        Connection conn = DriverManager.getConnection(sql, DB_USER, DB_PASS);
        return conn;
    }


    public static void insert(Connection conn, String query, String... params) {
        try (PreparedStatement prepareStatement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                prepareStatement.setString(i + 1, params[i]);
            }
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) {
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    System.out.println(resultSet.getString(param));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
        }
    }




//    public static void insertIntoUsers(Connection conn, String name, String password, String email) {
//        try (PreparedStatement statement = conn.prepareStatement("INSERT  INTO  users ( name, password, email) VALUES (?,?,?);")) {
//            statement.setString(1, name);
//            statement.setString(2, password);
//            statement.setString(3, email);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
//        }
//    }


}
