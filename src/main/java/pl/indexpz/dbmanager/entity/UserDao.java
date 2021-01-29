package pl.indexpz.dbmanager.entity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends User {
    /**
     * CRUD
     */
    private static final String CREATE_USER_QUERY = "INSERT  INTO  users (name, password, email) VALUES (?,?,?);";
    private static final String READ_USER_QUERY = "SELECT name, password, email FROM users WHERE id =  + userId + ;";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET name = 'Beata', password = 'sniezka', email='beata@gmial.com' WHERE id = '4';";
    private static final String REMOVE_USER_QUERY = "DELETE FROM users WHERE id = '4';";

    private static final String All_QUERY = "SELECT * FROM users;";

    public UserDao() {
    }

    public UserDao(String name, String password, String email) {
        super(name, password, email);
    }


    public User create(User user) {
        if (isUserExist(user)) {
            System.out.println("Użytkownik znajduje się już w bazie danych.");
        } else {
            try (Connection db_manager_conn = DBUtil.conn("db_manager")) {
                String query = "INSERT  INTO  users ( name, password, email) VALUES (?,?,?);";
                DBUtil.insert(db_manager_conn, query, user.getName(), user.getPassword(), user.getEmail());

                PreparedStatement preStmt = db_manager_conn.prepareStatement(All_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
                ResultSet resultSet = preStmt.getGeneratedKeys();
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    System.out.println("ID urzytkownika " + id);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
            }
            System.out.println("Dodano użytkownika " + user.getName() + " do bazy danych.");
        }

        return user;
    }

    private String hashPassword(){
        return "";
    }


    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public static void showTableUsers() {
        try (Connection db_manager_conn = DBUtil.conn("db_manager")) {
            DBUtil.printData(db_manager_conn, All_QUERY, "id", "name", "password", "email");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
        }
    }

    public Boolean isUserExist(User user) {
        Boolean result = false;
        try (Connection db_manager_conn = DBUtil.conn("db_manager")) {
            PreparedStatement preparedStatement = db_manager_conn.prepareStatement(All_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String emailToCheck = resultSet.getString("email");

                if (emailToCheck.equalsIgnoreCase(user.getEmail())) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
        }
        return result;
    }


//    public User read(int userId) {
//        User tempUser = new User();
//        String query = "SELECT name, password, email FROM users WHERE id = " + userId + ";";
//        try (Connection db_manager_conn = DBUtil.conn("db_manager")) {
//            PreparedStatement preparedStatement = db_manager_conn.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                tempUser.setName(resultSet.getString("name"));
//                tempUser.setPassword(resultSet.getString("password"));
//                tempUser.setEmail(resultSet.getString("email"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException("Nie udało połączyć się z bazą danych. " + ex);
//        }
//        return tempUser;
//    }
//
//    public void update(User user) {
//
//    }
//
//    public User[] findAll() {
//        User[] tempUser = new User[0];
//        return tempUser;
//    }
//
//    public void delete(int userId) {
//
//    }


}
