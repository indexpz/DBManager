package pl.indexpz.dbmanager;


import pl.indexpz.dbmanager.entity.DBUtil;
import pl.indexpz.dbmanager.entity.User;
import pl.indexpz.dbmanager.entity.UserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

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


        User halina = new User("Halina", "aaaabbb", "halina@wp.pl");
        UserDao halinaDau = new UserDao();
        halinaDau.create(halina);
        System.out.println("-------------------------");

        User bartek = new User("Bartek", "ketrab", "bartek@wp.pl");
        UserDao bartekDao = new UserDao();
        bartekDao.create(bartek);
        System.out.println("-------------------------");


        User michal = new User("Michał", "tttyyyy", "michał@wp.pl");
        UserDao michalDao = new UserDao();
        michalDao.create(michal);

        System.out.println("-------------------------");


        System.out.println("Zahashowane hasło");
        User barbara = new User("Barbara", "barbarella", "baska@onet.pl");
        UserDao barbaraDao = new UserDao();
        barbaraDao.create(barbara);
        System.out.println("-------------------------");


        System.out.println("Id " + barbara.getName() + " = " + barbaraDao.getUserIdFromDB(barbara));

        System.out.println("-------------------------");
        User jurek = new User("Jurek", "huhuha", "jurek@wp.pl");
        UserDao jurekDao = new UserDao();
        jurekDao.create(jurek);


        System.out.println("-------------------------");


        System.out.println(michalDao.read(14));
        System.out.println(jurekDao.read(17));
        System.out.println(jurekDao.read(170));


        System.out.println("-------------------------");
        UserDao dawidDao = new UserDao();
        dawidDao.read(17);
        dawidDao.setName("Dawid");
        dawidDao.setPassword("goliat");
        dawidDao.setEmail("gawid@gmail.com");

        System.out.println(dawidDao);

        dawidDao.update(jurekDao);
//        jurekDaoUpdate.setName("JerzY");
//        jurekDaoUpdate.setPassword("ZyrafyDoszafy");
//        jurekDaoUpdate.setEmail("jerzy_@gmail.com");
//        jurekDaoUpdate.update(jurekDaoUpdate);
//
//        System.out.println(jurekDaoUpdate);

        System.out.println("-------------------------");


        System.out.println("-------------------------");

//
//        System.out.println(jurekDaoUpdate);

        System.out.println("-------------------------");


        User zosia = new User();
        zosia.setName("Zosia");
        zosia.setPassword("samosia");
        zosia.setEmail("zosia@gmail.com");
        UserDao zosiaDao = new UserDao();
        zosiaDao.create(zosia);


        User stasia = new User();
        stasia.setName("Stasia");
        stasia.setPassword("jasia");
        stasia.setEmail("stasia@gmail.com");
        userDao.create(stasia);


        User userToUpdate = userDao.read(21);
        userToUpdate.setName("Stanisława");
        userToUpdate.setPassword("maJasia");
        userToUpdate.setEmail("stanislawa@gmail.com");
        userDao.update(userToUpdate);


        User userToDelete = userDao;
        userDao.delete(20);
        userDao.delete(30);

//        User secondUser = new User();
//        secondUser.setName("Marek");
//        secondUser.setEmail("marek@coderslab.pl");
//        secondUser.setPassword("password");
//        userDao.create(secondUser);
        User[] all = userDao.findAll();
        for (User u : all) {
                System.out.println(u);
            }
        System.out.println("-------------------------");

        User[] printAll = userDao.findAll();
        for (int i = 0; i < printAll.length; i++) {
            System.out.println(printAll[i]);

        }

//        UserDao.showTableOfUsers();
    }
}
