package pl.indexpz.dbmanager.entity;

import pl.indexpz.dbmanager.entity.User;

import java.sql.PreparedStatement;

public class UserDao extends User {
    private static final String CREATE_USER_QUERY = "INSERT  INTO  users ( name, password, email) VALUES (?,?,?);";


    public UserDao(String name, String password, String email) {
        super(name, password, email);
    }

    public User create (User user) {
        PreparedStatement preStmt =  conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
user.getName() = CREATE_USER_QUERY.
        return user;
    }

    public User read (int userId){
        User newUser = new User("Ala", "makota", "ala@gmail.com");
        return newUser;
    }

    public void update(User user){

    }

    public User[] findAll(){
        User[] tempUser = new User[0];
        return tempUser;
    }

    public void delete(int userId){

    }


}
