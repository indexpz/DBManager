package pl.indexpz.dbmanager;


import pl.indexpz.dbmanager.entity.DBUtil;
import pl.indexpz.dbmanager.entity.User;
import pl.indexpz.dbmanager.entity.UserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        User tadeusz = new User("Tadeusz", "imiePsa", "tadeusz@wp.pl");
        System.out.println(tadeusz.toString());

        try (Connection connection = DBUtil.conn("db_manager")) {
            System.out.println("Udało się połączyć z bazą danych........");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nie udało połączyć się z bazą danych." + ex);
        }
        System.out.println("-------------------------");

        UserDao beata = new UserDao("Beata", "posprzątane", "beata@gmail.com");
        System.out.println(beata.toString());
        System.out.println("-------------------------");

        User krysia = new User("Krysia", "yyyaaa", "krysia@onet.pl");
        UserDao krysiaDao = new UserDao();
        System.out.println(krysia.getPassword());
        System.out.println("-------------------------");

        krysiaDao.create(krysia);
        System.out.println("-------------------------");


        System.out.println("Czy user Krysia już istnieje? " + krysiaDao.isUserExist(krysia));
        System.out.println("-------------------------");
        UserDao.showTableUsers();
        System.out.println("-------------------------");

        User halina = new User("Halina", "aaaabbb", "halina@wp.pl");
        UserDao halinaDau = new UserDao();
        halinaDau.create(halina);
        System.out.println("-------------------------");

        User bartek = new User ("Bartek", "ketrab", "bartek@wp.pl");
        UserDao bartekDao = new UserDao();
        bartekDao.create(bartek);
        System.out.println("-------------------------");


        User michal = new User("Michał", "tttyyyy", "michał@wp.pl");
        UserDao michalDao = new UserDao();
        michalDao.create(michal);

        System.out.println("-------------------------");

        UserDao.showTableUsers();


//        try (Connection db_manager_conn = DBUtil.conn("db_manager")){
//            System.out.println("Połączono z bazą danych.....");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException("Nie udało połączyć się z bazą danych." + ex);
//        }

//        UserDao userDao = new UserDao("Jan", "haslo" , "jan@wp.pl");
//        User user = new User();
//        user.setName("Arek");
//        user.setEmail("arkadiusz.jozwiak@coderslab.pl");
//        user.setPassword("pass");
//        userDao.create(user);

//        UserDao bambi = new UserDao("Bambi", "sniezka", "bambi@yahoo.com");
//        bambi.create(bambi);

//        User zuzia = new User("Zuzia", "taknie", "zuzia@gmali.com");
//        UserDao zuzia = new UserDao("Zuzia", "taknie", "zuzia@gmali.com");
//        UserDao.create(zuzia);

//        UserDao adas = new UserDao();
//        adas.read(2);

    }
}
