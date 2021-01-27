package pl.indexpz.dbmanager;


import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection db_manager_conn = DBUtil.conn("db_manager")){
            System.out.println("Połączono z bazą danych.....");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych." + ex);
        }
    }
}
