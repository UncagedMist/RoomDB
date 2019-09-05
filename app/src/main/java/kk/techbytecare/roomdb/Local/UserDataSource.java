package kk.techbytecare.roomdb.Local;

import java.util.List;

import io.reactivex.Flowable;
import kk.techbytecare.roomdb.DB.IUserDataSource;
import kk.techbytecare.roomdb.Model.User;

public class UserDataSource implements IUserDataSource {

    private UserDAO userDAO;
    private static UserDataSource instance;

    public UserDataSource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static UserDataSource getInstance(UserDAO userDAO)   {

        if (instance == null)   {

            instance = new UserDataSource(userDAO);
        }

        return instance;
    }

    @Override
    public Flowable<User> getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        userDAO.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        userDAO.updateUser(users);
    }

    @Override
    public void deleteUser(User... users) {
        userDAO.deleteUser(users);
    }

    @Override
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }

    @Override
    public Flowable<List<User>> getUserList(String search) {
        return userDAO.getUserList(search);
    }
}
